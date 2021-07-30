
package prograiii_proyectoi;


import java.util.Arrays;

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
            int indiceArreglo= Integer.parseInt(elemento)%24;
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
        
        int indiceArreglo = Integer.parseInt(elemento)%24;
        int contador = 0;
        while (arreglo[indiceArreglo] != "-1"){
            if(arreglo[indiceArreglo]==elemento){
                System.out.println("elemento encontrado");
                return arreglo [indiceArreglo];
            } indiceArreglo ++;
            indiceArreglo &= tamanio;
            contador++;
            if(contador > 24){
                break;
            }
        }
        return null;

    }
    public  void busquedaHash(String bus, ListaDoble lista) {
       
        Busquedasearch hash = new Busquedasearch(lista.getLargo());
        String [ ] elementos= new String[lista.getLargo()];
        elementos= lista.clonarListaArray(lista);
        hash.funcionHash(elementos, hash.arreglo);

        String buscado = hash.buscarClave(bus);
        if(buscado == null){
            System.out.println("no encontrado");
        }
    }
}

    

