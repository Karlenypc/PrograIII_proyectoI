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
                JOptionPane.showMessageDialog(null, "El numero buscado esta en la lista." + " \n" + "El tiempo de busqueda fue: " + tiempo + " milisegundos");
                System.out.println("Encontrado");
                break;
            } else {
                temp = temp.getNext();
                System.out.println("No encontrado");
            }
        }
    }

    //Busqueda Secuencial mostrar en jTextField
    public String busquedaSecuencialIteracion(ListaDoble lista, int bus) {
        String resultado = "";
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        Nodo temp = lista.getInicio();
        resultado += lista.mostrarIteracion();
        resultado += "Temp = " + temp.getValue() + "\n";
        for (int i = 0; i < lista.getLargo(); i++) {
            if (temp.getValue() == bus) {
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                //JOptionPane.showMessageDialog(null, "El numero buscado esta en la lista." + " \n" + "El tiempo de busqueda fue: " + tiempo + " milisegundos");
                System.out.println("Encontrado");
                break;
            } else {
                temp = temp.getNext();
                System.out.println("No encontrado");
            }
            if (temp != null) {
                resultado += "\n" + lista.mostrarIteracion();
                resultado += "Temp = " + temp.getValue() + "\n";
            }
        }
        if (temp != null) {
            if (temp.getValue() == bus) {
                resultado += "\n" + "Temp == Busqueda: " + bus + "    ENCONTRADO!";
                //Es necesario inicializar variables "long" descomentar esta linea para ver el error!!!! IMPORTANTE
                //resultado += "\nEl tiempo de busqueda fue: " + tiempo + " milisegundos");
            }
        } else {
            resultado += "\nEl numero " + bus + "  NO se encuentra en la lista.";
        }
        return resultado;
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
        if (cambios == false) {
            JOptionPane.showMessageDialog(null, "El numero buscado no se encuentra en la lista.");
        }
    }

    //  Metodo para obtener un string de la busqueda binaria 
    public String busquedaBinariaIteracion(ListaDoble lista, int bus) {
        String resultado = "";
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
            resultado += "Centro de la lista " + centro;
            if (centro <= 0) {
                break;
            }

            lista.actual = lista.obtenerIndex(lista, centro - 1);

            if (lista.actual.getValue() == bus) {
                System.out.println("el numero buscado esta en la posicion " + (centro - 1));
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                JOptionPane.showMessageDialog(null, "El numero buscado esta en la posicion " + (centro - 1) + "\n" + "El tiempo de busqueda fue: " + tiempo + " milisegundos");
                resultado += "\n"+ "El numero buscado esta en la posicion " + (centro - 1) + "\n" + "El tiempo de busqueda fue: " + tiempo + " milisegundos";
                cambios = true;
                break;
            } else if (bus < lista.actual.getValue()) {
                superior = centro - 1;
            } else {
                inferior = centro + 1;
            }
        }
        if (cambios == false) {
            JOptionPane.showMessageDialog(null, "El numero buscado no se encuentra en la lista.");
        }
        return resultado;
    }

    //Busqueda Interpolacion
    public void busquedaInterpolacion(ListaDoble lista, int busqueda) {
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        int inicio = 0;
        int fin = lista.getLargo() - 1;
        boolean buscas = false;
        int indice;

        if (lista.getInicio().getValue() > busqueda || busqueda > lista.getFin().getValue()) {
            System.out.println("El numero no se encuentra en la lista.");
            TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
            tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        }

        while (inicio <= fin && lista.getInicio().getValue() <= busqueda && busqueda <= lista.getFin().getValue()) {
            indice = (inicio + ((busqueda - lista.getInicio().getValue()) * (fin - inicio) / (lista.getFin().getValue() - lista.getInicio().getValue())));
            System.out.println(indice);

            lista.actual = lista.obtenerIndex(lista, indice);

            if (lista.actual.getValue() == busqueda) {
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                System.out.println("El numero buscado esta en la posicion " + indice);
                buscas = true;
                break;
            } else if (lista.actual.getValue() < busqueda) {
                inicio = indice + 1;
            } else {
                fin = indice - 1;
            }
        }
        if (buscas == false) {
            System.out.println("El numero no se encuentra en la lista.");
        }
    }

    //Busqueda Interpolacion mostrar en jTextField
    public String busquedaInterpolacionIteraccion(ListaDoble lista, int busqueda) {
        String resultado = "";
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        int inicio = 0;
        int fin = lista.getLargo() - 1;
        boolean buscas = false;
        int indice;

        resultado += lista.mostrarIteracion();

        if (lista.getInicio().getValue() > busqueda || busqueda > lista.getFin().getValue()) {
            System.out.println("El numero no se encuentra en la lista.");
        }

        while (inicio <= fin && lista.getInicio().getValue() <= busqueda && busqueda <= lista.getFin().getValue()) {
            indice = (inicio + ((busqueda - lista.getInicio().getValue()) * (fin - inicio) / (lista.getFin().getValue() - lista.getInicio().getValue())));
            System.out.println(indice);
            resultado += "Indice = " + indice + "\n";

            lista.actual = lista.obtenerIndex(lista, indice);

            if (lista.actual.getValue() == busqueda) {
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                System.out.println("El numero buscado esta en la posicion " + indice);
                resultado += "\n" + "\nENCONTRADO!\n" + "El numero buscado se encuentra en la posición: " + indice + "\nEl tiempo de busqueda fue: " + tiempo + "milisegundos";
                buscas = true;
                break;
            } else if (lista.actual.getValue() < busqueda) {
                inicio = indice + 1;
            } else {
                fin = indice - 1;
            }
            resultado += "\n" + lista.mostrarIteracion();
        }
        if (buscas == false) {
            System.out.println("El numero no se encuentra en la lista.");
            resultado += "\n" + "\nEl numero " + busqueda + " no se encuentra en la lista."; //+ "\nEl tiempo de busqueda fue: " + tiempo + "milisegundos"; 
        }
        return resultado;
    }

    public int getNumBuscado() {
        return numBuscado;
    }

    public void setNumBuscado(int numBuscado) {
        this.numBuscado = numBuscado;
    }

}
