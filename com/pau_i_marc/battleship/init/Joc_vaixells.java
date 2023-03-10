package com.pau_i_marc.battleship.init;
import com.pau_i_marc.battleship.game.Alertas;
import com.pau_i_marc.battleship.game.Atac;
import com.pau_i_marc.battleship.game.Hundido;
import com.pau_i_marc.battleship.io.Map;
import com.pau_i_marc.battleship.game.llocOcupat;
import java.util.Scanner;

/*
*
* @author Pau Pulido & Marc Rubio
* Battleship Game
* */
public class Joc_vaixells {
    public static Scanner t = new Scanner(System.in);

    public static void main(String[] args) {
        boolean guanya = true;
        boolean vaixellColocat = true;
        boolean gameOver = false;
        boolean casellaOcupada = false;
        int cont = 1;
        int contGeneral = 1;
        char[][] mapaJug1 = new char[10][10];
        char[][] mapaJug2 = new char[10][10];
        char[][] mapaIntentsJug1 = new char[10][10];
        char[][] mapaIntentsJug2 = new char[10][10];
        int grandariaVaixell;
        int granJug1 = 0;
        int grandJug2 = 0;
        char direccio = 'l';
        int filaUbicacio;
        int colUbicacio;
        int atacFila = 0;
        int atacColumna;
        String ganador;
        String player="";
        System.out.println("    ***************************************************");
        System.out.println("    \uD83D\uDCA3 \uD83D\uDEA2 BATTLE SHIP LIMITED EDITION PLUS GOLD  \uD83D\uDCA3 \uD83D\uDEA2");
        System.out.println("    ***************************************************");
        System.out.println();
        Init.initMapa(mapaJug1);
        Init.initMapa(mapaJug2);
        Init.initMapa(mapaIntentsJug1);
        Init.initMapa(mapaIntentsJug2);
        Map.pintarMapa(mapaJug1);
        Map.pintarMapa(mapaJug2);


        while (guanya) {
            while (vaixellColocat) {
                if (cont % 2 != 0) {
                    player="Jugador 1 ";
                    do {
                        System.out.println(player+"Indica la grandaria del vaixell  --> (ha de ser entre 2-4) ");
                        grandariaVaixell = t.nextInt();
                        granJug1=grandariaVaixell;
                    } while (grandariaVaixell < 2 || grandariaVaixell > 4);

                    do {
                        System.out.println(player +"Indica si el vols vertical *v* o horitzontal *h* ");
                        direccio = t.next().charAt(0);
                    } while (direccio != 'v' && direccio != 'h');

                    System.out.println(player+" Indica la fila on vols ficar el vaixell --> ");
                    filaUbicacio = t.nextInt();
                    System.out.println(player +"Indica la columna on vols ficar el vaixell --> ");
                    colUbicacio = t.nextInt();
                    System.out.println(" * MAPA OMPLERT "+player+ " * ");
                    Init.posicionamentVaixell(direccio, mapaJug1, filaUbicacio, colUbicacio, grandariaVaixell);
                    Map.pintarMapa(mapaJug1);
                    cont++;
                } else {
                    player="Jugador 2 ";
                    do {
                        System.out.println(player+"Indica la grandaria del vaixell --> (ha de ser entre 2-4) ");
                        grandariaVaixell = t.nextInt();
                        grandJug2 = grandariaVaixell;
                    } while (grandariaVaixell < 2 || grandariaVaixell > 4);

                    do {
                        System.out.println(player+"Indica si el vols vertical *v* o horitzontal *h* ");
                        direccio = t.next().charAt(0);
                    } while (direccio != 'v' && direccio != 'h');

                    System.out.println(player+"Indica la fila on vols ficar el vaixell --> ");
                    filaUbicacio = t.nextInt();
                    System.out.println(player+"Indica la columna on vols ficar el vaixell --> ");
                    colUbicacio = t.nextInt();
                    Init.posicionamentVaixell(direccio, mapaJug2, filaUbicacio, colUbicacio, grandariaVaixell);
                    System.out.println(" * MAPA OMPLERT "+player+  " * ");
                    Map.pintarMapa(mapaJug2);
                    vaixellColocat=false;
                    cont++;
                }

            }
            while(!gameOver){
                if (contGeneral % 2 != 0) {
                    player="Jugador 1 ";
                    do {
                        do {
                            System.out.println(player+"A quina fila vols atacar? 1 - 10");
                            atacFila = t.nextInt();
                        } while (atacFila > 10 || atacFila < 1);

                        do {
                            System.out.println(player+"A quina columna vols atacat? 1 - 10");
                            atacColumna = t.nextInt();
                        }while(atacColumna > 10 && atacColumna < 1);
                        casellaOcupada =llocOcupat.ocupat(mapaIntentsJug1, atacFila, atacColumna);
                        if (casellaOcupada == false){
                            System.out.println(Alertas.WARNING_OCUPAT);
                        }
                    }while(!casellaOcupada);

                    Atac.atacar(mapaJug2,mapaIntentsJug1,atacFila,atacColumna);
                    Map.pintarMapa(mapaIntentsJug1);
                    gameOver = Hundido.comprovacion(mapaIntentsJug1, grandJug2);
                    contGeneral++;

                }
                else {
                    do {
                        player="Jugador 2 ";
                        do {
                            System.out.println(player+"a quina fila vols atacar? 1 - 10");
                            atacFila = t.nextInt();
                        } while (atacFila > 10 || atacFila < 0);
                        do {
                            System.out.println(player+"a quina columna vols atacat? 1 - 10");
                            atacColumna = t.nextInt();
                        }while(atacColumna > 10 && atacColumna < 0);

                        casellaOcupada = llocOcupat.ocupat(mapaIntentsJug2, atacFila, atacColumna);

                        if (casellaOcupada == false){
                            System.out.println(Alertas.WARNING_OCUPAT);
                        }

                    }while(!casellaOcupada);

                    Atac.atacar(mapaJug1,mapaIntentsJug2,atacFila,atacColumna);
                    Map.pintarMapa(mapaIntentsJug2);
                    gameOver = Hundido.comprovacion(mapaIntentsJug2, granJug1);
                    contGeneral++;
                }
            }
            if (contGeneral % 2 == 0) {
                ganador = "Jugador 2";
            }
            else {
                ganador = "Jugador 1";
            }
            System.out.println("Ha guanyat el "+ganador);
            guanya = false;

        }
    }
}



