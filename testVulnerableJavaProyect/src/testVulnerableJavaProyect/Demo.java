package testVulnerableJavaProyect;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//https://www.youtube.com/watch?v=tevaMekDhIc
//8.13
public class Demo {

	public static void main(String[] args) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String stringConexion = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
			Connection conn=DriverManager.getConnection(  
					stringConexion,"root","Curso2019$"); 
			
		     
		  
		        System.out.println("Exito al abrir la conexion");
		        
		        
			System.out.println("Enter employee ID");
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			String empID = r.readLine();
			
			if (!empID.contains("emp")) 
				System.out.println("employee ID begins with emp e.g emp01.");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from usuario where id_usuario='" + empID +"'");
				
				while(rs.next()) {
					System.out.println(rs.getString("nombre") + " " + rs.getString("apellidos") + " "+
							rs.getString("email"));
							
					
				
			}
		
		}catch(Exception e){
			System.out.println(e);
		}
}

}
