package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;


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
		setBounds(450, 100, 300, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJugar = new JButton("Comenzar Partida");
		btnJugar.setBounds(0, 50, 294, 50);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				/* Abre la ventana del juego, si previamente no se ha escogido una dificultad, el programa estar� en 
				f�cil por defecto*/
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(0, 100, 294, 50);
		contentPane.add(btnContinuar);
		btnContinuar.setEnabled(false); //disable mientras no haya una partida en marcha
		btnContinuar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				/* Si un jugador tiene una partida a medias puede continuarla desde el momento en que lo dej�.
				 * El tiempo que tenia acumulado permanecer� as� hasta el momento de la reanudaci�n, al que se
				 * le a�adir� el tiempo de juego de esta sesi�n.
				 */
			}
		});
		
		JButton btnDificultad = new JButton("Seleccionar Dificultad");
		btnDificultad.setBounds(0, 150, 294, 50);
		contentPane.add(btnDificultad);
		btnDificultad.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Abre la ventana de seleccion de dificultad, por defecto estar� marcado como f�cil
				abrirDificultad();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(0, 200, 294, 50);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Cierra la sesi�n y regresa al men� de registro
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

