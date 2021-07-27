/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograiii_proyectoi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class ObtenerListaNumeros {
     ListaDoble lista = new ListaDoble();
    //Metodo generar lista de forma aleatoria
    public ListaDoble generarAleatorio(int rango) {
       
        // actualizar metodos con los rangos de 1 a 100, 100 a 1000, 1000 a 10000. 
        for (int i = 1; i <= 25; i++) {
            int numero = (int) (Math.random() * rango + 1);
            lista.insertar_alFinal(numero);
        }
        //lista.mostrar();
        return lista;
    }
    
    //Metodo generar a traves de archivo txt 
     public ListaDoble insetarFile(String ruta){
        int numeroEntero;
        File f = new File(ruta);
        try (Scanner entrada = new Scanner(f)){
            System.out.println( "numeros son :");
            while (entrada.hasNextInt()){
                numeroEntero = entrada.nextInt();
                lista.insertar_alFinal(numeroEntero);
                System.out.println(numeroEntero);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
        return lista;

    }
     
     //Metodo para crear un archivo txt
     
         public void crearTxt (){
        try {
            String ruta = "/ruta/filename.txt";
            String contenido = "Contenido de ejemplo";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     }

    
    

