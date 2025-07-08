import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacoesRegisterFrame extends JFrame {
	
	 public String primeiroNomeString = "";
	 public String ultimoNomeString = "";
	 public String action = "";
	 JTextField primeiroNome = null;
	 JTextField ultimoNome = null;
	  

	    public InformacoesRegisterFrame() {
	        setTitle("Ficheiro Paciente");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setExtendedState(JFrame.MAXIMIZED_BOTH); 
	        setUndecorated(true);
	        setLayout(new BorderLayout());

	        JPanel mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout());
	        mainPanel.setBackground(Color.WHITE);

	        JLabel appIcon = new JLabel();
	        appIcon.setIcon(new ImageIcon(getClass().getResource("/resources/imagemSaude.png"))); 
	        appIcon.setHorizontalAlignment(SwingConstants.CENTER);
	        appIcon.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	        mainPanel.add(appIcon, BorderLayout.NORTH);

	        JPanel formPanel = new JPanel();
	        formPanel.setLayout(new GridLayout(5, 1, 10, 10));
	        formPanel.setBackground(Color.WHITE);
	        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

	        JLabel primeiroNomeLabel = new JLabel("Primeiro Nome:");
	         primeiroNome = new JTextField();

	        JLabel ultimoNomeLabel = new JLabel("Último Nome:");
	         ultimoNome = new JTextField();
	        JButton EnterButton = new JButton("Enter");
	        
	   
	        formPanel.add(primeiroNomeLabel);
	        formPanel.add(primeiroNome);
	        formPanel.add(ultimoNomeLabel);
	        formPanel.add(ultimoNome);
	        formPanel.add(EnterButton);

	        mainPanel.add(formPanel, BorderLayout.CENTER);

	       

	        add(mainPanel);
	        setVisible(true);

	        EnterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                primeiroNomeString = primeiroNome.getText();
	                ultimoNomeString = ultimoNome.getText();
	                action = "enter"; 
	                dispose();
	            }
	        });
	    }

	        
	    
	  
	    public String getPrimeiroNome() {
	    	return primeiroNomeString;
	    }

	    public String getUltimoNome() {
	        return ultimoNomeString;
	    }

	    public String getAction() {
	        return action;
	    }




		public JTextField getEmailField() {
			return primeiroNome;
		}




		public JTextField getPasswordField() {
			return ultimoNome;
		}

}
