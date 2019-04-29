package Views;

import java.awt.EventQueue;

import Services.Task;
import database.DBConnection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminViews extends JFrame {

	private JPanel contentPane;
	private JTextField txTaskNumber;
	private JTextField txEvidence;
	private JTextField txTaskName;
	private JTextField txProcssOnwer;
	private JTextField txEmail;
    private DBConnection DB;
    private Task task=new Task();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminViews frame = new AdminViews();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminViews() {
        DB = new DBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
        //pack();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txTaskNumber = new JTextField();
		//txTaskNumber.setText("txTaskNumber");
		txTaskNumber.setBounds(120, 66, 272, 26);
		contentPane.add(txTaskNumber);
		txTaskNumber.setColumns(10);
		
		JTextPane txtpnServiceValidationSystem = new JTextPane();
		txtpnServiceValidationSystem.setText("SERVICE VALIDATION SYSTEM");
		txtpnServiceValidationSystem.setBounds(120, 21, 192, 16);
		contentPane.add(txtpnServiceValidationSystem);
		
		JTextPane txtpnAdministratorView = new JTextPane();
		txtpnAdministratorView.setText("ADMINISTRATOR VIEW");
		txtpnAdministratorView.setBounds(146, 38, 147, 16);
		contentPane.add(txtpnAdministratorView);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 58, 370, 6);
		contentPane.add(separator);
		
		JLabel lblNameOfObj = new JLabel("Task Number");
		lblNameOfObj.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNameOfObj.setBounds(25, 72, 86, 16);
		contentPane.add(lblNameOfObj);
		
		JLabel lblDescription = new JLabel("Task Name");
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblDescription.setBounds(25, 103, 61, 16);
		contentPane.add(lblDescription);
		
		JLabel lblEvidenceType = new JLabel("Evidence type");
		lblEvidenceType.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEvidenceType.setBounds(25, 252, 97, 16);
		contentPane.add(lblEvidenceType);
		
		txEvidence = new JTextField();
		txEvidence.setColumns(10);
		txEvidence.setBounds(123, 246, 272, 26);
        //txEvidence.setText("txEvidence");
		contentPane.add(txEvidence);
		
		txTaskName = new JTextField();
		txTaskName.setColumns(10);
		txTaskName.setBounds(120, 104, 272, 26);
        //txTaskName.setText("txTaskName");
		contentPane.add(txTaskName);
		
		JLabel lblTaskDescription = new JLabel("Task Description");
		lblTaskDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblTaskDescription.setBounds(25, 136, 108, 16);
		contentPane.add(lblTaskDescription);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(125, 135, 256, 32);
		contentPane.add(taDescription);
		
		JLabel lblProcessOwner = new JLabel("Executor");
		lblProcessOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblProcessOwner.setBounds(29, 190, 97, 16);
		contentPane.add(lblProcessOwner);
		
		txProcssOnwer = new JTextField();
		txProcssOnwer.setColumns(10);
		txProcssOnwer.setBounds(120, 183, 272, 26);
        //txProcssOnwer.setText("txProcssOnwer");
		contentPane.add(txProcssOnwer);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEmail.setBounds(25, 224, 97, 16);
		contentPane.add(lblEmail);
		
		txEmail = new JTextField();
		txEmail.setColumns(10);
		txEmail.setBounds(120, 216, 272, 26);
        //txEmail.setText("txEmail");
		contentPane.add(txEmail);

        JButton btnProcess = new JButton("Create");
        btnProcess.setBounds(25, 300, 117, 29);
        btnProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    task.setTaskNumber(Integer.parseInt(txTaskNumber.getText()));
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Invalid Task Number");
                    return;
                }task.setTaskName(txTaskName.getText());
                task.setTaskDescription(taDescription.getText());
                if(task.insert())
                    JOptionPane.showMessageDialog(null,"Success!");
                else
                    JOptionPane.showMessageDialog(null,"An error occurred. Check if the record exists");
            }
        });
        contentPane.add(btnProcess);
	}
}
