package com.vaixells.battleship.init;

public class Init {

    public static void initMapa(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = '-';
            }
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

}
