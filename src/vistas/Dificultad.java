package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class Dificultad extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public Dificultad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSeleccion = new JPanel();
		contentPane.add(panelSeleccion, BorderLayout.NORTH);
		panelSeleccion.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblSeleccionarUnaOpcion = new JLabel("Seleccionar una dificultad para el sudoku");
		panelSeleccion.add(lblSeleccionarUnaOpcion);
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelOpciones = new JPanel();
		panelBotones.add(panelOpciones);
		panelOpciones.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panelOpciones.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		rdbtnNewRadioButton_1.setEnabled(false);
		panel_3.add(rdbtnNewRadioButton_1, BorderLayout.WEST);
		
		JButton btnFacil = new JButton("Facil");
		btnFacil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(btnFacil);
		btnFacil.setForeground(Color.GREEN);
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_4 = new JPanel();
		panelOpciones.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setEnabled(false);
		panel_4.add(radioButton_1, BorderLayout.WEST);
		
		JButton btnMedio = new JButton("Medio");
		btnMedio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_4.add(btnMedio);
		btnMedio.setForeground(Color.BLUE);
		
		JPanel panel_5 = new JPanel();
		panelOpciones.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setEnabled(false);
		panel_5.add(radioButton, BorderLayout.WEST);
		
		JButton btnDificil = new JButton("Dificil");
		btnDificil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_5.add(btnDificil);
		btnDificil.setForeground(Color.RED);
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_6 = new JPanel();
		panelOpciones.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setEnabled(false);
		panel_6.add(rdbtnNewRadioButton, BorderLayout.WEST);
		
		JButton btnExtremo = new JButton("Extremo");
		btnExtremo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_6.add(btnExtremo, BorderLayout.CENTER);
		btnExtremo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panelBotones.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtras.setHorizontalAlignment(SwingConstants.LEFT);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel_2.add(btnAtras);
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
	}

}
