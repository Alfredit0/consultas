/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Meltsan
 */
public class Consultas {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) throws SQLException {
		Database d=new Database("localhost", "Tere", "tere", "1522", "orcl");
		ResultSet rs;
                String devolver ="";
		System.out.println("Conectando con la base de datos:");
		if(d.conectar()){
			rs=d.ejecutarConsulta("select * from employees");
                        while(rs.next()) {
				for(int i=1; i<=rs.getFetchSize(); i++) {
					devolver+=rs.getString(i)+" ";
				}
                                System.out.println(devolver);
                                devolver="";
                        }
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");
		
	}
    
}
