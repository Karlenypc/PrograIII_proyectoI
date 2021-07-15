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
            }
        } else {
            System.out.println("Lista no inicializada!");
        }
    }
    
}
