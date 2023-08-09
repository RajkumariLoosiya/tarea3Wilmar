package main;

import logicanegocio.Logica_negocio;

public class Main {

	public static void main(String[] args) {
		
		Logica_negocio logicanegocio = new Logica_negocio();
	
//		logicanegocio.lecturaFichero();
//		logicanegocio.impresionDatos(logicanegocio.lecturaFichero());
		logicanegocio.rellenoBaseDatos(logicanegocio.lecturaFichero());
//		logicanegocio.impresionDatos(logicanegocio.lecturaFichero());

		
	}

}
