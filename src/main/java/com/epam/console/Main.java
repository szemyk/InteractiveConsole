package com.epam.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for interactive console application
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean loopBool = true;
    static String parameter = "$";

    public static void main(String[] args){
        List<Command> activeCommand = new ArrayList<Command>();
        activeCommand.add(new Prompt());
        activeCommand.add(new Exit());
        activeCommand.add(new Unknown());
        activeCommand.add(new Dir());
        activeCommand.add(new Tree());
        activeCommand.add(new Cd());

        while(loopBool){
            System.out.print("[MyShell] " + parameter + ">");
            String userCommand = getUserString();

            for (Command command : activeCommand) {
                if (command.matches(userCommand)) {
                    command.executeCommand();
                    loopBool = command.endLoop();
                    break; //handle the first matching command only
                }
            }
        }

    }

    private static String getUserString(){
        return scanner.nextLine();
    }
}
