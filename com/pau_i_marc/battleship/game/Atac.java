package com.pau_i_marc.battleship.game;

public class Atac {
    public static void atacar (char[][]array, char [][] arrayIntentos ,int fila, int columna){
        if (array[fila-1][columna-1] == 'x'){
            arrayIntentos[fila-1][columna-1] = 'o';
        }
        else{
            arrayIntentos[fila-1][columna-1] = 'w';
        }
    }

}
