package dbrelated;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatos {
	
	String nombre = "jdbc:h2:~/baseDatosPractica3Wilmar";
	String userName = "";
	String passWd = "";
	Connection conx = null; 
	
	public ConexionBaseDatos() {
		
		try {
	
		Class.forName("org.h2.Driver");
		conx = DriverManager.getConnection(nombre + userName + passWd);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public Connection getConx() {
		return conx;
	}
	
	public void closeConx() {
		conx = null; 
	}
	
	

}
