package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class Registrer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
   private JButton btnRegistrar;
   private JButton btnSalir;
   private 	JPanel panel ;
   private JPanel panel_2;
   private JPanel panel_1;
   private JLabel lblNewLabel;
   private JPanel panel_3;
   private JLabel lblPass1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrer frame = new Registrer();
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
	public Registrer() {
		setTitle("Registro");
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
	panel= new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		 btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(textField.getText().equals("")){
				JOptionPane.showMessageDialog(null,"No has insertado un Nick","Error",JOptionPane.ERROR_MESSAGE);
				
			}
			else if(textField.getText().equals("")){ //Comprobar mediante metodo si esta en la vase de datos+
				JOptionPane.showMessageDialog(null,"El "+textField.getText()+" ya esta cojido","Error",JOptionPane.ERROR_MESSAGE);
			}
		
			
			else if(new String(passwordField.getPassword()).equals("")){
				JOptionPane.showMessageDialog(null,"Deve introducir una contraseña","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(new String(passwordField_1.getPassword()).equals("")){
				JOptionPane.showMessageDialog(null,"Deve Repetir la contraseña","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(new String(passwordField.getPassword()).equals( new String(passwordField_1.getPassword()))){
				JOptionPane.showMessageDialog(null,"Creando Usuario","Correcto",JOptionPane.INFORMATION_MESSAGE);
			
			}
			else{
				JOptionPane.showMessageDialog(null,"La contraseña no coinciden","Error",JOptionPane.ERROR_MESSAGE);
				//System.out.println(new String(passwordField.getPassword())+"   "+new String((passwordField_1.getPassword())));
			}
			}});
		panel.add(btnRegistrar);
		
		 btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Login l=new Login();
			l.setVisible(true);
			dispose();
			}
		});
		panel.add(btnSalir);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		 lblNewLabel = new JLabel("Seleccionar Nick:");
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(20);
		
		 panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		 lblPass1 = new JLabel("Introducir contrase\u00F1a:");
		panel_3.add(lblPass1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel_3.add(passwordField);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblPass2 = new JLabel("Repetir contrase\u00F1a:");
		panel_4.add(lblPass2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(20);
		panel_4.add(passwordField_1);
		contentPane = new JPanel();
	}

}
