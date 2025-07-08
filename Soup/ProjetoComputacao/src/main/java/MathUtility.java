import javax.jws.WebService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


@WebService(targetNamespace = "http://default_package/", portName = "MathUtilityPort", serviceName = "MathUtilityService")
public class MathUtility {
	
	
	public List<String> queryAuthServerTest() {
		
		AuthServerConn authServer = new AuthServerConn();
		return authServer.queryAuthServerTest();
	
	}

    public int addIntegers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }
    
    
    public List<String> listarClinicas(String especialidade, String dataHoraConsulta){
    	List<String> clinics = DatabaseClient.listarConsultas(especialidade, dataHoraConsulta);
    	return clinics;
    }
    
    
    public boolean registarUtilizador(String email, String password) {
        AuthServerConn authServer = new AuthServerConn();
        
        return authServer.registarUtilizador(email, password);
    }
    
    public int obterIdUtilizador (String email) {
    	AuthServerConn authServer = new AuthServerConn();
    	
    	return authServer.obterIdUtilizador(email);
    	
    }
    
    public boolean loginUtilizador(String email, String password) {
    	AuthServerConn authServer = new AuthServerConn();
    	
    	return authServer.loginUtilizador(email, password);
    }
    
    
    public boolean marcarConsulta(String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas, int usuarioId) {
    	
    	boolean result = DatabaseClient.marcarConsulta(clinicaNome, especialidade, dataHoraConsulta, sintomas, usuarioId);
    	return result;
    }
    
    

    public List<String> listarConsultasPaciente (int PacienteId) {
    	
    	List<String> consultas = DatabaseClient.listarConsultasPaciente(PacienteId);
    	return consultas;
    	
    }
    
    public boolean cancelarConsultaPorUsuario(int idUsuario, String dataHoraConsulta) {
    	
    	boolean resposta = DatabaseClient.cancelarConsultaPorUsuario(idUsuario, dataHoraConsulta);
    	return resposta;
    }
   
    
    public boolean criarPaciente(String primeiroNome, String ultimoNome, int idUsuario) {
    	
    	boolean result = DatabaseClient.criarPaciente(primeiroNome, ultimoNome, idUsuario);
    	return result;
    	
    }
    
    public List<String> queryDatabase (String query){
    	
    	List<String> result = DatabaseClient.queryDatabase(query);
    	return result;
    }
    
  
    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}