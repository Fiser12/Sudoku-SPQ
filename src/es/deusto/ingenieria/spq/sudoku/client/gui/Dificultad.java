package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.UIManager;

public class Dificultad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSeleccion;
	private JLabel lblSeleccionarUnaOpcion;
	private JPanel panelBotones;
	private JPanel panelOpciones;
	private JPanel panel_3;
	private JRadioButton rdbtn_1F;
	private JButton btnFacil;
	private JRadioButton radioButton_M;
	private JButton btnMedio;
	private JRadioButton radioButtonD;
	private JButton btnDificil;
	private JRadioButton rdbtnE;
	private JButton btnExtremo;
	private JButton btnAtras;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dificultad frame = new Dificultad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static Thread hilo = null;
	
	/**
	 * Create the frame.
	 */
	public Dificultad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Seleccionar dificultad");
		setForeground(Color.WHITE);
		setBounds(450, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
//		setDefaultCloseOperation(0); // No se cerrará pulsando X
		
		panelSeleccion = new JPanel();
		contentPane.add(panelSeleccion, BorderLayout.NORTH);
		panelSeleccion.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblSeleccionarUnaOpcion = new JLabel("Seleccionar una dificultad para el sudoku");
		panelSeleccion.add(lblSeleccionarUnaOpcion);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelOpciones = new JPanel();
		panelBotones.add(panelOpciones);
		panelOpciones.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panelOpciones.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		rdbtn_1F = new JRadioButton("");
		rdbtn_1F.setEnabled(false);
		panel_3.add(rdbtn_1F, BorderLayout.WEST);
		
		btnFacil = new JButton("Facil");
		btnFacil.setIcon(null);
		btnFacil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnFacil);
		btnFacil.setForeground(Color.GREEN);
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				radioButtonD.setSelected(false);
				rdbtnE.setSelected(false);
				rdbtn_1F.setSelected(true);
				radioButton_M.setSelected(false);
			}
		});
		
		JPanel panel_4 = new JPanel();
		panelOpciones.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		radioButton_M = new JRadioButton("");
		radioButton_M.setEnabled(false);
		panel_4.add(radioButton_M, BorderLayout.WEST);
		
		
	    btnMedio = new JButton("Medio");
		btnMedio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(btnMedio);
		btnMedio.setForeground(Color.BLUE);
		btnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			radioButtonD.setSelected(false);
			rdbtnE.setSelected(false);
			rdbtn_1F.setSelected(false);
			radioButton_M.setSelected(true);
			
			}
		});
		
		JPanel panel_5 = new JPanel();
		panelOpciones.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		radioButtonD = new JRadioButton("");
		radioButtonD.setEnabled(false);
		panel_5.add(radioButtonD, BorderLayout.WEST);
		
		btnDificil = new JButton("Difícil");
		btnDificil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(btnDificil);
		btnDificil.setForeground(Color.RED);
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			radioButtonD.setSelected(true);
			rdbtnE.setSelected(false);
			rdbtn_1F.setSelected(false);
			radioButton_M.setSelected(false);
			
			}
		});
		
		JPanel panel_6 = new JPanel();
		panelOpciones.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		rdbtnE = new JRadioButton("");
		rdbtnE.setEnabled(false);
		panel_6.add(rdbtnE, BorderLayout.WEST);
		
		btnExtremo = new JButton("Extremo");
		btnExtremo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(btnExtremo, BorderLayout.CENTER);
		btnExtremo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonD.setSelected(false);
				rdbtnE.setSelected(true);
				rdbtn_1F.setSelected(false);
				radioButton_M.setSelected(false);
				//metodo de selecionar la dificulatad
			}
		});
		
		JPanel panel_2 = new JPanel();
		panelBotones.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setHorizontalAlignment(SwingConstants.LEFT);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel_2.add(btnAtras);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
	}
	
	public void volver()
	{
		hilo = new Thread()  
		{ 
			public void run() 
			{
				setVisible(false);
				MenuJuego mj = new MenuJuego();
				mj.setResizable(false);
				mj.setVisible(true);
				hilo = null;
			}
		};
		hilo.start();
	}

}
