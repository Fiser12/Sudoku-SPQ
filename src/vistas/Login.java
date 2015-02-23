package vistas;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField JTextUser;
	private JTextField JTextPass;
	private JButton bLogin;
	private JButton bRegister;
	private static Thread hilo = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 300, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(100, 110, 87, 31);
		contentPane.add(btnLogin);
		
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
		
		JLabel lblHzloAquY = new JLabel("H\u00E1zlo aqu\u00ED y empieza a disfrutar con Sudoku");
		lblHzloAquY.setBounds(24, 186, 250, 31);
		contentPane.add(lblHzloAquY);
		

		//Diseño de la ventana
		setDefaultCloseOperation(0);

	}

	public void actionPerformed(ActionEvent e)
	{
		Object fuente = e.getSource();
		if(fuente == bLogin)
		{
			//CodLogin
		}
		else
		{
			//CodRegistro
		}
	}
}
