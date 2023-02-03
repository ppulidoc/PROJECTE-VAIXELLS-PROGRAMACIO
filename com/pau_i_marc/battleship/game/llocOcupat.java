package com.pau_i_marc.battleship.game;

public class llocOcupat {
    public static boolean ocupat (char [][] intentos, int fila, int columna) {
        boolean casella_ocupada = true;
        for (int i = 0; i < intentos.length; i++){
            for (int j = 0; j < intentos[i].length; j++){
                if (intentos[fila-1][columna-1] == 'o' || intentos[fila-1][columna-1] == 'w'){
                    casella_ocupada = false;
                }
            }
        }
        return casella_ocupada;
    }
}
