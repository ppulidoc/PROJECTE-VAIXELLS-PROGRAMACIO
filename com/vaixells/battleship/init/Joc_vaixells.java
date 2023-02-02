package com.vaixells.battleship.init;
import com.vaixells.battleship.io.*;

import java.util.Scanner;
public class Joc_vaixells {
    public static Scanner t = new Scanner(System.in);

    public static void atacVaixell(char[][] array, int fila, int column) {
        System.out.println("On vols atacar: ");
    }

    public static void main(String[] args) {
        boolean guanya = true;
        boolean vaixellColocat = true;
        int cont = 1;
        int contGeneral = 1;
        char[][] mapaJug1 = new char[10][10];
        char[][] mapaJug2 = new char[10][10];
        int grandariaVaixell;
        char size = 'l';
        int filaUbicacio;
        int colUbicacio;
        System.out.println("*** COMENÇCEM EL JOC ***");
        System.out.println();
        Init.initMapa(mapaJug1);
        Init.initMapa(mapaJug2);
        Map.pintarMapa(mapaJug1);
        Map.pintarMapa(mapaJug2);

        while (guanya) {
            while (vaixellColocat) {
                if (cont % 2 != 0) {
                    do {
                        System.out.println("Jugador 1 indica la grandaria del vaixell  --> (ha de ser entre 2-4) ");
                        grandariaVaixell = t.nextInt();
                    } while (grandariaVaixell < 2 || grandariaVaixell > 4);

                    do {
                        System.out.println("Jugador indica si el vols vertical *v* o horitzontal *h* ");
                        size = t.next().charAt(0);
                    } while (size != 'v' && size != 'h');

                    System.out.println("Jugador 1 indica la fila on vols ficar el vaixell --> ");
                    filaUbicacio = t.nextInt();
                    System.out.println("Jugador 1 indica la columna on vols ficar el vaixell --> ");
                    colUbicacio = t.nextInt();
                    System.out.println(" * MAPA LLENADO JUG 1 * ");
                    Init.posicionamentVaixell(size, mapaJug1, filaUbicacio, colUbicacio, grandariaVaixell);
                    Map.pintarMapa(mapaJug1);
                    cont++;
                } else {

                    do {
                        System.out.println("Jugador 2 indica la grandaria del vaixell --> (ha de ser entre 2-4) ");
                        grandariaVaixell = t.nextInt();
                    } while (grandariaVaixell < 2 || grandariaVaixell > 4);

                    do {
                        System.out.println("Jugador 2 indica si el vols vertical *v* o horitzontal *h* ");
                        size = t.next().charAt(0);
                    } while (size != 'v' && size != 'h');

                    System.out.println("Jugador 2 indica la fila on vols ficar el vaixell --> ");
                    filaUbicacio = t.nextInt();
                    System.out.println("Jugador 2 indica la columna on vols ficar el vaixell --> ");
                    colUbicacio = t.nextInt();
                    Init.posicionamentVaixell(size, mapaJug2, filaUbicacio, colUbicacio, grandariaVaixell);
                    System.out.println(" * MAPA LLENADO JUG 2 * ");
                    Map.pintarMapa(mapaJug2);
                    vaixellColocat=false;
                    cont++;
                }
            }

        }
    }
}



