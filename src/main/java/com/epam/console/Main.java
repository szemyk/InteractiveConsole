package com.epam.console;

import java.util.Scanner;

/**
 * Main class for interactive console application
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String command;
        String prompt ="$";

        do {
            System.out.print("[MyShell] " + prompt + ">");
            command = getUserString();
            if (command.contains("prompt")){
                if (command.contains("reset")){
                    prompt = "$";
                }
                else if (command.contains("$cwd")){
                    prompt = System.getProperty("user.dir");
                }
                else {
                    prompt = command.substring(7);
                }

            }
            else if (command.contentEquals("exit")){
                System.out.println("Bye.");
                scanner.close();
            }
            else {
                System.out.print(command + " : unknown command \n");
            }

        }
        while (!command.contentEquals("exit"));
    }

    private static String getUserString(){
        return scanner.nextLine();
    }
}
