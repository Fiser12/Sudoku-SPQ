package es.deusto.ingenieria.spq.sudoku.client.remote;

import java.rmi.RMISecurityManager;

import es.deusto.ingenieria.spq.sudoku.server.remote.ISudokuS;

@SuppressWarnings("deprecation")
public class RMIServiceLocator{
	
	private ISudokuS service;

    public RMIServiceLocator(){ 
     
    }

    public void setService(String[] args) {
    	
    	// Add your code to get the TARGET reference HERE
    	
    	if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
    	
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			service = (ISudokuS) java.rmi.Naming.lookup(name);
		} catch (Exception e) {
			System.err.println("- Exception running the TVProgramManager: " + e.getMessage());
			e.printStackTrace();
		}
    }

    public ISudokuS getService() {
    	return service;
    }
}