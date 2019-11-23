package com.company;


public class Main {

    public static int arr[][] = new int[3][3];
    public static int x,y;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = 0;
            }
        }

        Game.game();

    }
}
