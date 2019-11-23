package com.company;


import java.util.Scanner;

public class Control {

    Scanner scanner = new Scanner(System.in);

    public int X_or_O(){
        char XO;
        System.out.println("Сhoose who you play( X or O ):");
        XO = scanner.next().charAt(0);
        if (XO == 'x' || XO == 'X') return 1;
        if (XO == 'o' || XO == 'O' || XO == '0') return -1;
        else {
            System.out.println("Invalid value.");
            return X_or_O();
        }
    }

    public boolean isEmptyCell() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Main.arr[i][j] == 0)
                    return true;
            }
        }
        return false;
    }

    public void isMovePossible() {

        if (Main.x >= 0 && Main.x <= 2 && Main.y >= 0 && Main.y <= 2) {
            if (Main.arr[Main.x][Main.y] != 0) {
                System.out.println("Move isn't possible. Try to choose another cell.");
                System.out.print("Enter num of colomn: ");
                Main.x = scanner.nextInt();
                System.out.print("Enter num of line: ");
                Main.y = scanner.nextInt();
                isMovePossible();
            }
        }

        else {
            System.out.println("Move isn't possible. Try to choose another cell.");
            System.out.print("Enter num of colomn: ");
            Main.x = scanner.nextInt();
            System.out.print("Enter num of line: ");
            Main.y = scanner.nextInt();
            isMovePossible();
        }
    }

    public boolean isGameWin() {    //x-colomn, y-string

        //---------colomn-------------
        if (Main.arr[0][0] == Main.arr[0][1] && Main.arr[0][1] == Main.arr[0][2] && Main.arr[0][0] != 0) {
            return true;
        }
        if (Main.arr[1][0] == Main.arr[1][1] && Main.arr[1][1] == Main.arr[1][2] && Main.arr[1][0] != 0) {
            return true;
        }
        if (Main.arr[2][0] == Main.arr[2][1] && Main.arr[2][1] == Main.arr[2][2] && Main.arr[2][0] != 0) {
            return true;
        }

        //----------line--------------

        if (Main.arr[0][0] == Main.arr[1][0] && Main.arr[1][0] == Main.arr[2][0] && Main.arr[0][0] != 0) {
            return true;
        }
        if (Main.arr[0][1] == Main.arr[1][1] && Main.arr[1][1] == Main.arr[2][1] && Main.arr[0][1] != 0) {
            return true;
        }
        if (Main.arr[0][2] == Main.arr[1][2] && Main.arr[1][2] == Main.arr[2][2] && Main.arr[0][2] != 0) {
            return true;
        }

        //-----------diagonal-----------

        if (Main.arr[0][0] == Main.arr[1][1] && Main.arr[1][1] == Main.arr[2][2] && Main.arr[0][0] != 0) {
            return true;
        }
        if (Main.arr[2][0] == Main.arr[1][1] && Main.arr[1][1] == Main.arr[0][2] && Main.arr[2][0] != 0) {
            return true;
        }

        return false;
    }

}
