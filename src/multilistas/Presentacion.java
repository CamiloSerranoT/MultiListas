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
public class Presentacion {

    static Scanner scan = new Scanner(System.in);

    public int menu(int opcion) {
        boolean comprobarMenu = false;

        do {
            System.out.println("\n\n\n\n ____________________");
            System.out.println("|                    |");
            System.out.println("|      MENU          |");
            System.out.println("| 1.Insertar vertice |");
            System.out.println("| 2.Insertar arista  |");
            System.out.println("| 3.Imprimir         |");
            System.out.println("| 4.Salir            |");
            System.out.println("|____________________|");

            System.out.println("\n  Digite la opcion: ");

            opcion = scan.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                comprobarMenu = true;
            } else {
                System.out.println("\n\n|==========================|");
                System.out.println("| Solo valores entre [1/4] |");
                System.out.println("|==========================|\n\n\n\n");
            }
        } while (comprobarMenu == false);

        return opcion;
    }

    public int opciones(int numero, int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("\n ___________________________");
                System.out.println("|                           |");
                System.out.println("| Digite valor del vertice: |");
                numero = scan.nextInt();
                System.out.println("|___________________________|");
                break;
            case 21:
                System.out.println("\n ________________________");
                System.out.println("|                        |");
                System.out.println("| Digite vertice origen: |");
                numero = scan.nextInt();
                System.out.println("|________________________|");
                break;
            case 22:
                System.out.println("\n _________________________");
                System.out.println("|                         |");
                System.out.println("| Digite vertice destino: |");
                numero = scan.nextInt();
                System.out.println("|_________________________|");
                break;
            case 3:
                System.out.println("\n ___________________________________________");
                System.out.println("|                                           |");
                System.out.println("| Digite desde que vertice, desea imprimir: |");
                numero = scan.nextInt();
                System.out.println("|___________________________________________|");
                break;
        }

        return numero;
    }
}
