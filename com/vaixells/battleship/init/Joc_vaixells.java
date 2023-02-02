package com.vaixells.battleship.init;

import java.util.Scanner;
public class Joc_vaixells {
    public static Scanner t = new Scanner(System.in);

    public static void initMapa(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
        }
    }


    public static void pintarMapa(char[][] array) {
        System.out.println("   1  2  3  4  5  6  7  8  9  10");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void posicionamentVaixell(char direccion, char[][] array, int fila, int column, int largo) {
        if (direccion == 'v') {
            for (int i = 0; i < largo; i++) {
                array[i + (fila - 1)][column - 1] = 'x';
            }
        }
        if (direccion == 'h') {
            for (int j = 0; j < largo; j++) {
                array[fila - 1][(column - 1) + j] = 'x';
            }
        }
    }

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

        while (guanya) {
            while (vaixellColocat) {
                if (cont % 2 != 0) {
                    System.out.println(" * MAPA VACIO JUG 1 * ");
                    pintarMapa(mapaJug1);
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
                    posicionamentVaixell(size, mapaJug1, filaUbicacio, colUbicacio, grandariaVaixell);
                    pintarMapa(mapaJug1);
                    cont++;
                } else {
                    System.out.println(" * MAPA VACIO JUG 2 * ");
                    pintarMapa(mapaJug2);
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
                    posicionamentVaixell(size, mapaJug2, filaUbicacio, colUbicacio, grandariaVaixell);
                    System.out.println(" * MAPA LLENADO JUG 2 * ");
                    pintarMapa(mapaJug2);
                    vaixellColocat=false;
                    cont++;
                }
            }

        }
    }
}



