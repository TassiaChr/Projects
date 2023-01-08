package projects;

import java.util.Scanner;

public class TicTacToeApp {
    static char[][] arr = new char[3][3];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char player = 'X';

        do {
            display(arr);
            System.out.println("Player with symbol " + player + " please select a place in the table");
            int i = in.nextInt();
            int j = in.nextInt();

            if (arr[i][j] != '\0') {
                System.out.println("Please select another position to make your move");
                continue;
            }

            arr[i][j] = player;

            if(win(player, i, j)) {
                display(arr);
                System.out.println("Player with symbol " + player + " wins");
                break;
            }

            if (draw()) {
                display(arr);
                System.out.println("There is no winner. Game ends in a draw");
                break;
            }

            //changes the players order
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        } while (true);

    }

    //checks if the player wins
    public static boolean win(char move, int hor, int vert) {
        int countVer = 0;
        int countHor = 0;
        int countDiagonalA = 0;
        int countDiagonalB = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i][vert] == move) {
                countVer++;
            }
        }

        for (int j = 0; j < 3; j++) {
           if (arr[hor][j] == move) {
               countHor++;
           }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((arr[i][j] == move) && (i == j)){
                    countDiagonalA++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 2; j >= 0; j--) {
                if (arr[i][j] == move) {
                    if (((i == 1) && (j == 1))
                            || (Math.abs(i - j) == 2)) {
                        countDiagonalB++;
                    }
                }
            }
        }

        return (countVer == 3) || (countHor == 3)
                || (countDiagonalA == 3) || (countDiagonalB == 3);
    }

    //checks if it is a draw
    public static boolean draw(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    //displays the tic-tac-toe board graphically
    public static void display(char[][] arr) {
        System.out.println("-+-+-");
        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i][0] + "|" + arr[i][1] + "|" + arr[i][2]);

            System.out.println();
            System.out.println("-+-+-");
        }
    }
}
