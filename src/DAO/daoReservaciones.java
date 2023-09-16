package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controller.ReservasController;
import Modelo.ModeloHuespedes;
import Modelo.ModeloReservaciones;

public class daoReservaciones {
	
	private Connection connection;
	
	public daoReservaciones(Connection connection) {
		this.connection=connection;
		
	}
	
	public void Guardar(ModeloReservaciones modeloReservaciones) {
		String SQL="INSERT INTO reservaciones(checkIn, checkOut,valor,formapago)VALUES(?,?,?,?)";
		
		try(PreparedStatement pstm=connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setDate(1,modeloReservaciones.getCheckIn());
			pstm.setDate(2, modeloReservaciones.getCheckOut());
			pstm.setString(3, modeloReservaciones.getvalor());
			pstm.setString(4, modeloReservaciones.getformaPago());
			
			int filasAfectadas= pstm.executeUpdate();
			
			
			ResultSet generatedKeys = pstm.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				int idGenerado=generatedKeys.getInt(1);
				modeloReservaciones.setId(idGenerado);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ModeloReservaciones> Buscar(){
		List<ModeloReservaciones> reservaciones=new ArrayList<ModeloReservaciones>();
		
		try {
			String SQL="SELECT  id, checkIn, checkOut, valor, formapago FROM reservaciones";
			
					try(PreparedStatement pstm= connection.prepareStatement(SQL)){
						pstm.execute();
						
						transformarResultSetEnReservacion(reservaciones, pstm);
					}
			return reservaciones;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		  }	
	}
	
	public List<ModeloReservaciones> Buscarid(String id){
		List<ModeloReservaciones> reservaciones= new ArrayList<ModeloReservaciones>();
		
		try {
			String SQL= "SELECT  id, checkIn, checkOut, valor, formapago FROM reservaciones WHERE id=?";
			try(PreparedStatement pstm= connection.prepareStatement(SQL)){
				pstm.setString(1, id);
				pstm.execute();
				transformarResultSetEnReservacion(reservaciones, pstm);
				
			}return reservaciones;	
		}catch (SQLException e) {
			throw new RuntimeException(e);
		 }
		
		
	}
	
	public void Eliminar(Integer id) {
		
		String SQL="DELETE FROM reservaciones WHERE id=?";
		
		try(PreparedStatement pstm=connection.prepareStatement(SQL)){
			pstm.setInt(1, id);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		  }		
	}
	 public void Actualizar(Date CheckIn, Date CheckOut, String valor, String formaPago,Integer id) {
		 String SQL="UPDATE reservaciones SET checkIn=?, checkOut=?, valor=?, formapago=? WHERE id=?";
		 
		 try(PreparedStatement pstm=connection.prepareStatement(SQL)){
			pstm.setDate(1, CheckIn); 
			pstm.setDate(2, CheckOut); 
			pstm.setString(3, valor); 
			pstm.setString(4, formaPago); 
			pstm.setInt(5, id);
			
			pstm.execute(); 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		  } 
	 }	
	
	private void transformarResultSetEnReservacion(List<ModeloReservaciones> reservaciones, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				ModeloReservaciones reservacionesx = new ModeloReservaciones(rst.getInt(1), rst.getDate(2),rst.getDate(3), rst.getString(4), rst.getString(5));
				reservaciones.add(reservacionesx);
			}
		}				
	}
}
