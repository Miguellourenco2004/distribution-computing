import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseServer extends UnicastRemoteObject implements DatabaseService {
    private static final long serialVersionUID = 1L;

    public DatabaseServer() throws RemoteException {
        super();
    }

    public Connection createConnection() {
        Connection connection = null;

        try {
            // Carregando o driver JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao carregar o driver JDBC para MySQL.", e);
        }

        // URL de conexão para MySQL
        String url = "jdbc:mysql://localhost:3306/clinicas?useSSL=false&serverTimezone=UTC";
        String usuario = "root"; // Substitua pelo seu usuário MySQL
        String senha = "NovaSenhaAqui"; // Substitua pela sua senha MySQL

        try {
            // Estabelecendo a conexão
            connection = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados MySQL.", e);
        }

        return connection;
    }

    @Override
    public List<String> queryDatabase(String query) throws RemoteException {
        List<String> results = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = createConnection();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            int numberColumns = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                results.add(resultSet.getMetaData().getColumnName(1));
                for (int i = 1; i <= numberColumns; i++) {
                    results.add(resultSet.getString(i) + " ");
                }
                results.add("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (statement != null) statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return results;
    }

    @Override
    public boolean createPacient(String primeiroNome, String ultimoNome, int id_usuario) throws RemoteException {
        int linhasAfetadas = 0;
        PreparedStatement statement = null;
        Connection connection = createConnection();

        String sql = "INSERT INTO Pacientes (PacienteID, PrimeiroNome, UltimoNome) VALUES (?, ?, ?)";


        try {
            statement = connection.prepareStatement(sql);
            statement.setString(2, primeiroNome);
            statement.setString(3, ultimoNome);
            statement.setInt(1, id_usuario);

            linhasAfetadas = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try { if (statement != null) statement.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return linhasAfetadas > 0;
    }

    @Override
    public boolean marcarConsulta(String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas, int usuarioId) {

        Connection connection = createConnection();

        // Query para encontrar o paciente associado ao usuarioId
        String findPacienteQuery = "SELECT PacienteID FROM Pacientes WHERE PacienteID = ?";

        try (PreparedStatement findPacientePs = connection.prepareStatement(findPacienteQuery)) {
            findPacientePs.setInt(1, usuarioId);

            try (ResultSet rsPaciente = findPacientePs.executeQuery()) {
                if (rsPaciente.next()) {
                    int pacienteId = rsPaciente.getInt("PacienteID");

                    // Query para encontrar um médico disponível
                    String findMedicoQuery = "SELECT m.MedicoID "
                            + "FROM Medicos m "
                            + "INNER JOIN Clinicas c ON m.ClinicaFK = c.ClinicaID "
                            + "INNER JOIN Especialidades e ON m.EspecialidadeFK = e.EspecialidadeID "
                            + "LEFT JOIN Consultas con ON m.MedicoID = con.MedicoFK "
                            + "WHERE c.Nome = ? "
                            + "AND e.Nome = ? "
                            + "AND TIME(?) >= '08:00:00' "
                            + "AND TIME(?) < '20:00:00' "
                            + "AND NOT EXISTS ("
                            + "    SELECT 1 "
                            + "    FROM Consultas con2 "
                            + "    WHERE con2.MedicoFK = m.MedicoID "
                            + "    AND DATE(con2.DataConsulta) = DATE(?) "
                            + "    AND ("
                            + "        TIME(?) >= TIME(con2.DataConsulta) "
                            + "        AND TIME(?) < ADDTIME(TIME(con2.DataConsulta), '01:00:00') "
                            + "    )"
                            + ") "
                            + "AND NOT EXISTS ("
                            + "    SELECT 1 "
                            + "    FROM Consultas con3 "
                            + "    WHERE con3.PacienteFK = ? "
                            + "    AND DATE(con3.DataConsulta) = DATE(?) "
                            + "    AND TIME(con3.DataConsulta) = TIME(?) "
                            + ") "
                            + "ORDER BY m.MedicoID "
                            + "LIMIT 1";

                    try (PreparedStatement findMedicoPs = connection.prepareStatement(findMedicoQuery)) {
                        findMedicoPs.setString(1, clinicaNome);
                        findMedicoPs.setString(2, especialidade);
                        findMedicoPs.setString(3, dataHoraConsulta);
                        findMedicoPs.setString(4, dataHoraConsulta);
                        findMedicoPs.setString(5, dataHoraConsulta);
                        findMedicoPs.setString(6, dataHoraConsulta);
                        findMedicoPs.setString(7, dataHoraConsulta);
                        findMedicoPs.setInt(8, pacienteId);
                        findMedicoPs.setString(9, dataHoraConsulta);
                        findMedicoPs.setString(10, dataHoraConsulta);

                        try (ResultSet rsMedico = findMedicoPs.executeQuery()) {
                            if (rsMedico.next()) {
                                int medicoId = rsMedico.getInt("MedicoID");

                                if (inserirConsulta(clinicaNome, medicoId, dataHoraConsulta, sintomas, pacienteId)) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                System.out.println("Nenhum médico disponível.");
                                return false;
                            }
                        }
                    }
                } else {
                    System.out.println("Paciente não encontrado.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean cancelarConsultaPorUsuario(int idUsuario, String dataHoraConsulta) {
        // Normaliza o formato da dataHoraConsulta
        dataHoraConsulta = normalizarDataHora(dataHoraConsulta);

        Connection connection = createConnection();

        String selectPacienteQuery = "SELECT PacienteID FROM Pacientes WHERE PacienteID = ?";

        int pacienteId = -1;

        try (PreparedStatement selectPs = connection.prepareStatement(selectPacienteQuery)) {
            selectPs.setInt(1, idUsuario);

            try (ResultSet resultSet = selectPs.executeQuery()) {
                if (resultSet.next()) {
                    pacienteId = resultSet.getInt("PacienteID");
                } else {
                    System.out.println("Paciente não encontrado para o usuário fornecido.");
                    return false;
                }
            }

            if (pacienteId != -1) {
                String deleteQuery = "DELETE FROM Consultas WHERE PacienteFK = ? "
                        + "AND DataConsulta = STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s')";

                try (PreparedStatement deletePs = connection.prepareStatement(deleteQuery)) {
                    deletePs.setInt(1, pacienteId);
                    deletePs.setString(2, dataHoraConsulta);

                    int rowsAffected = deletePs.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Consulta cancelada com sucesso.");
                        return true;
                    } else {
                        System.out.println("Consulta não encontrada ou não pode ser cancelada.");
                        return false;
                    }
                }
            } else {
                System.out.println("Erro: Paciente ID inválido.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    // Método para normalizar o formato da data
    private String normalizarDataHora(String dataHora) {
        if (dataHora.contains(".")) {
            return dataHora.split("\\.")[0]; // Remove a parte após o ponto (milissegundos)
        }
        return dataHora;
    }


    public boolean inserirConsulta(String clinicaNome, int medicoId, String dataHoraConsulta, String sintomas, int pacienteId) {

        Connection connection = createConnection();

        String insertQuery = "INSERT INTO Consultas (Sintomas, ClinicaFK, MedicoFK, DataConsulta, PacienteFK) " +
                "VALUES (?, " +
                "       (SELECT ClinicaID FROM Clinicas WHERE Nome = ?), " +
                "       ?, " +
                "       ?, " +
                "       ?);";

        try (PreparedStatement insertPs = connection.prepareStatement(insertQuery)) {
            insertPs.setString(1, sintomas); // Sintomas
            insertPs.setString(2, clinicaNome); // Nome da clínica
            insertPs.setInt(3, medicoId); // ID do médico
            insertPs.setString(4, dataHoraConsulta); // Data e hora da consulta
            insertPs.setInt(5, pacienteId); // ID do paciente

            insertPs.executeUpdate();
            System.out.println("Consulta marcada com sucesso.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<String> listarConsultas(int PacienteId) {
        PreparedStatement stmt = null;
        Connection connection = createConnection();
        String queryPaciente = "SELECT PacienteID FROM Pacientes WHERE PacienteID = ?";
        String queryConsultas = "SELECT MedicoFK, DataConsulta, ClinicaFK, Sintomas FROM Consultas WHERE PacienteFK = ? ORDER BY DataConsulta ASC";
        List<String> consultasFormatadas = new ArrayList<>();

        try {
            // 1. Obter o PacienteID a partir do idUsuario
            stmt = connection.prepareStatement(queryPaciente);
            stmt.setInt(1, PacienteId);

            ResultSet rsPaciente = stmt.executeQuery();
            int pacienteId = -1;  // Variável para armazenar o PacienteID

            if (rsPaciente.next()) {
                pacienteId = rsPaciente.getInt("PacienteID");
            } else {
                // Se o paciente não for encontrado, lançar uma exceção ou retornar uma lista vazia
                throw new SQLException("Paciente não encontrado para o usuário com id " + PacienteId);
            }

            // 2. Executar a consulta para obter as consultas do PacienteID
            stmt = connection.prepareStatement(queryConsultas);
            stmt.setInt(1, pacienteId);

            ResultSet rsConsultas = stmt.executeQuery();

            while (rsConsultas.next()) {
                int medicoId = rsConsultas.getInt("MedicoFK");
                String dataConsulta = String.valueOf(rsConsultas.getTimestamp("DataConsulta"));
                int clinicaId = rsConsultas.getInt("ClinicaFK");
                String sintomas = rsConsultas.getString("Sintomas");

                // Obter informações do médico
                String queryMedico = "SELECT PrimeiroNome, UltimoNome FROM Medicos WHERE MedicoID = ?";
                PreparedStatement stmt2 = connection.prepareStatement(queryMedico);
                stmt2.setInt(1, medicoId);

                ResultSet rsMedico = stmt2.executeQuery();
                String primeiroNome = "", ultimoNome = "";
                if (rsMedico.next()) {
                    primeiroNome = rsMedico.getString("PrimeiroNome");
                    ultimoNome = rsMedico.getString("UltimoNome");
                }

                // Obter informações da clínica
                String queryClinica = "SELECT Nome, Morada FROM Clinicas WHERE ClinicaID = ?";
                PreparedStatement stmt3 = connection.prepareStatement(queryClinica);
                stmt3.setInt(1, clinicaId);

                ResultSet rsClinica = stmt3.executeQuery();
                String nomeClinica = "", moradaClinica = "";
                if (rsClinica.next()) {
                    nomeClinica = rsClinica.getString("Nome");
                    moradaClinica = rsClinica.getString("Morada");
                }

                // Formatar a consulta como uma string no formato desejado
                String consultaString = nomeClinica + "," + primeiroNome + " " + ultimoNome + "," +
                        dataConsulta + "," + moradaClinica  + "," +  sintomas;

                // Adicionar a consulta formatada à lista
                consultasFormatadas.add(consultaString);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return consultasFormatadas;
    }


    @Override
    public List<String> listarClinicas(String especialidade, String dataHoraConsulta) throws RemoteException {
        System.out.println("teste1"+especialidade);
        System.out.println("teste2"+dataHoraConsulta);
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Connection connection = createConnection();
        String query = "SELECT DISTINCT c.ClinicaID, c.Nome AS NomeClinica FROM Medicos m " +
                "INNER JOIN Clinicas c ON m.ClinicaFK = c.ClinicaID " +
                "INNER JOIN Especialidades e ON m.EspecialidadeFK = e.EspecialidadeID " +
                "LEFT JOIN Consultas con ON m.MedicoID = con.MedicoFK " +
                "WHERE e.Nome = ? " +
                "AND CAST(? AS TIME) >= '08:00:00' " +
                "AND CAST(? AS TIME) < '20:00:00' " +
                "AND NOT EXISTS ( " +
                "    SELECT 1 " +
                "    FROM Consultas con2 " +
                "    WHERE con2.MedicoFK = m.MedicoID " +
                "    AND CAST(con2.DataConsulta AS DATE) = CAST(? AS DATE) " +
                "    AND ( " +
                "        CAST(? AS TIME) >= CAST(con2.DataConsulta AS TIME) " +
                "        AND CAST(? AS TIME) < DATE_ADD(CAST(con2.DataConsulta AS TIME), INTERVAL 1 HOUR) " +
                "    ) " +
                ");";

        List<String> clinics = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(query);

            // Certifique-se de passar a data e hora no formato correto.
            stmt.setString(1, especialidade);
            stmt.setString(2, dataHoraConsulta); // Hora da consulta (ex: "17:00:00")
            stmt.setString(3, dataHoraConsulta); // Hora da consulta (ex: "17:00:00")
            stmt.setString(4, dataHoraConsulta); // Data da consulta (ex: "2024-12-18")
            stmt.setString(5, dataHoraConsulta); // Hora da consulta (ex: "17:00:00")
            stmt.setString(6, dataHoraConsulta); // Hora da consulta (ex: "17:00:00")

            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                clinics.add(resultSet.getString("NomeClinica"));
                System.out.println(resultSet.getString("NomeClinica"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        return clinics;
    }


    public static void main(String[] args) {
        try {
            // RMI
            DatabaseServer server = new DatabaseServer();
            System.setProperty("java.rmi.server.hostname", "192.168.64.8");
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("DatabaseService", server);
            System.out.println("Servidor RMI iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
