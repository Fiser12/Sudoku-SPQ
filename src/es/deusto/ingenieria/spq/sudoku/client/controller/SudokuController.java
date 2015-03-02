package es.deusto.ingenieria.spq.sudoku.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.spq.sudoku.client.gui.Login2;
import es.deusto.ingenieria.spq.sudoku.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.spq.sudoku.server.data.*;

public class SudokuController
{
	private RMIServiceLocator rsl;
	private String[] service;
	
	/** 
	 * Relaciona la aplicación con el ServiceLocator
	 * @param args
	 */
	public SudokuController(String[] args) throws RemoteException 
	{
		this.rsl = new RMIServiceLocator();
		this.service = args;
		rsl.setService(this.service);
		
		new Login2(this);
	}
	
	public String[] getService() {
		return this.service;
	}
	
	/**
	 * Cierra la conexión con el servidor
	 */
	public void exit()
	{
		System.exit(0);
	}
	
	/** 
	 * Envía una partida al servidor
	 * @param partida
	 */
	public void enviarPartida(Partida partida)
	{
		try{    		
    		this.rsl.getService().recibirPartida(partida);
    	} catch(Exception e){
    		System.out.println("$ Error sending a partida: " + e.getMessage());
    	}
	}
	
	/** 
	 * Envía los datos de logueo para verificar 
	 * @param nick
	 * @param pass
	 */
	public Usuario inicioSesion(String nick, String pass)
	{
		try{    		
    		return this.rsl.getService().inicioSesion(nick, pass);
    	} catch(Exception e){
    		System.out.println("$ Error iniciando sesion: " + e.getMessage());
    	}
		return null;
	}
	
	/** 
	 * Envía los datos para registrar 
	 * @param nick
	 * @param pass
	 */
	public Usuario registrar(String nick, String pass)
	{
		try{    		
    		return this.rsl.getService().registrar(nick, pass);
    	} catch(Exception e){
    		System.out.println("$ Error registrando: " + e.getMessage());
    	}
		return null;
	}
	
	
	/** Método principal
	 * 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[]args) throws RemoteException
	{
		SudokuController sudo = new SudokuController(args);
	}

}
