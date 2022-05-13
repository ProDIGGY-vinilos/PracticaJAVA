package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

import Entidad.Documento;
import Entidad.Persona;

public class Principal {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	
		getAll();		
		getOne();
	    addNew();
	}

  private static void addNew() {
	   Connection conn = null;
	   Persona newp = new Persona();
	   Documento newd = new Documento();
	   System.out.println("A continuacion ingrese todos los datos de la persona nueva agregar: ");
	  
	   Scanner lector = new Scanner(System.in);
	   System.out.print("Ingrese nombre:");     newp.setNombre(lector.nextLine());
	   System.out.print("Ingrese apellido:");   newp.setApellido(lector.nextLine());
	   System.out.print("Ingrese habilitado:"); newp.setHabilitado(lector.nextBoolean());
	   System.out.println("Ingrese tipo:");     newd.setTipo(lector.nextLine());
	   System.out.print("Ingrese nro doc:");    newd.setNro(Integer.parseInt(lector.nextLine()));
	   
	   newp.setDocumento(newd);	      
	   lector.close();
	   
	   try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/javaTest","java","himitsu");
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO persona(tipo_doc, nro_doc, nombre, apellido, estaHabilitado) VALUES (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, newp.getDocumento().getTipo());
		pstmt.setInt(2, newp.getDocumento().getNro());
		pstmt.setString(3, newp.getNombre());
		pstmt.setString(4, newp.getApellido());
		pstmt.setBoolean(5, newp.isHabilitado());
		pstmt.executeUpdate();
		
		ResultSet keyResultSet = pstmt.getGeneratedKeys();
		
		if(keyResultSet != null && keyResultSet.next()) {
			int id= keyResultSet.getInt(1);
			System.out.println("ID: "+id);
			newp.setId(id);
		}
		
		if(keyResultSet != null) {keyResultSet.close(); }
		if (pstmt != null) { pstmt.close();	}
		conn.close();
		
	   } catch (SQLException ex) {
		   // Manejo de errores
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
	}
	   
   }

	private static void getOne() {
		int _id;
		Connection conn = null;
		System.out.print("Ingrese id 1 or 2:  ");
		Scanner lector = new Scanner(System.in);
		_id = lector.nextInt();
		lector.close();
		try {
			//coenctar a DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javaTest","java","himitsu");
			// Defenir  query
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM persona WHERE id=?");
			
			
			// setear el/los Parametros
			stmt.setInt(1, _id);
			
			Persona p = new Persona();
			Documento d = new Documento();
			p.setDocumento(d);
			
			// ejecutar query y obtener resultados
			ResultSet rs = stmt.executeQuery();	
			
			//mapear de resulset a objeto
			while (rs.next()) {			
				p.setId(rs.getInt("id"));
				d.setNro(rs.getInt("nro_doc"));
				d.setTipo(rs.getString("tipo_doc"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setHabilitado(rs.getBoolean("estaHabilitado"));
								
			 }
			
			//cerrar conexion
			if (rs != null) {rs.close();}
			if (stmt != null) {stmt.close();}
			conn.close();
			
			// mostrar data
			System.out.println("Persona encontrada: ");
			System.out.println(p);
			System.out.println();System.out.println();
		
		} catch (SQLException ex) {
			//Manejo de errores
			System.out.println("SQLException: "+ ex.getMessage());
			System.out.println("SQLState: "+ ex.getSQLState());
			System.out.println("VendorError: "+ ex.getErrorCode());
		}
	}
		
	

	private static void getAll() {
				
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
