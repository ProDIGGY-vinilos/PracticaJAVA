package Entidades;

public class Administrativo extends Empleado {

	private double hsExtra, hsMes;

	public double getHsExtra() { return hsExtra;	}
	public void setHsExtra(double hsExtra) { this.hsExtra = hsExtra;	}

	public double getHsMes() {	return hsMes;	}
	public void setHsMes(double hsMes) { this.hsMes = hsMes;	}
	
	public Administrativo () {
		this.setHsExtra(0);
		this.setHsMes(0);
	}
	
	public Administrativo(double hsExtra, double hsMes) {
		this.setHsExtra(hsExtra);
		this.setHsMes(hsMes);		
	}
	public Administrativo(String nom, String ap, String em, int _dni, double sueldoB) {
		super(nom, ap, em, _dni, sueldoB);
	}
	public Administrativo(double hsExtra, double hsMes, String nom, String ap, String em, int _dni, double sueldoB) {
		super(nom, ap, em, _dni, sueldoB);
		this.setHsExtra(hsExtra);
		this.setHsMes(hsMes);		
	}
	
	@Override
	public double getSueldo() {
		double sueldo = 0;
		sueldo = this.getSueldoBase()*((this.getHsExtra()*1.5)+this.getHsMes())/this.getHsMes();
		return sueldo;
	}
	
	
}
