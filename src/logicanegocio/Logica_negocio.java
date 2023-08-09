package logicanegocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import beans.Compra;
import dbrelated.ConexionBaseDatos;

public class Logica_negocio{

	public List<Compra> lecturaFichero() {

		String rutaFichero = "C:\\Users\\migue\\Desktop\\Ejercicio3\\Compras.txt";
		String lectura;
		String producto = null;
		String precio = null;
		String cantidad = null;
		List<Compra> asd = new ArrayList<>();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(rutaFichero));

			reader.readLine();
			reader.readLine();
			reader.readLine();

			while ((lectura = reader.readLine()) != null) {

				if (lectura.contains("Producto:")) {
//					producto = lectura.substring(10); 
					producto = lectura.replaceAll("\\s+", "").substring(9);
				}
				if (lectura.contains("Precio:")) {
					precio = lectura.substring(8);
				}
				if (lectura.contains("Cantidad:")) {
					cantidad = lectura.substring(10);
				}

				if (lectura.contains("---------------------------------------------")) {
					Compra compra = new Compra(producto, precio, cantidad);
					asd.add(compra);
				}

			}
			Compra compra = new Compra(producto, precio, cantidad);
			asd.add(compra);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return asd;
	}

	public void rellenoBaseDatos(List<Compra>listaEntrada) {
		
		ConexionBaseDatos cbd = new ConexionBaseDatos();

//		String query = "CREATE TABLE IF NOT EXISTS VENTAS(PRODUCTO VARCHAR(50), CANTIDAD INT, PRECIO DOUBLE)";
		String query = "INSERT INTO VENTAS VALUES (?,?,?)";
		try {

			PreparedStatement pst = cbd.getConx().prepareStatement(query);
			for(Compra i: listaEntrada) {
			pst.setString(1, i.getNombre());
			pst.setInt(2, Integer.parseInt(i.getCantidad()));
			pst.setDouble(3, Double.parseDouble(i.getPrecio()));
			pst.executeUpdate();

			}
			cbd.closeConx();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void impresionDatos(List<Compra> listaEntrada) {

		for (Compra i : listaEntrada) {
			System.out.println(i);
		}

	}

}
