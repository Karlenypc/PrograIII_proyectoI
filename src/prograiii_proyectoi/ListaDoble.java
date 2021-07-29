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
public class ListaDoble {

     Nodo inicio;
     Nodo actual;
     Nodo fin;
     int largo;

    public ListaDoble() //Inicializamos la lista
    {
        inicio = actual = fin = null;
        largo = 0;
    }

    //Metodo para saber si la lista esta vacia
    public boolean estaVacia() {
        return inicio == null;
    }

    public void insertar_alInicio(int dato) {
        if (estaVacia()) {
            inicio = new Nodo(dato);
            actual = inicio;
            fin = inicio;
        } else {
            Nodo nuevo = new Nodo(dato, null, inicio);
            inicio.setPrevious(nuevo);
            inicio = nuevo;
            actual = inicio;
        }
        largo++;
    }

    public void insertar_alFinal(int dato) {
        if (estaVacia()) {
            fin = new Nodo(dato);
            actual = fin;
            inicio = fin;
        } else {
            Nodo nuevo = new Nodo(dato, fin, null);
            fin.setNext(nuevo);
            fin = nuevo;
            actual = fin;
        }
        largo++;
    }

    //Metodo para eliminar el ultimo dato de la lista
    public int extraerFinal() {
        int aux = fin.getValue();
        fin = fin.getPrevious();
        if (fin != null) {
            fin.setNext(null);
        } else {
            inicio = null;
        }
        return aux;
    }

    
    //Metodo para eliminar un valor especifico FALTA!!!
    
    public void mostrar() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print("<=>" + "[" + temp.getValue() + "]" + "<=>");
            temp = temp.getNext();
        }
        System.out.println("");
    }
    
    public String mostrarIteracion() {
        String resultado = "";
        Nodo temp = inicio;
        while (temp != null) {
            resultado += "<=>" + "[" + temp.getValue() + "]" + "<=>";
            temp = temp.getNext();
        }
        resultado += "\n" + "\n";
        return resultado;
    }
    
    /*
    public void mostrar(ListaDoble lista) {
        if(lista.getInicio() != null) {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print("<=>" + "[" + temp.getValue() + "]" + "<=>");
            temp = temp.getNext();
        }
        System.out.println("");
        
        } else {
            System.out.println("La lista se encuentra vacia!");
        }
    }*/

    //Mostrar invertido
    public void mostrarRegreso() {
        Nodo temp = fin;
        while (temp != null) {
            System.out.print("<=>" + "[" + temp.getValue() + "]" + "<=>");
            temp = temp.getPrevious();
        }
        System.out.println("");
    }

    //Metodo clonacion de una lista
    public ListaDoble clonarLista(ListaDoble lista) {
        ListaDoble clonLista = new ListaDoble();
        Nodo temp = lista.getInicio();
        for(int i = 0; i < lista.getLargo(); i++) 
        {
            clonLista.insertar_alFinal(temp.getValue());
            temp = temp.getNext();
        }
        return clonLista;
    }
    
    //Metodo para transformar una listaDoble a Array
    public String[] clonarListaArray(ListaDoble lista) {
        
        String[] resultado = new String[lista.largo];
        Nodo temp = lista.getInicio();

        for(int i = 0; i < lista.getLargo(); i++) {
            String x = Integer.toString(temp.getValue());
            resultado[i] = x;
            temp = temp.getNext();
            System.out.print(resultado[i] + " ");
        }
        return resultado;
    }
    
    //Metodo para obtener el indice de un nodo
    public Nodo obtenerIndex(ListaDoble lista, int index) {
        lista.actual = lista.inicio;
        for(int i = 0; i < lista.getLargo(); i++) {
            if (i == index) {
                break;
            } 
            else {
                lista.actual = lista.actual.getNext();
            }
        }
        return lista.actual; 
    }
    
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getActual() {
        return actual;
    }

    public void setActual(Nodo actual) {
        this.actual = actual;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getLargo() {
        return largo;
    }
    
}
