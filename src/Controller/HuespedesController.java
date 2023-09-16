package Controller;



import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import DAO.daoHuespedes;
import Factory.ConnectionFactory;
import Modelo.ModeloHuespedes;

public class HuespedesController {
	
	private daoHuespedes daoHuespedes;
	
	public HuespedesController(){
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.daoHuespedes =new daoHuespedes(connection);
		
	}
	
	public void guardar(ModeloHuespedes modeloHuespedes) {
		this.daoHuespedes.guardar(modeloHuespedes);
	}
	
	public List<ModeloHuespedes> listarHuespedes(){
		return this.daoHuespedes.listarHuespedes();
	}
	
	public List<ModeloHuespedes> BuscarId(String Id){
		return this.daoHuespedes.BuscarId(Id);
	}
	
	public void Eliminar(Integer id) {
		this.daoHuespedes.Eliminar(id);
	}
	
	public void Actualizar(String Nombre, String Apellido, Date Fecha_de_nacimiento, String Nacionalidad, String Telefono, Integer Id_Reserva,Integer id) {
		this.daoHuespedes.Actualizar(Nombre, Apellido, Fecha_de_nacimiento, Nacionalidad, Telefono,Id_Reserva, id);	
	}
	
	

}
