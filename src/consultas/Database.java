/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Meltsan
 */
public class Database {
private String host;
	private String user;
	private String password;
	private String port;
	private String dir;
	private Statement stmt;
	private Connection con;
	public Database() {
 
	}
	public Database(String h, String u, String p, String po, String s) {
		port=po;
		host=h;
		password=p;
		dir=s;
		user=u;
	}
 
	public boolean conectar() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":"+dir,user,password);
			stmt=con.createStatement();
			return true;
		}
		catch(Exception e){
			return false;
			}
	}
	public String ejecutarConsulta(String consulta) { // Cambia este método para hacer con la consulta lo que gustes
		try {
 
			ResultSet rs=stmt.executeQuery(consulta);
			String devolver="";
			while(rs.next()) {
				for(int i=1; i<=rs.getFetchSize(); i++) {
					devolver+=rs.getString(i)+" ";
				}
				devolver+="\n";
			}
			return devolver;
		}
		catch (Exception SQLException) {
			System.out.println("Saltó la escepción\n"+SQLException);
		}
		return "error";
	}
	public boolean desconectar() {
		try {
			con.close();
			return true;
		}
		catch (Exception SQLException) {
			return false;
		}
	}    
}
