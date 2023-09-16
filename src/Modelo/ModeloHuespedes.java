package Modelo;

import java.sql.Date;

public class ModeloHuespedes {
	
	private Integer Id;
	private String Nombre;
	private String Apellido;
	private Date Fecha_de_nacimiento;
	private String Nacionalidad;
	private String Telefono;
	private Integer Id_Reserva;
	
	
	public ModeloHuespedes(String Nombre, String Apellido, Date Fecha_de_nacimiento, String Nacionalidad, String Telefono, Integer Id_Reserva) {
		this.Nombre=Nombre;
		this.Apellido=Apellido;
		this.Fecha_de_nacimiento=Fecha_de_nacimiento;
		this.Nacionalidad=Nacionalidad;
		this.Telefono=Telefono;
		this.Id_Reserva=Id_Reserva;		
	}
	
	public ModeloHuespedes(Integer Id, String Nombre, String Apellido, Date Fecha_de_nacimiento, String Nacionalidad, String Telefono, Integer Id_Reserva) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Fecha_de_nacimiento = Fecha_de_nacimiento;
        this.Nacionalidad = Nacionalidad;
        this.Telefono = Telefono;
        this.Id_Reserva = Id_Reserva; 
    }

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public Date getFecha_de_nacimiento() {
		return Fecha_de_nacimiento;
	}

	public void setFecha_de_nacimiento(Date fecha_de_nacimiento) {
		Fecha_de_nacimiento = fecha_de_nacimiento;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public Integer getId_Reserva() {
		return Id_Reserva;
	}

	public void setId_reserva(Integer Id_reserva) {
		Id_Reserva = Id_reserva;
	}
	
	@Override
	public String toString() {
		return String.format("La reserva generada fue: %d, %s, %s, %s, %s, %s, %s", this.Id, this.Nombre, this.Apellido, this.Fecha_de_nacimiento, this.Nacionalidad, this.Telefono, this.Id_Reserva);
	}

}
