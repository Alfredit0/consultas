/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

/**
 *
 * @author Meltsan
 */
public class Consultas {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		Database d=new Database("localhost", "Tere", "tere", "1521", "orcl");
		String c="String";
		System.out.println("Conectando con la base de datos:");
		if(d.conectar())
			c=d.ejecutarConsulta("select * from employees");
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");
		System.out.println(c);
	}
    
}
