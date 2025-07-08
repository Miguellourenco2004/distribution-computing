package com.client;



import javax.swing.*;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
public class MathConsumer {
	
	static String email = "";

    public static void main(String[] args) {
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

        while (!loginValidacao && !registarValidacao) {
            while (loginValidacao == false) {
                login.setVisible(true);
                register.setVisible(false);

                while (login.isVisible()) {
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
                    System.out.println("DEBUG: Email e senha foram fornecidos."); // Debug 1
                    System.out.println("DEBUG: Email recebido -> " + email); // Debug 2
                    System.out.println("DEBUG: Password recebido -> " + password); // Debug 3

                    try {
                        loginValidacao = loginUtilizador(email, password);
                        System.out.println("DEBUG: Resultado da validação de login -> " + loginValidacao); // Debug 4
                    } catch (IOException e) {
                        System.out.println("ERRO: Exceção durante a validação de login."); // Debug 5
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("DEBUG: Email ou senha estão vazios."); // Debug 6
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

            while (registarValidacao == false && loginValidacao == false) {
                login.setVisible(false);
                register.setVisible(true);

                while (register.isVisible()) {
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
                    try {
						registarValidacao = registarUtilizador(email, password);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
                } else {
                    registarValidacao = false;
                }

                if (registarValidacao) {
                    register.getEmailField().setBackground(Color.WHITE);
                    register.getPasswordField().setBackground(Color.WHITE);
                    JOptionPane.showMessageDialog(register, "Registro bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    try {
						idUsuario = getIdUsuario(email);
					    System.out.println("id +"+idUsuario); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                } else {
                    register.getEmailField().setBackground(Color.PINK);
                    register.getPasswordField().setBackground(Color.PINK);
                    JOptionPane.showMessageDialog(register, "Email já está em uso!", "Erro de Registro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        System.out.println("Teste");
        login.dispose();
        register.dispose();

        if (loginValidacao==true) {
        
        	 MainFrame consultas = new MainFrame();
    		 consultas.setVisible(true);
        } else {
            InformacoesRegisterFrame informacoesAdd = new InformacoesRegisterFrame();
           
            boolean pacienteValidacao = false;

            
            while(pacienteValidacao == false) {
            	
            
            	informacoesAdd.setVisible(true);
            
            while (informacoesAdd.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } 

            primeiroNome = informacoesAdd.getPrimeiroNome();
            ultimoNome = informacoesAdd.getUltimoNome();

            if (!(primeiroNome.isEmpty() || primeiroNome.isBlank() || ultimoNome.isBlank() || ultimoNome.isEmpty())) {
                try {
					pacienteValidacao = criarPaciente(primeiroNome, ultimoNome, idUsuario);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
                registarValidacao = false;
            }

            if (pacienteValidacao == true) {
            	
            	 informacoesAdd.getEmailField().setBackground(Color.WHITE);
                 informacoesAdd.getPasswordField().setBackground(Color.WHITE);
                 JOptionPane.showMessageDialog(login, "Ficheiro de Paciente Concluido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
               
           
            } else {
           	 informacoesAdd.getEmailField().setBackground(Color.PINK);
             informacoesAdd.getPasswordField().setBackground(Color.PINK);
             JOptionPane.showMessageDialog(login, "Tem que introduzir campos válidos!", "Erro Ficheiro Paciente", JOptionPane.ERROR_MESSAGE);
             
               
            }
        }
            
            
        }
    }

    public static boolean loginUtilizador(String email, String password) throws IOException {
        System.out.println("DEBUG: Iniciando processo de login."); // Debug 1
        System.out.println("DEBUG: URL da requisição -> http://localhost:8080/rest/login/"); // Debug 2
        System.out.println("DEBUG: Enviando email -> " + email); // Debug 3
        System.out.println("DEBUG: Enviando senha -> " + password); // Debug 4

        URL url = new URL("http://localhost:8080/novoRest/rest/login/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        // Criação do JSON com os dados
        String jsonData = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);
        System.out.println("DEBUG: Dados JSON enviados -> " + jsonData); // Debug 5

        // Envio do corpo da requisição
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonData.getBytes("utf-8");
            os.write(input, 0, input.length);
            System.out.println("DEBUG: Dados JSON enviados com sucesso."); // Debug 6
        }

        // Verifica o código de resposta HTTP
        int responseCode = conn.getResponseCode();
        System.out.println("DEBUG: Código de resposta do servidor -> " + responseCode); // Debug 7

        if (responseCode == 200) { // OK
            // Ler a resposta do servidor como String
            InputStream is = conn.getInputStream();
            String response = new BufferedReader(new InputStreamReader(is))
                    .lines()
                    .reduce("", (accumulator, actual) -> accumulator + actual);
            
            System.out.println("DEBUG: Resposta do servidor -> " + response);

            // Processar a resposta do servidor
            if ("true".equals(response)) {
                return true; // Login bem-sucedido
            } else if ("false".equals(response)) {
                return false; // Login falhou
            } else {
                System.out.println("DEBUG: Erro inesperado no servidor: " + response);
                return false; // Tratar como falha de login
            }
        } else {
            System.out.println("DEBUG: Código de erro recebido -> " + responseCode);
            return false; // Tratar respostas diferentes de 200 como falha
        }
    }

    
    private static boolean registarUtilizador(String email, String password) throws IOException {
        System.out.println("DEBUG: Iniciando processo de registro."); // Debug 1
        System.out.println("DEBUG: URL da requisição -> http://localhost:8080/rest/rest/register/"); // Debug 2
        System.out.println("DEBUG: Enviando email -> " + email); // Debug 3
        System.out.println("DEBUG: Enviando senha -> " + password); // Debug 4

        URL url = new URL("http://localhost:8080/novoRest/rest/register/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        // Criação do JSON com os dados
        String jsonData = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);
        System.out.println("DEBUG: Dados JSON enviados -> " + jsonData); // Debug 5

        // Envio do corpo da requisição
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonData.getBytes("utf-8");
            os.write(input, 0, input.length);
            System.out.println("DEBUG: Dados JSON enviados com sucesso."); // Debug 6
        }

     // Obter o código de resposta HTTP
        int responseCode = conn.getResponseCode();
        System.out.println("DEBUG: Código de resposta do servidor -> " + responseCode);

        if (responseCode == 200) {
            // Ler a resposta como String
            InputStream is = conn.getInputStream();
            String response = new BufferedReader(new InputStreamReader(is))
                                   .lines()
                                   .reduce("", (accumulator, actual) -> accumulator + actual);
            
            System.out.println("DEBUG: Resposta do servidor -> " + response);

            // Processar a resposta
            if ("true".equals(response)) {
                return true;
            } else if ("false".equals(response)) {
                return false;
            } else {
                System.out.println("DEBUG: Erro inesperado no servidor.");
                return false; // Ou lançar uma exceção dependendo do caso
            }
        } else {
            System.out.println("DEBUG: Código de erro recebido -> " + responseCode);
            return false;
        }

    }

 
 private static int getIdUsuario(String email) throws IOException {
    	 URL url = new URL(String.format("http://localhost:8080/novoRest/rest/getUserId?email=%s", email));
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.setRequestProperty("Accept", "application/json");

        int responseCode = conn.getResponseCode();

        if (responseCode == 200) { // Se 200 OK, lê o corpo da resposta
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                String response = br.readLine(); // Lê a resposta como String
                conn.disconnect();

                // Verifica se a resposta é "error"
                if ("error".equalsIgnoreCase(response)) {
                    return 0; // Retorna 0 em caso de erro
                }

                return Integer.parseInt(response); // Converte a resposta para um número inteiro
            }
        }

        conn.disconnect();
        return 0; // Retorna 0 se não conseguir obter o ID
    }
 public List<String> listarClinicasFunction(String especialidade, String dataHoraConsulta) throws IOException {

	 String encodedEspecialidade = URLEncoder.encode(especialidade, "UTF-8");
	 String encodedDataHoraConsulta = URLEncoder.encode(dataHoraConsulta, "UTF-8");

	 URL url = new URL(String.format("http://localhost:8080/novoRest/rest/listarClinicas?especialidade=%s&dataHoraConsulta=%s", 
	                                 encodedEspecialidade, encodedDataHoraConsulta));
	 System.out.println(dataHoraConsulta+"olaaaaa");
     System.out.println(url);
     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("GET");
     conn.setRequestProperty("Accept", "application/json");

     List<String> clinics = new ArrayList<>();

     // Verifica a resposta do servidor
     int responseCode = conn.getResponseCode();

     if (responseCode == 200) {
    	 
         try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
             StringBuilder response = new StringBuilder();
             String line;

             while ((line = br.readLine()) != null) {
                 response.append(line);
             }
             System.out.println("tou aqui");
             // Convertendo JSON da resposta em uma lista de stringscbd
             String jsonResponse = response.toString();
             
             System.out.println("aqui "+jsonResponse);
             // Supõe-se que a resposta é uma lista JSON de strings: ["Clinica A", "Clinica B"]
             jsonResponse = jsonResponse.replace("[", "").replace("]", "").replace("\"", "");
             String[] clinicsArray = jsonResponse.split(",");

             for (String clinic : clinicsArray) {
                 clinics.add(clinic.trim());
             }
             
             for (String clinic : clinics) {
                 System.out.println(clinic);
             }
         }
     }
     System.out.println("tou aqui");
     
     conn.disconnect();
     return clinics; // Retorna a lista de clínicas
 }
 
 private static boolean criarPaciente(String firstName, String lastName, int userId) throws IOException {
	    URL url = new URL("http://localhost:8080/novoRest/rest/createPatient");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("POST");
	    conn.setDoOutput(true);
	    conn.setRequestProperty("Content-Type", "application/json");

	    // Criação do JSON com os dados (alinhado com o servidor)
	    String jsonData = String.format("{\"firstName\":\"%s\", \"lastName\":\"%s\", \"userId\":%d}", 
	                                     firstName, lastName, userId);

	    // Envio do corpo da requisição
	    try (OutputStream os = conn.getOutputStream()) {
	        byte[] input = jsonData.getBytes("utf-8");
	        os.write(input, 0, input.length);
	    }

	    // Verifica a resposta do servidor
	    int responseCode = conn.getResponseCode();

	    // Lê a resposta do servidor como String (esperando "true" ou "false")
	    if (responseCode == 200) {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
	            String response = br.readLine();
	            conn.disconnect();

	            // Retorna true se a resposta for "true", false caso contrário
	            return Boolean.parseBoolean(response);
	        }
	    }

	    conn.disconnect();
	    return false; // Retorna false em caso de erro ou resposta não 200
	}
 
 
 public boolean marcarConsulta(String clinicaNome, String especialidade, String dataHoraConsulta, String sintomas) throws IOException {
	 
     URL url = new URL("http://localhost:8080/novoRest/rest/marcarConsulta");
     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("POST");
     conn.setDoOutput(true);
     conn.setRequestProperty("Content-Type", "application/json");
     int idUsuario =getIdUsuario(email);
     // Criação do JSON com os dados necessários
     String jsonData = String.format(
             "{\"clinicaNome\":\"%s\", \"especialidade\":\"%s\", \"dataHoraConsulta\":\"%s\", \"sintomas\":\"%s\", \"idUsuario\":%d}", 
             clinicaNome, especialidade, dataHoraConsulta, sintomas, idUsuario
         );
     System.out.println("Json testando " + jsonData);
     // Envio do corpo da requisição
     try (OutputStream os = conn.getOutputStream()) {
         byte[] input = jsonData.getBytes("utf-8");
         os.write(input, 0, input.length);
     }

     // Verifica a resposta do servidor
     int responseCode = conn.getResponseCode();

     if (responseCode == 200) {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
             String response = br.readLine();
             conn.disconnect();

             // Retorna true se a resposta for "true"
             return Boolean.parseBoolean(response);
         }
     }

     conn.disconnect();
     return false; // Retorna false em caso de erro ou resposta não 200
 }





 public List<String> listarConsultasFunction() throws IOException {
	    // Obtém o ID do usuário com base no email
	    int idUsuario = getIdUsuario(email);

	    // Define a URL do serviço REST
	    URL url = new URL(String.format("http://localhost:8080/novoRest/rest/listarConsultasPaciente?PacienteId=%d", idUsuario));

	    // Estabelece a conexão HTTP
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Accept", "application/json");

	    List<String> consultas = new ArrayList<>();

	    // Verifica o código de resposta do servidor
	    int responseCode = conn.getResponseCode();

	    if (responseCode == 200) {
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
	            StringBuilder response = new StringBuilder();
	            String line;

	            // Lê a resposta do servidor linha por linha
	            while ((line = br.readLine()) != null) {
	                response.append(line);
	            }

	            // Converte a resposta JSON em uma lista de strings
	            String jsonResponse = response.toString();

	            System.out.println("DEBUG: Enviando resposta -> " +  response); // Debug

	            // Agora vamos processar o JSON de forma correta:
	            // Remove os colchetes no começo e no final da lista
	            jsonResponse = jsonResponse.substring(1, jsonResponse.length() - 1); // Remove os colchetes []

	            // Divide a resposta com base nas aspas e vírgulas, para cada item da lista de consultas
	            String[] consultasArray = jsonResponse.split("\",\"");

	            // Agora, percorre cada item da lista e adiciona na lista de consultas
	            for (String consulta : consultasArray) {
	                // Remove as aspas extras no início e fim de cada consulta
	                consultas.add(consulta.replace("\"", ""));
	            }
	        }
	    } else {
	        throw new IOException("Erro ao listar consultas: HTTP " + responseCode);
	    }

	    conn.disconnect();
	    return consultas;
	}

 
 public boolean cancelarConsultaPorUsuario(String dataHoraConsulta) {
	    try {
	        URL url = new URL("http://localhost:8080/novoRest/rest/cancelarConsulta");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/json");

	        int idUsuario = getIdUsuario(email);

	        // Criação do JSON com os dados necessários
	        String jsonData = String.format(
	            "{\"idUsuario\":%d, \"dataHoraConsulta\":\"%s\"}", 
	            idUsuario, dataHoraConsulta
	        );

	        // Envio do corpo da requisição
	        try (OutputStream os = conn.getOutputStream()) {
	            byte[] input = jsonData.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }

	        // Verifica a resposta do servidor
	        int responseCode = conn.getResponseCode();

	        if (responseCode == 200) {
	            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
	                String response = br.readLine();
	                conn.disconnect();
	                System.out.println("DEBUG: cancelar -> "+ response ); // Debug 4
	                // Retorna true se a resposta for "true"
	                return Boolean.parseBoolean(response);
	            }
	        }

	        conn.disconnect();
	        return false; // Retorna false em caso de erro ou resposta não 200
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // Retorna false em caso de exceção
	    }
	}


}


