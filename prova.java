import java.util.Scanner;

public class prova {
    static int[][] board = new int[10][10];
    static int[][] board2 = new int[10][10];

    static int[] ships = {5, 4, 3, 3, 2};

    public static void main(String[] args) {
        taulell(board);
        initBoard();
        placeShips();
        play();

    }

    public static void taulell(int [][]board) {
        System.out.println("  1  2  3  4  5  6  7  8  9  10");
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" |"+board[i][j]);
            }
            System.out.println(" |");
        }
    }

    public static void initBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0;
            }
        }
    }



    public static void placeShips() {
        for (int shipLength : ships) {
            boolean placed = false;
            while (!placed) {
                int x = (int) (Math.random() * 10);
                int y = (int) (Math.random() * 10);
                int direction = (int) (Math.random() * 2);
                if (direction == 0) {
                    if (x + shipLength < 10) {
                        placed = true;
                        for (int i = x; i < x + shipLength; i++) {
                            board[i][y] = 1;
                        }
                    }
                } else {
                    if (y + shipLength < 10) {
                        placed = true;
                        for (int i = y; i < y + shipLength; i++) {
                            board[x][i] = 1;
                        }
                    }
                }
            }
        }
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter x coordinate: ");
            int x = scanner.nextInt();
            System.out.println("Enter y coordinate: ");
            int y = scanner.nextInt();
            if (board[x][y] == 1) {
                System.out.println("Hit!");
                board[x][y] = 2;
                taulell(board);
            } else {
                System.out.println("Miss!");
            }
        }
    }
}
