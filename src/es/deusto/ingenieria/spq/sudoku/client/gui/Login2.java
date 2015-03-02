package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.deusto.ingenieria.spq.sudoku.client.controller.SudokuController;
import es.deusto.ingenieria.spq.sudoku.server.data.Usuario;

public class Login2 extends JFrame {

	private JPanel contentPane;
	
	private JTextField JTextUser;
	private JTextField JTextPass;
	private JButton bLogin;
	private JButton bRegister;
	private static Thread hilo = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login2 frame = new Login2(new SudokuController(args));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login2(final SudokuController controller) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 300, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(100, 110, 87, 31);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				Usuario usuario = controller.inicioSesion(textField.getText(), 
					new String(passwordField.getPassword()));
				System.out.println("Nick:	" + textField.getText());
				System.out.println("Password:	" + new String(passwordField.getPassword()));
				if (usuario!=null) {
					System.out.println("Estos datos existen.");
				} else {
					System.out.println("Estos datos NO existen.");
				}
			}	
		});
		
		textField = new JTextField();
		textField.setBounds(85, 27, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 64, 113, 20);
		contentPane.add(passwordField);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(24, 17, 29, 40);
		contentPane.add(lblNick);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 59, 59, 31);
		contentPane.add(lblPassword);
		
		JLabel lblAnNoTe = new JLabel("\u00BFA\u00FAn no te has registrado?");
		lblAnNoTe.setBounds(66, 152, 186, 40);
		contentPane.add(lblAnNoTe);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(100, 223, 87, 31);
		contentPane.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) 
			{
				Usuario usuario = controller.registrar(textField.getText(), 
					new String(passwordField.getPassword()));
				System.out.println("Nick:	" + textField.getText());
				System.out.println("Password:	" + new String(passwordField.getPassword()));
				if (usuario!=null) {
					System.out.println("Registrado.");
				} else {
					System.out.println("Este nick YA existe.");
				}
			}	
		});
		
		JLabel lblHzloAquY = new JLabel("H\u00E1zlo aqu\u00ED y empieza a disfrutar con Sudoku");
		lblHzloAquY.setBounds(24, 186, 250, 31);
		contentPane.add(lblHzloAquY);
		
		this.setVisible(true);
	}
}
