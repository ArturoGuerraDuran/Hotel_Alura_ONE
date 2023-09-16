package Controller;

import java.sql.Connection; 
import java.sql.Date;
import java.sql.Statement;
import java.util.List;

import Factory.ConnectionFactory;
import Modelo.ModeloReservaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.daoReservaciones;

public class ReservasController {
	
	private daoReservaciones daoReservaciones;
	
	public ReservasController(){
		Connection connection=new ConnectionFactory().recuperarConexion();
		this.daoReservaciones=new daoReservaciones(connection);
	
	}
		public void Guardar(ModeloReservaciones modeloReservaciones) {
			this.daoReservaciones.Guardar(modeloReservaciones);
		}
		
		public List<ModeloReservaciones> Buscar(){
			return this.daoReservaciones.Buscar();
		}
		
		public List<ModeloReservaciones> Buscarid(String id){
			return this.daoReservaciones.Buscarid(id);
		}
		
		public void Eliminar(Integer id) {
			this.daoReservaciones.Eliminar(id);
		}
		
		 public void Actualizar(Date CheckIn, Date CheckOut, String valor, String formaPago,Integer id) {
			 this.daoReservaciones.Actualizar(CheckIn, CheckOut, valor, formaPago, id);	 
		 }
		 
		 
	
	}

