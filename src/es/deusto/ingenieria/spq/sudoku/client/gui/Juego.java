package es.deusto.ingenieria.spq.sudoku.client.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.xml.stream.events.Comment;

import com.sun.javafx.application.PlatformImpl.FinishListener;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Juego extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextTiempo; // tiempo de partida 
	private JTable table;
	String [][]valores = new String[9][9];
    boolean [][]contiene = new boolean[9][9];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		jTextTiempo = new JTextField();
		jTextTiempo.setEditable(false);
		contentPane.add(jTextTiempo, BorderLayout.NORTH);
		jTextTiempo.setColumns(10);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(table, BorderLayout.CENTER);

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnCount(9);
		dtm.setRowCount(9);
		table.setModel(dtm);
		table.setRowHeight(45);
		table.setDefaultRenderer(Object.class, new CellRenderer());
	}
	
	public class CellRenderer extends DefaultTableCellRenderer{

		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
		{
			JLabel etiqueta = new JLabel();
			etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
			etiqueta.setFont(new Font("Consolas", Font.PLAIN, 20));
			etiqueta.setBorder(new MatteBorder(0, 0, 0, 0,Color.GRAY));
			if(column == 3 || column == 6)
			{
				etiqueta.setBorder(new MatteBorder(0, 5, 0, 0,Color.GRAY));
			}
			if(row == 2 || row == 5)
			{
				etiqueta.setBorder(new MatteBorder(0, 0, 5, 0,Color.GRAY));

			}
			if((row == 2 && column == 3) || (row == 5 && column == 3) || 
					(row == 5 && column == 6) || (row == 2 && column == 6))
			{
				etiqueta.setBorder(new MatteBorder(0, 5, 5, 0,Color.GRAY));
			}
			if((row % 2 == 0 && column % 2 != 0) || (row % 2 != 0 && column % 2 == 0))
			{
				etiqueta.setBackground( Color.lightGray);
			}
			else
			{
				etiqueta.setBackground( Color.WHITE);
			}
			etiqueta = seleccionarColor(table, etiqueta, (String) value);
			etiqueta.setOpaque(true);
			if(esUnNumero((String)value))
			{
				String ayuda = "";
				String a = value.toString();
				valores[row][column]= a;
				a=NumerosIguales(a);
				if(a.length()>1){
					for(int i=0;i<a.length();i++){
						if(i==0){
       				ayuda=ayuda+a.substring(i, i+1);
       			}
       			else{
       				ayuda=ayuda+"|"+a.substring(i, i+1);}}

       		if(ayuda.length()>3){
       			etiqueta.setFont(new Font("Consolas", Font.PLAIN, 10));
       		}  
       		etiqueta.setText(ayuda);
       	}
       	else{
       		etiqueta.setText(a);  
       	}
	    }
	    return etiqueta;
	    }
		public String NumerosIguales(String a)
		{
			String[]b=new String[a.length()];
			String[]c=new String[a.length()];
			String devolver="";
			boolean enc =false;
			for(int i=0;i<a.length();i++){
				b[i]=a.substring(i, i+1);
				enc=false;
				for(int j=0;j<c.length;j++)
				{
					if(b[i].equals(c[j]))
					{
						enc=true;
					}
				}
				if(!enc)
				{
					c[i]=b[i];
				}
				else
				{
					c[i]="";	
				}
			}

			for(int j=0;j < c.length;j++){

				devolver=devolver+c[j];

			}

			return devolver;
		}
		public  boolean esUnNumero(String cadena)
		{
			try {
				Integer.parseInt(cadena);
				return true;
			} catch (NumberFormatException nfe){
				return false;
			}
		}
		public  JLabel seleccionarColor(JTable table, JLabel etiqueta, String value)
		{
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					contiene[i][j] = false;
					if(value instanceof String)
					{
						System.out.println(value);
						if(value.equals(valores[i][j]))
						{
							contiene[i][j] = true;	
						}
						else
						{
							contiene[i][j] = false;
						}
					}
				}
			}
			for(int i = 0; i < contiene.length; i++)
			{
				for(int j = 0; j < contiene[i].length; j++)
				{
					if(contiene[i][j])
					{
						etiqueta.setBackground(Color.YELLOW);
					}
				}
			}
			return etiqueta;
		}
	}
}
