package com.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegisterFrame extends JFrame {
    public String email = "";
    public String password = "";
    public String action = ""; 
    JButton loginButton;
    JTextField emailField = null;
    JTextField passwordField = null;


    public RegisterFrame() {
        setTitle("Registro");
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

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();
        JButton registerButton = new JButton("Register");
        
        loginButton = new JButton("Login");

        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(registerButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout());
        footerPanel.setBackground(Color.WHITE);

        footerPanel.add(new JLabel("You have a account?"));
        footerPanel.add(loginButton);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                email = emailField.getText();
                password = passwordField.getText();
                action = "register"; 
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action = "login"; // Define a ação como login
                dispose();
                
            }
        });
    }
    
    
    public String getPassword() {
    	return password;
    }

    public String getEmail() {
        return email;
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
