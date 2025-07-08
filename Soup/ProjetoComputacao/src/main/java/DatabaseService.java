import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface DatabaseService extends Remote {
	
    List<String> queryDatabase(String query) throws RemoteException;

    boolean createPacient(String primeiroNome, String ultimoNome, int id_usuario) throws RemoteException;
    List<String> listarClinicas(String especialidade, String dataHoraConsulta) throws RemoteException;
    boolean marcarConsulta(String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas, int usuarioId);
    List<String> listarConsultas(int PacienteId) throws RemoteException;
    boolean cancelarConsultaPorUsuario(int idUsuario, String dataHoraConsulta) throws RemoteException;

}


