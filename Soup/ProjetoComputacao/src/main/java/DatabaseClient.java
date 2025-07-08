import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DatabaseClient {

    public static void main(String[] args) {
        
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
}
