/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
	public Database() {
 		port="1521";
		host="localhost";
		password="adminhr";
		dir= "orcl";
		user="hr";
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
	public ResultSet ejecutarConsulta(String consulta) throws SQLException { // 
			ResultSet rs=stmt.executeQuery(consulta);
			return rs;	
	}
        public boolean insertarCountry(String id, String nombre, int region){
            String consulta = "insert into countries (country_id, country_name, region_id) values ('"+
                              id+"', '"+nombre+"', "+region+")";            
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                System.out.println("Inserccion correcta en country");
                else
                    System.out.println("Ha ocurrido un error - Inserccion en country");
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
        public boolean actualizarCountry(String id, String nombre, int region){
            String consulta = "update countries Set country_name='"+
                    nombre+"', region_id = "+region+" Where country_id='"+id+"'";
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarCountry(String id){
            String consulta = "delete from countries where country_id='"+id+"'";
            try{
                if(ejecutarActualizacion(consulta)){
                    System.out.println("Eliminacion correcta de country");
                    return true;
                }else{ 
                    System.out.println("Falla al eliminar country");
                    return false;
                }
            }catch(Exception e){
                return false;
            }
          
        }        
        public boolean ejecutarActualizacion (String sql) {
        try {
            Statement sentencia;
            sentencia = getCon().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            getCon().commit();
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
