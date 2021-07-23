/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograiii_proyectoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pimie
 */
public class InsertFile {
     int numeroEntero;

        File f = new File("C:\\Users\\pimie\\OneDrive\\Desktop\\Fabian\\University\\Programacion\\Progra3\\PrograIII_proyectoI\\NumbersTest.txt");
// prueba 
        try (Scanner entrada = new Scanner(f)){
            System.out.println( "numeros son :");
            while (entrada.hasNextInt()){
                numeroEntero = entrada.nextInt();
                System.out.println(numeroEntero);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

    }
    
}
