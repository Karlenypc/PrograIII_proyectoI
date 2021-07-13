/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograiii_proyectoi;

/**
 *
 * @author Karlenypc
 */
public class MetodoOrdenamiento {    //BubbleSort

    public void bubbleSort(ListaDoble lista) {

        Nodo aux;
        boolean changes = false;

        lista.setActual(lista.getInicio());
        while (true) {

            for (int i = 0; i < lista.getLargo(); i++) {
                if (lista.getActual().getValue() > lista.getActual().getNext().getValue()) {
                    aux = lista.getActual().getNext();
                    System.out.println(aux.getValue());
                    lista.mostrar();
                    //lista.getActual().setNext(lista.getActual());
                    //System.out.println(lista.getActual().getNext().getValue());
                    //lista.mostrar();
                    lista.getActual().setPrevious(aux);
                    System.out.println(lista.getActual().getValue());
                    System.out.println(lista.getActual().getPrevious().getValue());
                    lista.mostrar();
                    System.out.println(lista.getActual().getNext().getValue());
                    changes = true;
                }
                lista.setActual(lista.getActual().getNext());
                System.out.println(lista.getActual().getValue());
            }
            if (changes == false) {
                break;
            }
        }
    }

    public void prueba(ListaDoble lista) {

        Nodo aux = lista.getInicio();
        boolean changes = false;

        while (true) {

            for (int i = 1; i < lista.getLargo(); i++) {
                Nodo aux2 = aux.getNext();
                System.out.println(aux2.getValue());
                if (aux.getValue() > aux2.getValue()) {
                    int auxDato = aux.getValue();
                    aux.setValue(aux2.getValue());
                    aux2.setValue(auxDato);
                    changes = true;
                } else {
                    changes = false;
                }

                aux2 = aux2.getNext();
                //System.out.println(aux2.getValue());
                aux = aux.getNext();
                System.out.println(aux.getValue());
                
                
                if (aux2 == null) {
                    aux = lista.getInicio();
                    aux2 = aux.getNext();
                }
   
            }

            if (changes == false) {
                break;
            }

            lista.mostrar();
        }

    }
    //aux = aux.getNext();
}

