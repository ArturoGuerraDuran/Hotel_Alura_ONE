package Modelo;

import java.sql.Date;

public class ModeloReservaciones {

	
	
	private Integer id;
	private Date CheckIn;
	private Date CheckOut;
	private String valor;
	private String formaPago;
	
	
	public ModeloReservaciones(Date CheckIn, Date CheckOut, String valor, String formaPago) {		
		this.CheckIn = CheckIn;
		this.CheckOut = CheckOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}
		
	public ModeloReservaciones(Integer id, Date CheckIn, Date CheckOut, String valor, String formaPago) {
		this.id = id;
		this.CheckIn = CheckIn;
		this.CheckOut = CheckOut;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCheckIn() {
		return CheckIn;
	}

	public Date getCheckOut() {
		return CheckOut;
	}

	public String getvalor() {
		return valor;
	}

	public String getformaPago() {
		return formaPago;
	}

	
	@Override
	public String toString() {
		return String.format("La reserva generada fue: %d, %s, %s, %s, %s", this.id, this.CheckIn, this.CheckOut, this.valor, this.formaPago);
	}
	
	
	

}
