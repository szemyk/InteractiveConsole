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

    public static void main(String[] args){
        Parameter parameter = Parameter.getInstance();
        List<Command> activeCommand = new ArrayList<Command>();
        activeCommand.add(new Prompt());
        activeCommand.add(new Dir());
        activeCommand.add(new Tree());
        activeCommand.add(new Cd());
        activeCommand.add(new Exit());
        //Unknown object have to be always last element of activeCommand list.
        activeCommand.add(new Unknown());

        while(loopBool){
            System.out.print("[MyShell] " + parameter.getParameter() + ">");
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
