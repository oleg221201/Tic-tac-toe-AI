package com.company;

import java.util.Scanner;

public class Game {

    public static void game() throws Exception{
        int numEnemyMove,menu,player=0,AI=0,draw=0;
        char cont = '1';
        String playerSTR,AISTR,drawSTR;

        Scanner scanner = new Scanner(System.in);
        Control control = new Control();
        Board board = new Board();
        AI ai = new AI();

        while (cont=='1') {
            board.clearn();
            System.out.println("Choose number of menu:");
            System.out.println("1)Game;");
            System.out.println("2)Score");
            System.out.println("3)Champion");
            menu = scanner.nextInt();

            if (menu == 1) {

                numEnemyMove = control.X_or_O();

                if (numEnemyMove == 1) {
                    board.draw();
                    while (control.isEmptyCell()) {
                        System.out.print("enter colomn: ");
                        Main.x = scanner.nextInt();
                        System.out.print("enter line: ");
                        Main.y = scanner.nextInt();
                        control.isMovePossible();
                        Main.arr[Main.x][Main.y] = 1;
                        if (control.isGameWin()) {
                            board.draw();
                            System.out.println("You are winner");
                            player++;
                            break;
                        } else board.draw();
                        if (!control.isEmptyCell()) {
                            System.out.println("a draw");
                            draw++;
                            break;
                        }

                        //-------------ai

                        ai.AI_second(Main.x, Main.y);
                        if (control.isGameWin()) {
                            board.draw();
                            System.out.println("ai winner");
                            AI++;
                            break;
                        } else board.draw();
                    }
                }
                if (numEnemyMove == -1) {
                    while (control.isEmptyCell()) {
                        ai.AI_first();
                        if (control.isGameWin()) {
                            board.draw();
                            System.out.println("ai winner");
                            AI++;
                            break;
                        } else board.draw();
                        if (!control.isEmptyCell()) {
                            System.out.println("a draw");
                            draw++;
                            break;
                        }

                        //---------------human

                        System.out.print("enter colomn: ");
                        Main.x = scanner.nextInt();
                        System.out.print("enter line: ");
                        Main.y = scanner.nextInt();
                        control.isMovePossible();
                        Main.arr[Main.x][Main.y] = -1;
                        if (control.isGameWin()) {
                            board.draw();
                            System.out.println("You are winner");
                            player++;
                            break;
                        } else board.draw();
                    }
                }
            }

            if(menu==2){
                Score.Score();
            }

            if(menu==3){
                Score.Champion(player,AI,draw);
            }

            if(menu!=1 && menu!=2 && menu!=3){
                System.out.println("Invalid input;");
            }

            playerSTR=""+player;
            AISTR=""+AI;
            drawSTR=""+draw;
            Score.Write(playerSTR,AISTR,drawSTR);
            System.out.println("If you want to continue, press 1. If not, press any button.");
            cont=scanner.next().charAt(0);
        }
    }
}
