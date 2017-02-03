/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import consultas.Database;

/**
 *
 * @author Meltsan
 */
public class Tester {
    public static void main(String Args[]){
        Database d = new Database();
		if(d.conectar()){
                     d.eliminarCountry("PB");
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");           
    }
}
