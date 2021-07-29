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

    //Busqueda Binaria 
    public void busquedaBinaria(ListaDoble lista, int bus) {
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        int inferior = 0;
        int centro;
        boolean cambios = false;
        int superior = lista.getLargo() - 1;
        lista.actual = lista.inicio;

        // metodo para busqueda Binaria
        while (inferior <= superior) {
            centro = (superior + inferior) / 2;
            
            if (centro <= 0) {
                break;
            }
            
            lista.actual = lista.obtenerIndex(lista, centro - 1);
            
            if (lista.actual.getValue() == bus) {
                System.out.println("el numero buscado esta en la posicion " + (centro - 1));
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                JOptionPane.showMessageDialog(null, "El numero buscado esta en la posicion " + (centro - 1) + "\n" + "El tiempo de busqueda fue: " + tiempo + "milisegundos");
                cambios = true;
                break;
            } else if (bus < lista.actual.getValue()) {
                superior = centro - 1;
            } else {
                inferior = centro + 1;
            }
        }
        if(cambios == false) {
            JOptionPane.showMessageDialog(null, "El numero buscado no se encuentra en la lista.");
        }
    }

    /*public void busquedaInterpolacion(ListaDoble lista, int busqueda) {
        int numElementos; //tamaño
        boolean buscas = false;
        int indice;

        numElementos = lista.getLargo() - 1;
        int inicio = 0;
        int fin = numElementos;
// Índice = Bajo + (((Tecla – Arr[Low]) * (Alto – Bajo)) / Arr[High] -Arr[Low] ). algoritmo 
        for (int j = 0; j < lista.getLargo(); j++) {
            indice = inicio + (((busqueda - lista.inicio.getValue()) * (fin - inicio)) / lista.fin.getValue() - lista.inicio.getValue());
            System.out.println(indice);
            System.out.println(lista.inicio.getValue());
            System.out.println(lista.fin.getValue());

            if (indice > fin) {
                break;
            } else if (indice <= 0) {
                indice = inicio;
            }
            lista.actual = lista.obtenerIndex(lista, indice);
            //if (indice >= inicio && indice <= fin) {
                if ((lista.actual.getValue() == busqueda)) {
                    System.out.println("el numero buscado esta en la posicion " + (indice));
                    buscas = true;
                    indice = 0;
                    inicio = 0;
                    fin = numElementos;
                    break;
                    //esta parte del metodo esta fallando, debe avanzar o retroceder dependiendo del valor de busqueda(numero buscado)
                } else if (lista.actual.getValue() < busqueda) {
                    inicio = indice + 1;
                    //lista.actual = lista.actual.getNext();
                    buscas = false;
                } else if (lista.actual.getValue() > busqueda) {
                    fin = indice - 1;
                    //lista.actual = lista.actual.getPrevious();
                    buscas = false;
                }
            //}
            if (buscas == false) {
                System.out.println("el numero no se encuentra en la lista");
            }
        }
    }*/
    
    //Busqueda por Interpolacion
    public void busquedaInterpolacion(ListaDoble lista, int busqueda) {
        int numElementos; //tamaño
        boolean buscas = false;
        int indice;

        numElementos = lista.getLargo() - 1;
        int inicio = 0;
        int fin = numElementos;

        //Índice = Bajo + (((Tecla – Arr[Low]) * (Alto – Bajo)) / Arr[High] -Arr[Low] ). algoritmo 
        for (int j = 0; j < lista.getLargo(); j++) {

            //indice = inicio + (((busqueda - lista.inicio.getValue()) * (fin - inicio)) / lista.fin.getValue() - lista.inicio.getValue());
            //Este es mas eficiente lo encuentra mas rapido!!
            indice = ((fin) * (busqueda - lista.inicio.getValue()) / (lista.fin.getValue() - lista.inicio.getValue()));
            System.out.println(indice);

            System.out.println(lista.inicio.getValue());
            System.out.println(lista.fin.getValue());

            if (indice > fin) {
                break;
            } else if (indice < 0) {
                break;
            }
            if (indice < inicio) {
                indice = inicio;
            }

            lista.actual = lista.obtenerIndex(lista, indice);

            if ((lista.actual.getValue() == busqueda)) {
                System.out.println("El numero buscado esta en la posicion " + (indice));
                buscas = true;
                break;
            } else if (lista.actual.getValue() < busqueda) {
                inicio = indice + 1;
            } else if (lista.actual.getValue() > busqueda) {
                fin = indice - 1;
            }
        }
        
        if (buscas == false) {
            System.out.println("El numero no se encuentra en la lista.");
        }
    }
    
    //Busqueda por Hash
    

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
