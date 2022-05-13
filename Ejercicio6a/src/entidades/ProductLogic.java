package entidades;

import java.util.LinkedList;

import db.ProductoDB;

public class ProductLogic {
	private int id, stock;
	private String name, description;
	private double price;
	private boolean shippingIncluded;
	
	
	public ProductLogic() {}
	public ProductLogic(int _id, int _stock, String _name, String _desc, double _price, boolean _shippingIncluded) {
		this.setPrice(_price);
		this.setDescription(_desc);
		this.setName(_name);
		this.setShippingIncluded(_shippingIncluded);
		this.setStock(_stock);
	}
	
	public int getId() 											{return id;	}
	public void setId(int id) 									{this.id = id; }
	
	public int getStock() 										{return stock; }
	public void setStock(int stock) 							{this.stock = stock; }
		
	public String getName() 		 							{return name; }
	public void setName(String name) 							{this.name = name; }
	
	public String getDescription() 								{return description; }
	public void setDescription(String description)  			{this.description = description; }
	
	public double getPrice() 									{return price; }
	public void setPrice(double price)  						{this.price = price; }
	
	public boolean isShippingIncluded() 						{return shippingIncluded; }
	public void setShippingIncluded(boolean shippingIncluded) 	{this.shippingIncluded = shippingIncluded; }
	
	public void addLogic(ProductLogic prod) {
		ProductoDB.addNew(prod);
	}
	
	public static ProductLogic getOneLogic(int id) {
		return db.ProductoDB.getOne(id);
	}
	public static LinkedList<ProductLogic> getAllLogic(){
		return db.ProductoDB.getAll();
	}
	public static void removeLogic(ProductLogic _prod) {
		db.ProductoDB.deleteOne(_prod);
	}
	public static void updateLogic(ProductLogic _prod) {
		db.ProductoDB.updateOne(_prod);
	}
	public static void addNewLogic(ProductLogic _prod) {
		db.ProductoDB.addNew(_prod);
	}	

}
