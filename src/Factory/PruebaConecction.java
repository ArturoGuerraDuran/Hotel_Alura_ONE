package Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class PruebaConecction {
		
		public static void main(String[] args) throws SQLException{
			
			ConnectionFactory factory=new ConnectionFactory();
			Connection conexion= factory.recuperarConexion();
			
			
			
			

			System.out.println("Probando conexion!!");

			conexion.close();
			
			System.out.println("Conexion cerrada!!");
		
		
		
}

}
