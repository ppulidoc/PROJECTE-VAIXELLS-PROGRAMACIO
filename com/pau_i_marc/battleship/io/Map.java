package com.pau_i_marc.battleship.io;

public class Map {
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
}
