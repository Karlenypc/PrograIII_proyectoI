/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograiii_proyectoi;

import java.util.Scanner;

/**
 *
 * @author Karlenypc
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListaDoble lista = new ListaDoble();
        MetodoOrdenamiento bS = new MetodoOrdenamiento();
        
        /*int numero;
        int cantNum;
        int rangoMayor;

        Scanner input = new Scanner(System.in);
        System.out.println("Que rango de numeros desea? ");
        System.out.print("entre 1 --> ");
        rangoMayor = input.nextInt();

        System.out.println("Cuantos numeros desea?");
        cantNum = input.nextInt();

// Metodo genera numeros entre 1 y 100
        for (int i = 1; i <= cantNum; i++) {
            numero = (int) (Math.random() * rangoMayor + 1);
            /*if (numeros.contains(numero)) {
                i--;
            } else {
                numeros.add(numero);
            }
            lista.insertar_alFinal(numero);
        }
        System.out.println("La cantidad de "+ cantNum + " numeros creados son:");
        lista.mostrar(); */
        
        
        
       lista.insertar_alInicio(45);
        lista.insertar_alFinal(450);
        lista.insertar_alFinal(3);
        lista.insertar_alFinal(78);
        lista.insertar_alFinal(19);
        
        bS.prueba(lista);
        lista.mostrar();
    }
    
}
