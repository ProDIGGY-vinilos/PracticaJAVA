package Entidades;

public class Empleado {

	private String nombre, apellido, email;
	private int dni; 
	private double sueldoBase;
	
	public String getNombre() {	return nombre;	}
	public void setNombre(String nombre) { this.nombre = nombre;	}
	
	public String getApellido() { return apellido;	}
	public void setApellido(String apellido) {	this.apellido = apellido;	}
	
	public String getEmail() { return email;	}
	public void setEmail(String email) { this.email = email;	}
	
	public int getDni() { return dni;	}
	public void setDni(int dni) { this.dni = dni;	}
	
	public double getSueldoBase() { return sueldoBase;	}	
	public void setSueldoBase(double sueldoBase) {	this.sueldoBase = sueldoBase;	}
	
	public Empleado() {
		this.setNombre("");
		this.setApellido("");
		this.setDni(0);
		this.setEmail("");
		this.setSueldoBase(0);
	}
	
	public Empleado(String nom, String ap, String em, int _dni, double sueldoB) {
		this.setNombre(nom);
		this.setApellido(ap);
		this.setDni(_dni);
		this.setEmail(em);
		this.setSueldoBase(sueldoB);
	}
	
	public double getSueldo() {
		double sueldo = this.getSueldoBase();
		return sueldo;
	}
	
	
	
}
