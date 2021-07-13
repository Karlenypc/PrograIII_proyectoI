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
public class Nodo {

    private int value;
    private Nodo previous;
    private Nodo next;

    //Constructor para cuando aun no existen "nodos" dentro de la lista
    public Nodo(int value) {
        this(value, null, null);
    }

    //Constructor para cuando ya existen "nodos" dentro de la lista
    public Nodo(int value, Nodo previous, Nodo next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}
