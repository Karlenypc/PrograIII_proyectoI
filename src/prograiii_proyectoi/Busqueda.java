package prograiii_proyectoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Busqueda extends ListaDoble {

    int numBuscado;

    public Busqueda() {
    }

    //Busqueda Secuencial
    public void busquedaSecuencial(ListaDoble lista, int bus) {
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        Nodo temp = lista.getInicio();
        for (int i = 0; i < lista.getLargo(); i++) {

            if (temp.getValue() == bus) {
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                JOptionPane.showMessageDialog(null, "el numero buscado esta en la lista" + " \n" + "El tiempo de busqueda fue: " + tiempo + " milisegundos");
                System.out.println("Encontrado");

                break;

            } else {
                temp = temp.getNext();
                System.out.println("no encontrado");

            }
        }

    }

    //Busqueda Binaria LISTA
    public void busquedaBinaria(ListaDoble lista, int bus) {
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        int inferior = 0;
        int centro;
        int superior = lista.getLargo() - 1;
        lista.actual = lista.inicio;

        // metodo para busqueda Binaria
        while (inferior <= superior) {
            centro = (superior + inferior) / 2;
            lista.actual = lista.obtenerIndex(lista, centro - 1);
            if (lista.actual.getValue() == bus) {
                System.out.println("el numero buscado esta en la posicion " + (centro));
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                JOptionPane.showMessageDialog(null, "El numero buscado esta en la posicion " + (centro) + "\n" + "El tiempo de busqueda fue: " + tiempo + "milisegundos");
                break;
            } else if (bus < lista.actual.getValue()) {
                superior = centro - 1;
            } else {
                inferior = centro + 1;
            }
        }
    }

    //
    //
    public void busquedaInterpolacion(ListaDoble lista, int bus) {
        int numElementos; //tamaño
        boolean buscas = false;
        int nBus;

        numElementos = lista.getLargo() - 1;
        int inicial = 0;
        int fina = numElementos;
// Índice = Bajo + (((Tecla – Arr[Low]) * (Alto – Bajo)) / Arr[High] -Arr[Low] ). algoritmo 
        for (int j = 0; j < lista.getLargo(); j++) {
            nBus = inicial + ((bus - lista.inicio.getValue()) * (fina - inicial)) / lista.fin.getValue() - lista.inicio.getValue();
            System.out.println(nBus);

            if (nBus > fina) {
                break;
            } else if (nBus < 0) {
                nBus = inicial;
            }
            lista.actual = lista.obtenerIndex(lista, nBus);
            if (nBus >= inicial && nBus <= fina) {
                if ((lista.actual.getValue() == bus)) {
                    System.out.println("el numero buscado esta en la posicion " + (nBus));
                    buscas = true;
                    break;
                    //esta parte del metodo esta fallando, debe avanzar o retroceder dependiendo del valor de bus(numero buscado)
                } else if (lista.actual.getValue() < bus) {
                    inicial = inicial - 1;

                } else if (lista.actual.getValue() > bus) {
                    inicial = inicial + 1;
                }
            }
            if (buscas == false) {
                System.out.println("el numero no se encuentra en la lista");
            }
        }
    }

    public int getNumBuscado() {
        return numBuscado;
    }

    public void setNumBuscado(int numBuscado) {
        this.numBuscado = numBuscado;
    }

}
//
//    
//
