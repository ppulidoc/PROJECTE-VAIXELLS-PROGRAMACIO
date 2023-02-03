package com.pau_i_marc.battleship.game;

public class Hundido {
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
}
