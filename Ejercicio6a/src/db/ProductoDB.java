package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.LinkedList;

import entidades.ProductLogic;

public class ProductoDB {
	// ajustar connection BD
	public static void addNew(ProductLogic prod) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet keyRseltSet = null;
		try {
																/*int id, stock;
																String name, description;
																double price;
																boolean shippingIncluded;*/
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","java","himitsu");
			pstmt = conn.prepareStatement("INSERT INTO product(stock, name, description, price, shippingIncluded) VALUES(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			//(stock, name, description, price, shippingIncluded)
			pstmt.setInt(1, prod.getStock());
			pstmt.setString(2, prod.getName());
			pstmt.setString(3, prod.getDescription());
			pstmt.setDouble(4, prod.getPrice());
			pstmt.setBoolean(5, prod.isShippingIncluded());
			keyRseltSet = pstmt.getGeneratedKeys();
			
			if(keyRseltSet != null && keyRseltSet.next()) {
				int _id = keyRseltSet.getInt(1);				
				prod.setId(_id);
			}			
						
		} catch (SQLException ex) {
			//Manejo de errores
			ex.printStackTrace();			
		} finally 	{
					try { 
						System.out.println("Producto agregado con exito, id: "+prod.getId());
						if (keyRseltSet != null) {keyRseltSet.close();}
						if (pstmt != null) {pstmt.close();}
						conn.close(); } 
					catch (SQLException e) { e.printStackTrace(); }
					}
		
	}
	
	public static ProductLogic getOne(int _id) {
		ProductLogic prod = new ProductLogic();
		Connection conn = null;
		PreparedStatement stmt= null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","java","himitsu");
			stmt = conn.prepareStatement("SELECT * FROM product WHERE id=?");
			stmt.setInt(1, _id);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				prod.setId(rs.getInt("id"));
				prod.setDescription(rs.getString("description"));
				prod.setName(rs.getString("name"));
				prod.setPrice(rs.getDouble("price"));
				prod.setStock(rs.getInt("stock"));
				prod.setShippingIncluded(rs.getBoolean("shippingIncluded"));				
			}
			
			
		} catch (SQLException ex) {
			//Manejo de errores
			ex.printStackTrace();			
		} finally 	{
					try { if (rs != null) {rs.close();}
					if (stmt != null) {stmt.close();}
					conn.close(); } 
					catch (SQLException e) { e.printStackTrace(); }
					}
		return prod;
		
	}
	
	public static LinkedList<ProductLogic> getAll() {
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		LinkedList<ProductLogic> products = new LinkedList<>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","java","himitsu");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, name, price FROM product");
			
			while (rs.next()) {
				ProductLogic p = new ProductLogic();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				products.add(p);
			}
			
		} catch (SQLException ex) {
			//Manejo de errores
			ex.printStackTrace();			
		} finally 	{
					try { if (rs != null) {rs.close();}
					if (stmt != null) {stmt.close();}
					conn.close(); } 
					catch (SQLException e) { e.printStackTrace(); }
					}
		return products;
	}
	
	public static void deleteOne(ProductLogic _prod) {
		
		Connection conn = null;		
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","java","himitsu");
			stmt = conn.prepareStatement("DELETE FROM product WHERE id=?");
			stmt.setInt(1, _prod.getId());			
			stmt.executeUpdate();
		
		} catch (SQLException ex) {
			//Manejo de errores
			ex.printStackTrace();
			
		} finally 	{
			try { if (stmt != null) { stmt.close();} conn.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
			}
		
	}
	
	public static void updateOne(ProductLogic _prod) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/javamarket","java","himitsu");
			stmt = conn.prepareStatement("UPDATE product set stock = ?, name = ?, description = ?, price = ?, shippingIncluded = ? WHERE id=?");
			stmt.setInt(1, _prod.getStock());
			stmt.setString(2, _prod.getName());
			stmt.setString(3, _prod.getDescription());
			stmt.setDouble(4, _prod.getPrice());
			stmt.setBoolean(5, _prod.isShippingIncluded());
			
			stmt.executeUpdate();
			
		 } catch (SQLException ex) {
			//Manejo de errores
			ex.printStackTrace();
			
		} finally 	{
					try { if (stmt != null) { stmt.close();} conn.close(); } 
					catch (SQLException e) { e.printStackTrace(); }
					}
		
		
	}
}
