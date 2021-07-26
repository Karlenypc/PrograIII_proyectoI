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
 
        Nodo temp = lista.getInicio();
        for (int i = 0; i < lista.getLargo(); i++) {

            if (temp.getValue() == bus) {
                JOptionPane.showMessageDialog(null, "el numero buscado esta en la lista");
                System.out.println("Encontrado");
                break;

            } else {
                temp = temp.getNext();
                System.out.println("no encontrado");

            }
        }
    }

//
//        //Busqueda Binaria
    public void busquedaBinaria(ListaDoble lista, int bus) {
        int inferior = 0;
        int centro;
        int superior = lista.getLargo() - 1;

        // metodo para busqueda Binaria
        while (inferior <= superior) {
            centro = (superior + inferior) / 2;
            lista.actual.setValue(centro);
            if (lista.actual.getValue() == bus) {
                System.out.println("el numero buscado esta en la posicion " + (centro + 1));
                break;
            } else if (bus< lista.actual.getValue()) {
                superior = centro - 1;
            } else {
                inferior = centro + 1;
            }
        }
    }
    //
    //
    //
    //        //Busqueda por Interpolacion
    //        int numBus3;   //Numero que deseamos buscar
    //        int numElementos; //tamaño
    //        boolean buscas = false;
    //        int nBus;
    //
    //        System.out.println("Cual numero desea buscar?");
    //        numBus3 = input.nextInt();
    //        numElementos = numeros.size()-1;
    //        int inicio = 0;
    //        int fin= numElementos;
    //
    //
    //        for (int j = 0; j<numeros.size();j++){
    //            nBus= ((fin)*(numBus3-(int)numeros.get(inicio))/((int)numeros.get(fin)-(int)numeros.get(inicio)));
    //
    //            if(nBus>fin){
    //                break;
    //            }else if(nBus<0){
    //                nBus =inicio;
    //            }
    //            if(nBus >= inicio && nBus<= fin){
    //                if((int)numeros.get(nBus)==numBus3){
    //                    System.out.println("el numero buscado esta en la posicion " + (nBus));
    //                    buscas = true;
    //                    break;
    //                }else if((int)numeros.get(nBus)<numBus3){
    //                    inicio = inicio  - 1;
    //
    //                }else if((int)numeros.get(nBus)>numBus3){
    //                    inicio = inicio + 1;
    //                }
    //            }
    //            if (buscas == false){
    //                System.out.println("el numero no se encuentra en la lista");
    //            }
    //        }
    //    }
    //}

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
