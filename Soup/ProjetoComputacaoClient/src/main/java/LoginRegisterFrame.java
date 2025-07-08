import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginRegisterFrame extends JFrame {
	public String email = "";
    public String password = "";
    public String action = "";
    JTextField emailField = null;
    JTextField passwordField = null;

    public LoginRegisterFrame() {
    	
    	
        // Configurações do JFrame
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(true);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Adicionando o símbolo da aplicação
        JLabel appIcon = new JLabel();
        appIcon.setIcon(new ImageIcon(getClass().getResource("/resources/imagemSaude.png"))); // Caminho do ícone
        appIcon.setHorizontalAlignment(SwingConstants.CENTER);
        appIcon.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.add(appIcon, BorderLayout.NORTH);

        // Painel de Login e Registro
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Componentes de Login
        JLabel emailLabel = new JLabel("Email:");
         emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Adicionando componentes ao painel do formulário
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(loginButton);

        // Adicionando tudo ao painel principal
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Painel de Registro (opcional, como link ou botão)
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        footerPanel.setBackground(Color.WHITE);

        footerPanel.add(new JLabel("Don't have an account?"));
        footerPanel.add(registerButton);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Adicionando o painel principal ao JFrame
        add(mainPanel);
        
        setVisible(true);
        
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailField.getText();
                password = passwordField.getText();
                action = "login"; 
                dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "register"; // 
                dispose(); 
            }
        });
        
        
    }
    
   public String getEmail() {
	   return email;
   }
   
   public String getPassword() {
	   return password;
   }
    
   public JTextField getEmailField() {
	    return emailField;
	}

	public JTextField getPasswordField() {
	    return passwordField;
	}
	public String getAction() {
        return action;
    }
    
    
}
