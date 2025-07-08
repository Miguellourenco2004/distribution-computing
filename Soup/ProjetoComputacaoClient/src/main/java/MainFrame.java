import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gerenciar Consultas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton bookAppointmentButton = new JButton("Marcar Consulta");
        JButton cancelAppointmentButton = new JButton("Cancelar Consulta");
        JButton listAppointmentsButton = new JButton("Listar Consultas");

        add(bookAppointmentButton);
        add(cancelAppointmentButton);
        add(listAppointmentsButton);

        bookAppointmentButton.addActionListener(e -> new BookingFormFrame());

        cancelAppointmentButton.addActionListener(e -> new CancelAppointmentsFrame());
        

        listAppointmentsButton.addActionListener(e -> 
        	new ListAppointmentsFrame());

        setVisible(true);
    }
}


class CancelAppointmentsFrame extends JFrame {
    public CancelAppointmentsFrame() {
        setTitle("Cancelar Consultas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        MathConsumer consumer = new MathConsumer();
        List<String> consultas = consumer.listarConsultasFunction();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (consultas != null && !consultas.isEmpty()) {
            for (String consultaInfo : consultas) {
                String[] consultaParametros = consultaInfo.split(",");

                JPanel consultaPanel = new JPanel();
                consultaPanel.setLayout(new BoxLayout(consultaPanel, BoxLayout.Y_AXIS));
                consultaPanel.setBackground(new Color(240, 248, 255));
                consultaPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
                consultaPanel.setMaximumSize(new Dimension(500, 150)); 

                JLabel clinicaLabel = new JLabel("Clínica: " + consultaParametros[0]);
                clinicaLabel.setFont(new Font("Serif", Font.PLAIN, 14));
                consultaPanel.add(clinicaLabel);

                JLabel medicoLabel = new JLabel("Médico: " + consultaParametros[1]);
                medicoLabel.setFont(new Font("Serif", Font.PLAIN, 14));
                consultaPanel.add(medicoLabel);

                JLabel dataLabel = new JLabel("Data da Consulta: " + consultaParametros[2]);
                dataLabel.setFont(new Font("Serif", Font.PLAIN, 14));
                consultaPanel.add(dataLabel);

                JLabel moradaLabel = new JLabel("Morada: " + consultaParametros[3] + consultaParametros[4]);
                moradaLabel.setFont(new Font("Serif", Font.PLAIN, 14));
                consultaPanel.add(moradaLabel);

                JLabel sintomasLabel = new JLabel("Sintomas: " + consultaParametros[5]);
                sintomasLabel.setFont(new Font("Serif", Font.PLAIN, 14));
                consultaPanel.add(sintomasLabel);

               
                JButton cancelarButton = new JButton("Cancelar Consulta");
                cancelarButton.addActionListener((ActionListener) new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                      
                        String dataHoraConsulta = consultaParametros[2]; 

                        
                        boolean sucesso = consumer.cancelarConsultaPorUsuario(dataHoraConsulta);
                        
                       
                        if (sucesso) {
                            JOptionPane.showMessageDialog(null, "Consulta cancelada com sucesso.");
                            // Remove o painel de consulta do display
                            panel.remove(consultaPanel);
                            panel.revalidate();
                            panel.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao cancelar a consulta.");
                        }
                    }
                });
                consultaPanel.add(cancelarButton);
                panel.add(consultaPanel);
                panel.add(Box.createVerticalStrut(10));
            }
        } else {
            JLabel noAppointmentsLabel = new JLabel("Não há consultas agendadas.");
            noAppointmentsLabel.setFont(new Font("Serif", Font.BOLD, 16));
            noAppointmentsLabel.setForeground(new Color(128, 128, 128));
            noAppointmentsLabel.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(noAppointmentsLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Consultas"));
        add(scrollPane);

        setVisible(true);
    }
    
}


class ListAppointmentsFrame extends JFrame {
    
	public ListAppointmentsFrame() {
		 setTitle("Consultas Agendadas");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(600, 500);
	        setLocationRelativeTo(null);

	        MathConsumer consumer = new MathConsumer();
	        List<String> consultas = consumer.listarConsultasFunction();

	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        if (consultas != null && !consultas.isEmpty()) {
	            for (String consultaInfo : consultas) {
	                String[] consultaParametros = consultaInfo.split(",");

	                JPanel consultaPanel = new JPanel();
	                consultaPanel.setLayout(new BoxLayout(consultaPanel, BoxLayout.Y_AXIS));
	                consultaPanel.setBackground(new Color(240, 248, 255));
	                consultaPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
	                consultaPanel.setMaximumSize(new Dimension(500, 150)); // Aumenta a altura da caixa

	                JLabel clinicaLabel = new JLabel("Clínica: " + consultaParametros[0]);
	                clinicaLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	                consultaPanel.add(clinicaLabel);

	                JLabel medicoLabel = new JLabel("Médico: " + consultaParametros[1]);
	                medicoLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	                consultaPanel.add(medicoLabel);

	                JLabel dataLabel = new JLabel("Data da Consulta: " + consultaParametros[2]);
	                dataLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	                consultaPanel.add(dataLabel);
	                
	                JLabel moradaLabel = new JLabel("Morada: " + consultaParametros[3] + consultaParametros[4]);
	                moradaLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	                consultaPanel.add(moradaLabel);

	                JLabel sintomasLabel = new JLabel("Sintomas: " + consultaParametros[5]);
	                sintomasLabel.setFont(new Font("Serif", Font.PLAIN, 14));
	                consultaPanel.add(sintomasLabel);

	                panel.add(consultaPanel);
	                panel.add(Box.createVerticalStrut(10));
	            }
	        } else {
	            JLabel noAppointmentsLabel = new JLabel("Não há consultas agendadas.");
	            noAppointmentsLabel.setFont(new Font("Serif", Font.BOLD, 16));
	            noAppointmentsLabel.setForeground(new Color(128, 128, 128));
	            noAppointmentsLabel.setHorizontalAlignment(SwingConstants.CENTER);

	            panel.add(noAppointmentsLabel);
	        }

	        JScrollPane scrollPane = new JScrollPane(panel);
	        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Consultas"));
	        add(scrollPane);

	        setVisible(true);
	}

	
}



class BookingFormFrame extends JFrame {
    private JComboBox<String> clinicDropdown;
    private String selectedDateTime; 
    private String selectedSpecialty;

    public BookingFormFrame() {
        setTitle("Marcar Consulta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        JLabel heartIcon = new JLabel();
        heartIcon.setIcon(new ImageIcon(getClass().getResource("/resources/imagemSaude.png")));
        heartIcon.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(heartIcon);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 1, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel clinicLabel = new JLabel("Clínica:");
        clinicDropdown = new JComboBox<>();

        JLabel symptomsLabel = new JLabel("Sintomas:");
        JTextArea symptomsArea = new JTextArea(5, 20);
        JScrollPane symptomsScroll = new JScrollPane(symptomsArea);

        formPanel.add(clinicLabel);
        formPanel.add(clinicDropdown);
        formPanel.add(symptomsLabel);
        formPanel.add(symptomsScroll);

        JButton saveButton = new JButton("Salvar Consulta");
        saveButton.addActionListener(e -> {
            String clinic = (String) clinicDropdown.getSelectedItem();
            String symptoms = symptomsArea.getText();

            if (clinic == null || symptoms.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            MathConsumer consumer = new MathConsumer();
            boolean resposta  = consumer.marcarConsulta(clinic, selectedSpecialty , selectedDateTime, symptoms);
            
            if(resposta) {
            	JOptionPane.showMessageDialog(
                        this,
                        "Consulta marcada com sucesso!\n" +
                                "Especialidade: " + selectedSpecialty + "\n" +
                                "Data e Hora: " + selectedDateTime + "\n" +
                                "Clínica: " + clinic + "\n" +
                                "Sintomas: " + symptoms,
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                );
            	dispose();
            	
            }else {
            	JOptionPane.showMessageDialog(this, "Marcação da Consulta não foi concluida com sucesso", "Erro", JOptionPane.ERROR_MESSAGE);
            	dispose();
            }

          
            
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(saveButton);

        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        askForDetails();
        setVisible(true);
    }

    private void askForDetails() {
        boolean validInput = false; 

        while (!validInput) {
            JPanel dialogPanel = new JPanel(new GridLayout(4, 1, 10, 10));
            
            
            JTextField dateField = new JTextField("yyyy-MM-dd"); 
            dateField.setEditable(true);

           
            SpinnerDateModel model = new SpinnerDateModel();
            JSpinner timeSpinner = new JSpinner(model);
            JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH");
            timeSpinner.setEditor(editor);

            
            JComboBox<String> specialtyDropdown = new JComboBox<>(getSpecialties().toArray(new String[0]));

           
            dialogPanel.add(new JLabel("Data (yyyy-MM-dd):"));
            dialogPanel.add(dateField);
            dialogPanel.add(new JLabel("Hora:"));
            dialogPanel.add(timeSpinner);
            dialogPanel.add(new JLabel("Especialidade:"));
            dialogPanel.add(specialtyDropdown);

            
            int result = JOptionPane.showConfirmDialog(
                    this,
                    dialogPanel,
                    "Preencha os Detalhes da Consulta",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {
                String dateString = dateField.getText();
                selectedSpecialty = (String) specialtyDropdown.getSelectedItem();

                
                if (!isValidDateFormat(dateString)) {
                    JOptionPane.showMessageDialog(this, "Formato de Data inválido! Use yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
                    continue; 
                }

                
                int selectedHour = Integer.parseInt(new SimpleDateFormat("HH").format(timeSpinner.getValue()));

                
                if (selectedHour < 8 || selectedHour > 20) {
                    JOptionPane.showMessageDialog(this, "Hora inválida! Selecione uma hora entre 08:00 e 20:00.", "Erro", JOptionPane.ERROR_MESSAGE);
                    continue; 
                }

                
                SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateTimeString = dateString + " " + selectedHour + ":00:00";

                selectedDateTime = dateTimeString;
                loadClinics(selectedDateTime, selectedSpecialty);
                validInput = true; 
            } else {
                
                dispose();
                return;
            }
        }
    }


    private boolean isValidDateFormat(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void loadClinics(String dateTime, String specialty) {
        clinicDropdown.removeAllItems();
        List<String> clinics = findAvailableClinics(dateTime, specialty);

        if (clinics.isEmpty()) {
            clinicDropdown.addItem("Nenhuma clínica disponível");
        } else {
            for (String clinic : clinics) {
                clinicDropdown.addItem(clinic);
            }
        }
    }

    private List<String> getSpecialties() {
        return List.of("Clinica Geral", "Pediatria", "Cardiologia", "Ginecologia", "Hematologia", "Medicina Tropical", "Neurologia", "Oftalmologia", "Oncologia", "Otorrinolaringologia");
    }

    private List<String> findAvailableClinics(String dateTime, String specialty) {
        System.out.println(dateTime);  
        List<String> clinics = new ArrayList<>();
        
        MathConsumer consumer = new MathConsumer();
        clinics = consumer.listarClinicasFunction(specialty, dateTime);  
        
        return clinics;
    }
}