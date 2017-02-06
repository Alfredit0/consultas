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
        public boolean insertarDeparment(String id, String nombre,int managerId, int locationId){
            String consulta = "insert into departments (department_id, department_name, manager_id, location_id) values ("+
                              id+", '"+nombre+"', "+managerId+","+locationId+")";            
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
        public boolean actualizarDeparment(String id, String nombre, int managerId, int locationId){
            String consulta = "update departments Set  department_name='"+
                    nombre+"', manager_id = "+managerId+",location_id = "+locationId+"  Where department_id="+id;
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarDeparment(String id){
            String consulta = "delete from departments where department_id='"+id+"'";
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
        public boolean insertarJobHistory(String id, String dateStart,String dateEnd, String jobId, String depId){
            String consulta = "insert into job_history (employee_id, start_date, end_date, job_id, department_id) values ("+
                              id+", '"+dateStart+"', '"+dateEnd+"','"+jobId+"',"+depId+")";            
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
        public boolean actualizarJobHistory(String id, String dateStart,String dateEnd){
            String consulta = "update job_history Set end_date = '"+dateEnd+"' Where employee_id="+id+
                    " and start_date='"+dateStart+"'";;
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarJobHistory(String id, String date){
            String consulta = "delete from job_history where employee_id="+id+" and start_date='"+date+"'";
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
   // *************************** REGIONS OPERATIONS *********************************************** 
        
        public boolean insertarRegion(int id, String nombre){
            String consulta = "insert into regions (region_id, region_name) values ("+
                              id+", '"+nombre+"')";            
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
        public boolean actualizarRegion(int id, String nombre){
            String consulta = "update regions Set region_name = '"+nombre+"' Where region_id="+id;
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarRegion(int id){
            String consulta = "delete from regions where region_id="+id;
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
   // *************************** REGIONS OPERATIONS *********************************************** 
        
        public boolean insertarJob(String id, String title, int minSalary, int maxSalary){
            String consulta = "insert into jobs (job_id, job_title, min_salary, max_salary) values ('"+
                              id+"', '"+title+"', "+minSalary+","+maxSalary+")";            
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
        public boolean actualizarJob(String id, String title, int minSalary, int maxSalary){
            String consulta = "update jobs Set job_title = '"+title+"', min_salary="+minSalary+", max_salary="+
                    maxSalary+" Where job_id='"+id+"'";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarJob(String id){
            String consulta = "delete from jobs where job_id='"+id+"'";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta)){
                    System.out.println("Eliminacion correcta de job");
                    return true;
                }else{ 
                    System.out.println("Falla al eliminar job");
                    return false;
                }
            }catch(Exception e){
                return false;
            }
          
        }       
// *************************** LOCATIONS OPERATIONS *********************************************** 
        
        public boolean insertarLocation(int id,String address, String cp, String city,String state, String idCountry){
            String consulta = "insert into locations (location_id, street_address, postal_code, city, state_province, country_id) values ("+
                              id+", '"+address+"', '"+cp+"','"+city+"','"+state+"','"+idCountry+"')";            
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                System.out.println("Inserccion correcta en location");
                else
                    System.out.println("Ha ocurrido un error - Inserccion en location");
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
        public boolean actualizarLocation(int id,String address, String cp, String city,String state){
            String consulta = "update locations Set street_address = '"+address+"', postal_code='"+cp+"', city='"+
                    city+"', state_province='"+state+"' Where location_id="+id+"";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarLocation(int id){
            String consulta = "delete from locations where location_id="+id+"";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta)){
                    System.out.println("Eliminacion correcta de location");
                    return true;
                }else{ 
                    System.out.println("Falla al eliminar location");
                    return false;
                }
            }catch(Exception e){
                return false;
            }
          
        }                
// *************************** EMPLOYEES OPERATIONS *********************************************** 
        
        public boolean insertarEmployee(int id,String fName, String lName, String email,String phone, String hDate,
                String jobId, int salary, int commision, int mngId, int depId){
            String consulta = "insert into employees (EMPLOYEE_ID, FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,"+
                    "JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID, DEPARTMENT_ID) values ("+
                              id+", '"+fName+"', '"+lName+"','"+email+"','"+phone+"','"+hDate+"','"+jobId+","+salary+","+
                    commision+","+mngId+","+depId+")";            
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                System.out.println("Inserccion correcta en employees");
                else
                    System.out.println("Ha ocurrido un error - Inserccion en employees");
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
        public boolean actualizarEmployee(int id,String fName, String lName, String email,String phone, String hDate,
                float salary, float commision){
            String consulta = "update employees Set FIRST_NAME = '"+fName+"', LAST_NAME='"+lName+"', EMAIL='"+
                    email+"', PHONE_NUMBER='"+phone+"', HIRE_DATE ='"+hDate+"', SALARY="+
                    salary+", COMMISSION_PCT="+commision+" Where employee_id="+id+"";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta))
                    System.out.println("Actualizacion correcta");
                return true;
            }catch(Exception e){
                return false;
            }
        }         
        public boolean eliminarEmployees(int id){
            String consulta = "delete from employees where EMPLOYEE_ID="+id+"";
            System.out.println(consulta);
            try{
                if(ejecutarActualizacion(consulta)){
                    System.out.println("Eliminacion correcta de employees");
                    return true;
                }else{ 
                    System.out.println("Falla al eliminar job");
                    return false;
                }
            }catch(Exception e){
                return false;
            }
          
        }         
/**
 * 
 * @param sql
 * @return 
 */        
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
