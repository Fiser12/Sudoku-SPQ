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
		
		JButton btnFacil = new JButton("Facil");
		btnFacil.setForeground(Color.GREEN);
		btnFacil.setHorizontalAlignment(SwingConstants.LEFT);
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelOpciones.setLayout(new GridLayout(0, 1, 0, 0));
		panelOpciones.add(btnFacil);
		
		JButton btnMedio = new JButton("Medio");
		btnMedio.setForeground(Color.BLUE);
		panelOpciones.add(btnMedio);
		btnMedio.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnDificil = new JButton("Dificil");
		btnDificil.setForeground(Color.RED);
		panelOpciones.add(btnDificil);
		btnDificil.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton btnExtremo = new JButton("Extremo");
		panelOpciones.add(btnExtremo);
		btnExtremo.setHorizontalAlignment(SwingConstants.LEFT);
		btnExtremo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_2 = new JPanel();
		panelBotones.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAtras = new JButton("Atras");
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
