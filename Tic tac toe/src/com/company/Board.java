package com.company;

public class Board {

    public void clearn(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Main.arr[i][j] = 0;
            }
        }
    }

    public void draw() {

        int n =3;
        System.out.print(" ");
        for (int i = 0; i < n; i++) System.out.print( " " + (i));
        System.out.println();


        for (int j = 0; j < n; j++) {

            System.out.print(" ");
            for (int i = 0; i < n; i++) {
                System.out.print( "+-");
            }
            System.out.println("+ ");

            System.out.print(j);
            for (int i = 0; i < n; i++) {
                switch (Main.arr[i][j])
                {
                    case 1: System.out.print("|X");
                        break;
                    case 0: System.out.print("| ");
                        break;
                    case -1: System.out.print("|0");
                        break;
                }
            }
            System.out.println("|" + (j));
        }

        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("+-");
        }
        System.out.println("+ ");

        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i));
        }
        System.out.println();
        System.out.println("----------------------------------------");
    }
}
