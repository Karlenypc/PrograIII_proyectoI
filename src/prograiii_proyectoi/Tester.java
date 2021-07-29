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

        int numero;
        int cantNum;
        int rangoMayor;

        Scanner input = new Scanner(System.in);
        int opcion;
        System.out.println("**BIENVENIDO**");

        do {
            System.out.println("-- Seleccione la opcion que desea: ");
            System.out.println("1) Digitar e ingresar números a la lista.");
            System.out.println("2) Generar números aleatorios a traves del rango "
                    + "deseado e incluirlos a la lista.");
            System.out.println("3) Mostrar lista ordenada.");
            System.out.println("4) Salir!");
            System.out.print("Por favor digite una opcion: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Cuantos números desea ingresar?");
                    cantNum = input.nextInt();
                    for (int i = 1; i <= cantNum; i++) {
                        System.out.print("Ingrese el " + i + " número: ");
                        numero = input.nextInt();
                        lista.insertar_alFinal(numero);
                    }
                    System.out.println("La cantidad de " + cantNum + " numeros creados son:");
                    lista.mostrar();
                    break;
                }

                case 2: {
                    System.out.println("Que rango de numeros desea? ");
                    System.out.print("entre 1 --> ");
                    rangoMayor = input.nextInt();
                    System.out.println("Cuantos numeros desea?");
                    cantNum = input.nextInt();

                    // Metodo genera numeros entre 1 y "x"
                    for (int i = 1; i <= cantNum; i++) {
                        numero = (int) (Math.random() * rangoMayor + 1);
                        lista.insertar_alFinal(numero);
                    }
                    System.out.println("La cantidad de " + cantNum + " numeros creados son:");
                    lista.mostrar();
                    break;
                }

                case 3: {
                    /*bS.bubbleSort(lista);
                    System.out.println("**LISTA ORDENADA**");
                    lista.mostrar();*/
                    lista.clonarListaArray(lista);
                    break;
                }

            }
        } while (opcion < 4);

    }
}
