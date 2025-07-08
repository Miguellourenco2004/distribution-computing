
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Consumes("application/json")
@Produces("application/json")
public class CalcREST {
 
	@POST
	@Path("/add")	
    public String add(String data) {
    		  Integer number1=0, number2=0, number3=0;
    	      String[] info = data.split(",");
    	      number1=Integer.valueOf(info[0]);
    	      number2=Integer.valueOf(info[1]);
    	      number3=number1+number2;
    	      String result = ""+number3;
    	      return result;
    	
    }
	
	  // Método para calcular o fatorial de um número
    @POST
    @Path("/factorial")
    public int factorial(String json) {
        try {
            int number = Integer.parseInt(json.split("\"number\":")[1].split("}")[0]);
            if (number < 0) return -1; // Número inválido
            int result = 1;
            for (int i = 1; i <= number; i++) {
                result *= i;
            }
            return result;
        } catch (Exception e) {
        	  e.printStackTrace();
            return -1; // Retorna -1 em caso de erro
        }
    }

    // Método para realizar uma consulta ao servidor de autenticação
    @GET
    @Path("/queryAuthServerTest")
    public List<String> queryAuthServerTest() {
        try {
            AuthServerConn authServer = new AuthServerConn();
            return authServer.queryAuthServerTest();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retorna null em caso de erro
        }
    }

    @POST
    @Path("/register")
    public String registarUtilizador(String json) {
        try {
            // Processar o JSON recebido
            String email = json.split("\"email\":\"")[1].split("\"")[0];
            String password = json.split("\"password\":\"")[1].split("\"")[0];

            AuthServerConn authServer = new AuthServerConn();
            boolean resultado = authServer.registarUtilizador(email, password);

            // Retornar "true" ou "false" como String
            return String.valueOf(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma mensagem de erro como String
            return "error";
        }
    }



    // Método para obter o ID de um usuário pelo e-mail
    @GET
    @Path("/getUserId")
    public String obterIdUtilizador(@QueryParam("email") String email, @QueryParam("password") String password) {
        try {
            AuthServerConn authServer = new AuthServerConn();
            int userId = authServer.obterIdUtilizador(email);
            
            // Converte o ID para String e retorna
            return String.valueOf(userId);
        } catch (Exception e) {
            e.printStackTrace();
            // Retorna uma mensagem de erro como String
            return "error";
        }
    }


    // Método para fazer login de um usuário
    @POST
    @Path("/login")
    public String loginUtilizador(String json) {
        try {
            String email = json.split("\"email\":\"")[1].split("\"")[0];
            String password = json.split("\"password\":\"")[1].split("\"")[0];
            AuthServerConn authServer = new AuthServerConn();
            boolean resultado =  authServer.loginUtilizador(email, password);
            // Retornar "true" ou "false" como String
            return String.valueOf(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma mensagem de erro como String
            return "error";
        }
    }

    @POST
    @Path("/createPatient")
    public String criarPaciente(String json) {
        try {
            // Extrai os valores do JSON manualmente
            String firstName = json.split("\"firstName\":\"")[1].split("\"")[0];
            String lastName = json.split("\"lastName\":\"")[1].split("\"")[0];
            int userId = Integer.parseInt(json.split("\"userId\":")[1].split("}")[0]);
            System.out.println(" primeiro nome -> " + firstName); 
            // Debug 4
            System.out.println(" primeiro nome -> " + lastName); 
            System.out.println(" primeiro nome -> " + userId); 
            
            // Chama o método do banco de dados
            boolean sucesso = DatabaseClient.criarPaciente(firstName, lastName, userId);

            // Retorna "success" ou "error" como string
            return String.valueOf(sucesso);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // Retorna "error" em caso de falha
        }
    }

    
    @POST
    @Path("/marcarConsulta")
    public String marcarConsulta(String json) {
    	
        try {
        	 System.out.println("marcarconsuta"+json);
            // Extrair os dados do JSON recebido
            String clinicaNome = json.split("\"clinicaNome\":\"")[1].split("\"")[0];
            String especialidade = json.split("\"especialidade\":\"")[1].split("\"")[0];
            String dataHoraConsulta = json.split("\"dataHoraConsulta\":\"")[1].split("\"")[0];
            String sintomas = json.split("\"sintomas\":\"")[1].split("\"")[0];
            int usuarioId = Integer.parseInt(json.split("\"idUsuario\":")[1].split(",|}|\s")[0]);


            // Chamar o método para marcar a consulta
            boolean resultado = DatabaseClient.marcarConsulta(clinicaNome, especialidade, dataHoraConsulta, sintomas, usuarioId);

            // Retornar "true" ou "false" como String
            return String.valueOf(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma mensagem de erro como String
            return "error";
        }
    }

    
    
    @GET
    @Path("/listarClinicas")
    public String listarClinicas(@QueryParam("especialidade") String especialidade, @QueryParam("dataHoraConsulta") String dataHoraConsulta) {
        try {
        	 System.out.println( especialidade );
        	 System.out.println( dataHoraConsulta );
            // Chama o método no DatabaseClient para obter a lista de clínicas
            List<String> clinics = DatabaseClient.listarConsultas(especialidade, dataHoraConsulta);
            
            System.out.println("Clínicas retornadas do DatabaseClient:");
            if (clinics != null) {
                for (String clinic : clinics) {
                    System.out.println(clinic);
                }
            } else {
                System.out.println("A lista de clínicas é nula.");
            }

            // Converte a lista de clínicas para formato JSON
            StringBuilder jsonResponse = new StringBuilder("[");
            for (int i = 0; i < clinics.size(); i++) {
                jsonResponse.append("\"").append(clinics.get(i)).append("\"");
                if (i < clinics.size() - 1) {
                    jsonResponse.append(",");
                }
            }
            jsonResponse.append("]");

            // Retorna o JSON como String
            return jsonResponse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            // Retorna uma mensagem de erro em formato JSON
            return "{\"error\":\"Ocorreu um erro ao listar as clínicas\"}";
        }
    }

    

    @POST
    @Path("/queryDatabase")
    public String queryDatabase(String json) {
        try {
            // Extrair a query do JSON recebido
            String query = json.split("\"query\":\"")[1].split("\"")[0];

            // Chamar o método para realizar a consulta no banco de dados
            List<String> result = DatabaseClient.queryDatabase(query);

            // Retornar o resultado da consulta como uma String
            return String.join(",", result);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma mensagem de erro como String
            return "error";
        }
    }
    
    @GET
    @Path("/listarConsultasPaciente")
    public String listarConsultasPaciente(@QueryParam("PacienteId") int PacienteId) {
        try {
            // Chama o método no DatabaseClient para obter a lista de consultas do paciente
            List<String> consultas = DatabaseClient.listarConsultasPaciente(PacienteId);
            System.out.println("Primeiro1"+consultas);
            System.out.println("Consultas retornadas do DatabaseClient:");
            if (consultas != null) {
                for (String consulta : consultas) {
                    System.out.println(consulta);
                }
            } else {
                System.out.println("A lista de consultas é nula.");
            }

            // Converte a lista de consultas para formato JSON
            StringBuilder jsonResponse = new StringBuilder("[");
            for (int i = 0; i < consultas.size(); i++) {
                jsonResponse.append("\"").append(consultas.get(i)).append("\"");
                if (i < consultas.size() - 1) {
                    jsonResponse.append(",");
                }
            }
            jsonResponse.append("]");

            // Retorna o JSON como String
            return jsonResponse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            // Retorna uma mensagem de erro em formato JSON
            return "{\"error\":\"Ocorreu um erro ao listar as consultas\"}";
        }
    }

    @POST
    @Path("/cancelarConsulta")
    public String cancelarConsulta(String json) {
        try {
            System.out.println("cancelarConsulta: " + json);
            
            // Extrair os dados do JSON recebido
            int idUsuario = Integer.parseInt(json.split("\"idUsuario\":")[1].split(",|}|\\s")[0]);
            String dataHoraConsulta = json.split("\"dataHoraConsulta\":\"")[1].split("\"")[0];

            // Chamar o método para cancelar a consulta
            boolean resultado = DatabaseClient.cancelarConsultaPorUsuario(idUsuario, dataHoraConsulta);

            // Retornar "true" ou "false" como String
            return String.valueOf(resultado);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma mensagem de erro como String
            return "error";
        }
    }


	
}