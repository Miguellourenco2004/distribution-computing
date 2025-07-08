import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;



public class DatabaseClient {

    public static void main(String[] args) throws RemoteException {

        // Definir uma query padrão caso nenhum argumento seja fornecido
        String query = "SELECT * FROM Medicos;"; // Exemplo de query padrão

        if (args.length >= 1) {
            query = args[0];
        } else {
            System.out.println("Nenhuma query fornecida. Usando query padrão: " + query);
        }

        try {
        	  String serverURL = "rmi://" + "192.168.64.8" + "/DatabaseService"; 
              DatabaseService service =( DatabaseService) Naming.lookup(serverURL); 


            List<String> results = service.queryDatabase("SELECT * FROM Medicos;");
            
            results.forEach(System.out::println);
        } catch (Exception e) {
        	 System.out.println("Exception: " + e);
             throw new RemoteException("Falhou ao reservar consulta", e);
        }
        
    }
    
   
    

    public static List<String> queryDatabase(String query) {
        try {
            // Localizar o registro RMI
            Registry registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
            DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

            // Fazer a query ao servidor
            List<String> results = service.queryDatabase(query);
            return results;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
    
    
    public static List<String> listarConsultas (String especialidade, String dataHoraConsulta){
    	 try {
    	     System.out.println("teste2"+dataHoraConsulta);
    	     System.out.println("teste1"+especialidade);
             // Localizar o registro RMI
             Registry registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
             DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

             // Fazer a query ao servidor
             List<String> clinics = service.listarClinicas(especialidade, dataHoraConsulta);
             return clinics;
             
         } catch (Exception e) {
             e.printStackTrace();
         }
 		return null;
    }
    
    
    public static boolean marcarConsulta (String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas, int usuarioId) {
    	 try {
             // Localizar o registro RMI
             Registry registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
             DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

             
             boolean resposta = service.marcarConsulta(clinicaNome, especialidade, dataHoraConsulta, sintomas, usuarioId);
             return resposta;
             
         } catch (Exception e) {
             e.printStackTrace();
         }
 		return false;
    }
    
    
    public static boolean criarPaciente (String primeiroNome, String ultimoNome, int id_usuario) {
    	
    	
    	Registry registry;
		try {
			registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
			DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");
			
			boolean result = service.createPacient(primeiroNome, ultimoNome, id_usuario);
			return result;
			 
			 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return false;
    }
    
    

    public static List<String> listarConsultasPaciente (int PacienteId) {
    	try {
    			
            Registry registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
            DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

            
            List<String> clinics = service.listarConsultas(PacienteId);
            return clinics;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
    

    public static boolean cancelarConsultaPorUsuario(int idUsuario, String dataHoraConsulta) {
    	try {
           
            Registry registry = LocateRegistry.getRegistry("192.168.64.8", 1099);
            DatabaseService service = (DatabaseService) registry.lookup("DatabaseService");

            
            boolean resposta = service.cancelarConsultaPorUsuario(idUsuario, dataHoraConsulta);
            return resposta;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
}
