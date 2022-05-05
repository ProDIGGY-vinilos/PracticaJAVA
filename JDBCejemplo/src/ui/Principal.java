package ui;

import java.sql.*;
import java.util.LinkedList;

import Entidad.Documento;
import Entidad.Persona;

public class Principal {

	public static void main(String[] args) {
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		Connection conn = null;
		LinkedList<Persona> personas = new LinkedList<>();
		try {
			
			//hacer conexion
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaTest","java","himitsu");
			//ejecutar query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM persona");
			
			//mapear de resulset a objeto
			while (rs.next()) {
				Persona p = new Persona();
				Documento d = new Documento();
				p.setDocumento(d);
				
				p.setId(rs.getInt("id"));
				d.setNro(rs.getInt("nro_doc"));
				d.setTipo(rs.getString("tipo_doc"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setHabilitado(rs.getBoolean("estaHabilitado"));
				personas.add(p);				
			 }
			
			//cerrar conexion
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			conn.close();
			
			// mostrar data
			System.out.println("Listado completo");
			System.out.println(personas);
			System.out.println();System.out.println();
		
		} catch (SQLException ex) {
			//Manejo de errores
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("VendorError: "+ ex.getErrorCode());
		}
	}

}
