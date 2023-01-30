package com.vaixells.battleship.init;

import java.util.Scanner;
public class Joc_vaixells {
    public static Scanner t = new Scanner(System.in);

    public static void initMapa (char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length;j++){
                array[i][j] = '-';
            }
        }
    }


    public static void pintarMapa (char [][] array){
        System.out.println("   1   2   3   4   5   6   7   8   9   10");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+1);
            for (int j = 0; j < array[i].length;j++){
                System.out.print(array[i][j] + " | ");
            }
            System.out.println(" ");
        }
    }
    public static void posicionamentVaixell (char direccion, char [][] array, int fila, int column, int largo){
        if (direccion == 'v'){
            for (int i = 0; i < largo ;i++){
                array[i+fila][column] = 'x';
            }
        }
    }

    public static void main(String[] args) {
        char [][] mapa = new char[10][10];
        int grandariaVaixell;
        char size = 'l';
        int filaUbicacio;
        int colUbicacio;
        System.out.println("*** COMENÇCEM EL JOC ***");
        initMapa(mapa);
        pintarMapa(mapa);
        do {
            System.out.println("Indica la grandaria del vaixell --> (ha de ser entre 2-4) ");
            grandariaVaixell = t.nextInt();
        }while (grandariaVaixell < 2 || grandariaVaixell > 4);

        do {
            System.out.println("Indica si el vols vertical *v* o horitzontal *h* ");
            size = t.next().charAt(0);
        }while (size != 'v' && size != 'h');

        System.out.println("Indica la fila on vols ficar el vaixell --> ");
        filaUbicacio = t.nextInt();
        System.out.println("Indica la columna on vols ficar el vaixell --> ");
        colUbicacio = t.nextInt();
        posicionamentVaixell(size, mapa, filaUbicacio, colUbicacio, grandariaVaixell);
        pintarMapa(mapa);



    }
}
