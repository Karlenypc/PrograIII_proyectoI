package prograiii_proyectoi;


import java.util.Arrays;
import javax.swing.JOptionPane;

public class Busquedasearch extends Busqueda{
    String [] arreglo;
    int tamanio, contador;
    

    public Busquedasearch (int tam){
    tamanio = tam;
    arreglo = new String [tam];
    Arrays.fill(arreglo,"-1");
    }
    public void funcionHash(String [] cadenaArreglo, String [] arreglo){
        int i;
        for (i=0;i< cadenaArreglo.length;i++){
            String elemento =cadenaArreglo[i];
            int indiceArreglo= Integer.parseInt(elemento)%25;
            System.out.println("el indice es " + indiceArreglo + "para el elemento " + elemento);

            // tratando las colisiones
            while (arreglo[indiceArreglo] != "-1"){
                indiceArreglo++;
                System.out.println("ocurrio una colision en el indice" + (indiceArreglo-1) + "Cambiar al indice " + indiceArreglo);
                indiceArreglo%=tamanio;
            }
            arreglo[indiceArreglo] = elemento;
        }

    }
    // metodo para buscar una clave

    public String buscarClave (String elemento){
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        
        int indiceArreglo = Integer.parseInt(elemento)%25;
        int contador = 0;
        while (arreglo[indiceArreglo] != "-1"){
            System.out.println(arreglo[indiceArreglo]);
            if(arreglo[indiceArreglo].equals(elemento)){
                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                System.out.println("elemento encontrado");
                JOptionPane.showMessageDialog(null, "Elemento encontrado en la clave " + arreglo[indiceArreglo] + "\n" +" En el tiempo de "+tiempo);
                return arreglo [indiceArreglo];
            } indiceArreglo ++;
            indiceArreglo &= tamanio;
            contador++;
            if(contador > 25){
                break;
            }
        }
        return null;

    }
    
    public void mostrar() {
        
        int incremento = 0, j, i;
        for(i = 0; i < 1; i++) {
            incremento =+ 25;
            for(j = 0; j < 500; j++) {
                System.out.print("-");
            }
            System.out.println();
            for(j = incremento - 25; j < incremento; j++) {
                System.out.format("| %3s " + " ", j);
            }
            System.out.println("|");
            for(int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
            for(j = incremento - 25; j < incremento; j++) {
                if(arreglo[j].equals("-1")) {
                    System.out.print("|   ");
                } else {
                    System.out.print(String.format("| %3s " + " ", arreglo[j]));
                }
            }
            System.out.println("|");
            for(j = 0; j < 500; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    
    public  void busquedaHash(String bus, ListaDoble lista) {
       
        Busquedasearch hash = new Busquedasearch(lista.getLargo());
        String [ ] elementos= new String[lista.getLargo()];
        elementos= lista.clonarListaArray(lista);
        hash.funcionHash(elementos, hash.arreglo);
        hash.mostrar();
        String buscado = hash.buscarClave(bus);
        if(buscado == null){
            System.out.println("no encontrado");
        }
    }
}

    

