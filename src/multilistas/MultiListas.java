/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multilistas;

import java.util.Scanner;

/**
 *
 * @author CAMILO
 */
public class MultiListas {

    static Scanner scan = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Presentacion presentar = new Presentacion();
        int opcion = 0;
        int valor = 0;
        int origen = 0;
        int destino = 0;
        
        do {
            opcion = presentar.menu(opcion);

            switch (opcion) {
                case 1:
                    valor = presentar.opciones(valor = 0, opcion);
                    grafo.insertarVertice(valor);
                    break;
                case 2:
                    origen = presentar.opciones(origen = 0, opcion = 21);
                    destino = presentar.opciones(destino = 0, opcion = 22);
                    grafo.insertarArista(origen, destino);
                    break;
                case 3:
                    valor = presentar.opciones(valor = 0, opcion);
                    grafo.imprimir(valor);
                    break;
            }

        } while (opcion != 4);
        
    }

}
