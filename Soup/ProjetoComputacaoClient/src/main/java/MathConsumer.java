import javax.jws.WebService;
import javax.swing.*;
import java.awt.*;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import default_package.MathUtility;


@WebService(targetNamespace = "http://default_package/", portName = "MathConsumerPort", serviceName = "MathConsumerService")
public class MathConsumer {
	
	
		
	static String email = "";
	 	 

	public static void main(String[] args) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

	    factory.setAddress("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");

	   
	    factory.setServiceClass(MathUtility.class);
	    
	    Object client = factory.create();
	   

	    boolean loginValidacao = false;
	    boolean registarValidacao = false;
	    
	    RegisterFrame  register = new RegisterFrame();
	    LoginRegisterFrame login = new LoginRegisterFrame();
	    register.setVisible(false);
	    login.setVisible(true);
        String password = "";
        String primeiroNome = "";
        String ultimoNome = "";
        int idUsuario = 0;
	    
	  
	 while(loginValidacao == false && registarValidacao == false) {
	    
	    while(loginValidacao == false) {
	    	login.setVisible(true);
	    	register.setVisible(false);
	    	
	    	while(login.isVisible()) {
	    		try {
	                Thread.sleep(100); 
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	    	}
	    	
	    	
	    	 if ("register".equals(login.getAction())) {
                 break; 
             }
	    	 
	    	 email = login.getEmail();
             password = login.getPassword();

             if (!(email.isEmpty() || email.isBlank() || password.isBlank() || password.isEmpty())) {
                 loginValidacao = ((MathUtility) client).loginUtilizador(email, password);
             } else {
                 loginValidacao = false;
             }

             if (loginValidacao) {
                 login.getEmailField().setBackground(Color.WHITE);
                 login.getPasswordField().setBackground(Color.WHITE);
                 JOptionPane.showMessageDialog(login, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                  
                 
             } else {
                 login.getEmailField().setBackground(Color.PINK);
                 login.getPasswordField().setBackground(Color.PINK);
                 JOptionPane.showMessageDialog(login, "Email ou senha incorretos!", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                 
             }
	    	 
	    	 
	    }
	    
	    while(registarValidacao == false && loginValidacao == false) {
	    	login.setVisible(false);
	    	register.setVisible(true);
	    	
	    	
	    	while(register.isVisible()) {
	    		try {
	                Thread.sleep(100); 
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	    	}
	    	
	    	 if ("login".equals(register.getAction())) {
                 break; 
             }
	    	 
	    	 email = register.getEmail();
	    	 password = register.getPassword();
	    	 
	    	 if (!(email.isEmpty() || email.isBlank() || password.isBlank() || password.isEmpty())) {
                 registarValidacao = ((MathUtility) client).registarUtilizador(email, password);
             } else {
                 registarValidacao = false;
             }
	    	 
	    	 
	    	 if (registarValidacao) {
                 register.getEmailField().setBackground(Color.WHITE);
                 register.getPasswordField().setBackground(Color.WHITE);
                 JOptionPane.showMessageDialog(login, "Registo bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                 idUsuario = ((MathUtility) client).obterIdUtilizador(email);
                 System.out.println(idUsuario);
                 
             } else {
                 register.getEmailField().setBackground(Color.PINK);
                 register.getPasswordField().setBackground(Color.PINK);
                 JOptionPane.showMessageDialog(login, "Email já esta em uso!", "Erro de Registo", JOptionPane.ERROR_MESSAGE);
                 
             }
	    	 
	    	 
	    	
	    }
	    
	    
	    
	 }
	 
	 
	 login.dispose();
	 register.dispose();
	 
	 if(loginValidacao == true) {
		 
		 MainFrame consultas = new MainFrame();
		 consultas.setVisible(true);
		 
		 
	 }else {
		 
		InformacoesRegisterFrame informacoesAdd = new InformacoesRegisterFrame();
		boolean pacienteValidacao = false;
		
		while(pacienteValidacao == false) {
		informacoesAdd.setVisible(true);
		
		
		while(informacoesAdd.isVisible()) {
    		try {
                Thread.sleep(100); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
    	}
		
		primeiroNome = informacoesAdd.getPrimeiroNome();
		ultimoNome = informacoesAdd.getUltimoNome();
		
		 if (!(primeiroNome.isEmpty() || primeiroNome.isBlank() || ultimoNome.isBlank() || ultimoNome.isEmpty())) {
             pacienteValidacao = ((MathUtility) client).criarPaciente(primeiroNome, ultimoNome, idUsuario);
         } else {
        	 pacienteValidacao = false;
         }
		 
		 if(pacienteValidacao == true) {
			 informacoesAdd.getEmailField().setBackground(Color.WHITE);
             informacoesAdd.getPasswordField().setBackground(Color.WHITE);
             JOptionPane.showMessageDialog(login, "Ficheiro de Paciente Concluido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
		 }else {
			 informacoesAdd.getEmailField().setBackground(Color.PINK);
             informacoesAdd.getPasswordField().setBackground(Color.PINK);
             JOptionPane.showMessageDialog(login, "Tem que introduzir campos válidos!", "Erro Ficheiro Paciente", JOptionPane.ERROR_MESSAGE);
		 }
		
		}
			 
	 }
	        
	}
	
	
	public boolean marcarConsulta(String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas) {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

	    factory.setAddress("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");

	   
	    factory.setServiceClass(MathUtility.class);
	    
	    Object client = factory.create();
	    
	    int idUsuario = ((MathUtility) client).obterIdUtilizador(email);
	    
	    boolean resposta = ((MathUtility) client).marcarConsulta(clinicaNome, especialidade, dataHoraConsulta, sintomas, idUsuario);
		
		return resposta;
	}
	
	public List<String> listarConsultasFunction (){
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setAddress("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");
	    factory.setServiceClass(MathUtility.class);
	    Object client = factory.create();
	    int idUsuario = ((MathUtility) client).obterIdUtilizador(email);
	    
	    List<String> consultas = ((MathUtility) client).listarConsultasPaciente(idUsuario);
	    
	    
	    return consultas ;
	    
		
	}	
	
	
	public boolean cancelarConsultaPorUsuario(String dataHoraConsulta) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setAddress("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");
	    factory.setServiceClass(MathUtility.class);
	    Object client = factory.create();
	    int idUsuario = ((MathUtility) client).obterIdUtilizador(email);
	    boolean resposta = ((MathUtility) client).cancelarConsultaPorUsuario(idUsuario, dataHoraConsulta);
	    
	    	
	    return resposta;
	}
	
	public List<String> listarClinicasFunction(String especialidade, String dataHoraConsulta){
	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

    factory.setAddress("http://localhost:8080/ProjetoComputacao/services/MathUtilityPort?wsdl");

   
    factory.setServiceClass(MathUtility.class);
    
    Object client = factory.create();
    
    List<String> clinics = ((MathUtility) client).listarClinicas(especialidade, dataHoraConsulta);
    
    
	return clinics;	
	}

}