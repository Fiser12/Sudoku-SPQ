package es.deusto.ingenieria.spq.sudoku.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.spq.sudoku.client.gui.Login2;
import es.deusto.ingenieria.spq.sudoku.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.spq.sudoku.server.data.*;

public class SudokuController
{
	private RMIServiceLocator rsl;
	private String[] service;
	
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
	
	public void exit()
	{
		System.exit(0);
	}
	
	public void enviarPartida(Partida partida)
	{
		try{    		
    		this.rsl.getService().recibirPartida(partida);
    	} catch(Exception e){
    		System.out.println("$ Error sending a partida: " + e.getMessage());
    	}
	}
	
	public Usuario inicioSesion(String nick, String pass)
	{
		try{    		
    		return this.rsl.getService().inicioSesion(nick, pass);
    	} catch(Exception e){
    		System.out.println("$ Error iniciando sesion: " + e.getMessage());
    	}
		return null;
	}
	
	public Usuario registrar(String nick, String pass, String correo)
	{
		try{    		
    		return this.rsl.getService().registrar(nick, pass, correo);
    	} catch(Exception e){
    		System.out.println("$ Error registrando: " + e.getMessage());
    	}
		return null;
	}
	
	public Usuario guardarPartida(String nick, int[][] ultPar)
	{
		try{    		
    		return this.rsl.getService().guardarPartida(nick, ultPar);
    	} catch(Exception e){
    		System.out.println("$ Error guardando partida: " + e.getMessage());
    	}
		return null;
	}
	
	public List<Partida> getPartidas() {
		List<Partida> partidas = new ArrayList<>();
		try {
			partidas = rsl.getService().getPartidas();
		} catch (RemoteException e) {
			System.err.println("$ Error getting Partidas: " + e.getMessage());
		}
		return partidas;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[]args) throws RemoteException
	{
		SudokuController sudo = new SudokuController(args);
	}

}
