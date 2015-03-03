package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;


public class MenuJuego extends JFrame
{

	private JPanel contentPane;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MenuJuego frame = new MenuJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static Thread hilo = null;
	
	public MenuJuego() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 300, 283);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblOpcion = new JLabel("Seleccionar una opcion:");
		lblOpcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblOpcion);
		
		JButton btnJugar = new JButton("Comenzar Partida");
		btnJugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				/* Abre la ventana del juego, si previamente no se ha escogido una dificultad, el programa estará en 
				fácil por defecto*/
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnContinuar);
		btnContinuar.setEnabled(false); //disable mientras no haya una partida en marcha
		btnContinuar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				/* Si un jugador tiene una partida a medias puede continuarla desde el momento en que lo dejó.
				 * El tiempo que tenia acumulado permanecerá así hasta el momento de la reanudación, al que se
				 * le añadirá el tiempo de juego de esta sesión.
				 */
			}
		});
		
		JButton btnDificultad = new JButton("Seleccionar Dificultad");
		btnDificultad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnDificultad);
		btnDificultad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Abre la ventana de seleccion de dificultad, por defecto estará marcado como fácil
				abrirDificultad();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Cierra la sesión y regresa al menú de registro
				desconectar();
			}
		});
	}
	public void abrirDificultad()
	{
		hilo = new Thread()  
		{ 
			public void run() 
			{
				setVisible(false);
				Dificultad d = new Dificultad();
				d.setResizable(false);
				d.setVisible(true);
				hilo = null;
			}
		};
		hilo.start();
	}
	public void desconectar()
	{
		hilo = new Thread()  
		{ 
			public void run() 
			{
				setVisible(false);
				Login l = new Login();
				l.setResizable(false);
				l.setVisible(true);
				hilo = null;
			}
		};
		hilo.start();
	}
}

