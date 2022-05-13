package Entidades;

public class Vendedor extends Empleado {
	
	private int totalVentas;
	private float porcenComision;
	
	public int getTotalVentas() { return totalVentas;	}
	public void setTotalVentas(int totalVentas) { this.totalVentas = totalVentas;	}
	
	public float getPorcenComision() { return porcenComision;	}
	public void setPorcenComision(float porcenComision) { this.porcenComision = porcenComision;	}
	
	public Vendedor() {
		this.setTotalVentas(0);
		this.setPorcenComision(0);
	}
	public Vendedor(int totalVentas, float porcenComision) {
		super();
		this.totalVentas = totalVentas;
		this.porcenComision = porcenComision;
	}
	public Vendedor(String nom, String ap, String em, int _dni, int sueldoB) {
		super(nom, ap, em, _dni, sueldoB);
	}
	public Vendedor(int totalVentas, float porcenComision, String nom, String ap, String em, int dni, double _sueldoBase) {
		super(nom, ap, em, dni, _sueldoBase);
		this.totalVentas = totalVentas;
		this.porcenComision = porcenComision;
	}
	
	@Override
	public double getSueldo() {
		double sueldo = 0;
		sueldo = this.getSueldoBase() + (this.getPorcenComision() * this.getTotalVentas() / 100);
		return sueldo;
	}
	
	
	
	
	

}
