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

    public String bubbleSortIteraciones(ListaDoble lista) {
        
        String resultado = "";
        boolean cambios = false;
        
        if (lista.getInicio() != null) {
            
            Nodo aux = null, aux2 = null;
            int temp = 0;
            aux = lista.getInicio();

            while (aux != lista.getFin()) {
                
                aux2 = aux.getNext();

                while (aux2 != null) {
                    if (aux.getValue() > aux2.getValue()) {
                        temp = aux.getValue();
                        aux.setValue(aux2.getValue());
                        aux2.setValue(temp);
                        cambios = true;
                    }
                    aux2 = aux2.getNext();
                    if (cambios) {
                        resultado += lista.mostrarIteracion() + "\n";
                    }
                    cambios = false;
                }
                aux = aux.getNext();
                //resultado += lista.mostrarIteracion();
            }
        } else {
            System.out.println("Lista no inicializada!");
        }
        return resultado;
    }
    
    public String bubbleSort(ListaDoble lista) {
        
        String resultado = "";
        
        if (lista.getInicio() != null) {
            
            Nodo aux = null, aux2 = null;
            int temp = 0;
            aux = lista.getInicio();

            while (aux != lista.getFin()) {
                
                aux2 = aux.getNext();

                while (aux2 != null) {
                    if (aux.getValue() > aux2.getValue()) 
                    {
                        temp = aux.getValue();
                        aux.setValue(aux2.getValue());
                        aux2.setValue(temp);
                    }
                    aux2 = aux2.getNext();
                }
                aux = aux.getNext();
                resultado = lista.mostrarIteracion();
            }
        } else {
            System.out.println("Lista no inicializada!");
        }
        return resultado;
    }
}
