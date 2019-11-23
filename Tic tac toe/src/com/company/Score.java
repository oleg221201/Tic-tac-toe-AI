package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Score {

    private static File file = new File("score.txt");

    public static void Champion(int player, int ai, int draw) {
        if (player > ai){
            System.out.println("Player champion");
            return;
        }
        if (ai>player){
            System.out.println("AI champion");
            return;
        }
        else System.out.println("No champion");
    }

    public static void Write(String player, String ai, String draw) throws Exception {
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("player: ");
        fileWriter.write(player);
        fileWriter.write("\nai: ");
        fileWriter.write(ai);
        fileWriter.write("\na draw: ");
        fileWriter.write(draw);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void Score() throws Exception {

        if(file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }
        else System.out.println("Empty file");
    }
}
