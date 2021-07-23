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
public class ObtenerListaNumeros {
    
    //Metodo generar lista de forma aleatoria
    public ListaDoble generarAleatorio(int rango) {
        ListaDoble lista = new ListaDoble();
        
        for (int i = 1; i <= 25; i++) {
            int numero = (int) (Math.random() * rango + 1);
            lista.insertar_alFinal(numero);
        }
        //lista.mostrar();
        return lista;
    }
    
    //Metodo generar a traves de archivo txt ?????!
    
    
}
