package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.ModeloHuespedes;
import Modelo.ModeloReservaciones;


public class daoHuespedes {
	
private Connection connection;
	
	public daoHuespedes(Connection connection) {
		this.connection=connection;
		
	}
	
	public void guardar(ModeloHuespedes modeloHuespedes) {
		String SQL="INSERT INTO huespedes(Nombre, Apellido,Fecha_de_nacimiento,Nacionalidad, Telefono, Id_Reserva)VALUES(?,?,?,?,?,?)";
		
		try(PreparedStatement pstm=connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setString(1,modeloHuespedes.getNombre());
			pstm.setString(2, modeloHuespedes.getApellido());
			pstm.setDate(3, modeloHuespedes.getFecha_de_nacimiento());
			pstm.setString(4, modeloHuespedes.getNacionalidad());
			pstm.setString(5, modeloHuespedes.getTelefono());
			pstm.setInt(6,modeloHuespedes.getId_Reserva());
			
			int filasAfectadas= pstm.executeUpdate();
			
			ResultSet generatedKeys = pstm.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				int idGenerado=generatedKeys.getInt(1);
				modeloHuespedes.setId(idGenerado);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ModeloHuespedes> listarHuespedes(){
		List<ModeloHuespedes> reservaciones=new ArrayList<>();
		
		try {
			String SQL="SELECT  Id, Nombre, Apellido, Fecha_de_nacimiento, Nacionalidad,Telefono, Id_Reserva FROM huespedes";
			
					try(PreparedStatement pstm= connection.prepareStatement(SQL)){
						pstm.execute();
						
						transformarResultSetEnReservacion(reservaciones, pstm);
					}
			return reservaciones;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		  }	
	}
	
	public List<ModeloHuespedes> BuscarId(String id){
		List<ModeloHuespedes> reservaciones= new ArrayList<>();
		
		try {
			String SQL= "SELECT  Id, Nombre, Apellido, Fecha_de_nacimiento, Nacionalidad, Telefono, Id_Reserva FROM huespedes WHERE id=?";
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
		
		String SQL="DELETE FROM huespedes WHERE id=?";
		
		try(PreparedStatement pstm=connection.prepareStatement(SQL)){
			pstm.setInt(1, id);
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		  }		
	}
	 public void Actualizar(String Nombre, String Apellido, Date Fecha_de_nacimiento, String Nacionalidad, String Telefono, Integer Id_Reserva,Integer id) {
		 String SQL="UPDATE huespedes SET Nombre=?, Apellido=?, Fecha_de_nacimiento=?, Nacionalidad=?, Telefono=?, Id_Reserva=? WHERE id=?";
		 
		 try(PreparedStatement pstm=connection.prepareStatement(SQL)){
			pstm.setString(1, Nombre); 
			pstm.setString(2, Apellido); 
			pstm.setDate(3, Fecha_de_nacimiento); 
			pstm.setString(4, Nacionalidad); 
			pstm.setString(5, Telefono); 
			pstm.setInt(6,Id_Reserva);
			pstm.setInt(7, id);
			
			pstm.execute(); 
		 }catch(SQLException e) {
			 throw new RuntimeException(e);
		  } 
	 }	
	
	private void transformarResultSetEnReservacion(List<ModeloHuespedes> reservaciones, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				ModeloHuespedes reservacionesx = new ModeloHuespedes(rst.getInt(1), rst.getString(2),rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6),rst.getInt(7));
				reservaciones.add(reservacionesx);
			}
		}				
	}
	


}
