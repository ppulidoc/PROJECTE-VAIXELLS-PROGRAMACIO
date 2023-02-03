package com.pau_i_marc.battleship.init;
import com.pau_i_marc.battleship.game.Atac;
import com.pau_i_marc.battleship.io.Map;
import com.pau_i_marc.battleship.io.*;

import java.util.Scanner;
public class Joc_vaixells {
    public static Scanner t = new Scanner(System.in);

    public static boolean comprovacion (char [][] intentos, int grandaria ) {
        int contador = 0;
        boolean valor = false;
        for (int i = 0; i < intentos.length; i++){
            for (int j = 0; j < intentos[i].length; j++){
                if (intentos[i][j] == 'o'){
                    contador++;
                    valor = false;
                }
                if (contador == grandaria) {
                    valor = true;
                }
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        boolean guanya = true;
        boolean vaixellColocat = true;
        boolean game_over = false;
        int cont = 1;
        int contGeneral = 1;
        char[][] mapaJug1 = new char[10][10];
        char[][] mapaJug2 = new char[10][10];
        char[][] mapaIntentosJug1 = new char[10][10];
        char[][] mapaIntentosJug2 = new char[10][10];
        int grandariaVaixell;
        int granJug1 = 0;
        int grandJug2 = 0;
        char size = 'l';
        int filaUbicacio;
        int colUbicacio;
        int atacFila = 0;
        int atacColumna;
        System.out.println("*** COMENÇCEM EL JOC ***");
        System.out.println();
        Init.initMapa(mapaJug1);
        Init.initMapa(mapaJug2);
        Init.initMapa(mapaIntentosJug1);
        Init.initMapa(mapaIntentosJug2);
        Map.pintarMapa(mapaJug1);
        Map.pintarMapa(mapaJug2);

        while (guanya) {
            while (vaixellColocat) {
                if (cont % 2 != 0) {
                    do {
                        System.out.println("Jugador 1 indica la grandaria del vaixell  --> (ha de ser entre 2-4) ");
                        grandariaVaixell = t.nextInt();
                        granJug1=grandariaVaixell;
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
                        grandJug2 = grandariaVaixell;
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
            while(!game_over){
                if (contGeneral % 2 != 0) {
                    do {
                        System.out.println("Jugador 1 a quina fila vols atacar? 1 - 10");
                        atacFila = t.nextInt();
                    } while (atacFila > 10 || atacFila < 1);
                    do {
                        System.out.println("Jugador 1 a quina columna vols atacat? 1 - 10");
                        atacColumna = t.nextInt();
                    }while(atacColumna > 10 && atacColumna < 1);
                    Atac.atacar(mapaJug2,mapaIntentosJug1,atacFila,atacColumna);
                    Map.pintarMapa(mapaIntentosJug1);
                    game_over = comprovacion(mapaIntentosJug1, grandJug2);
                    contGeneral++;

                }
                else {
                    do {
                        System.out.println("Jugador 2 a quina fila vols atacar? 1 - 10");
                        atacFila = t.nextInt();
                    } while (atacFila > 10 || atacFila < 0);

                    do {
                        System.out.println("Jugador 2 a quina columna vols atacat? 1 - 10");
                        atacColumna = t.nextInt();
                    }while(atacColumna > 10 && atacColumna < 0);

                    Atac.atacar(mapaJug1,mapaIntentosJug2,atacFila,atacColumna);
                    Map.pintarMapa(mapaIntentosJug2);
                    game_over = comprovacion(mapaIntentosJug2, granJug1);
                    contGeneral++;
                }
            }
            System.out.println("Ha guanyat el jugador");
            guanya = false;

        }
    }
}



