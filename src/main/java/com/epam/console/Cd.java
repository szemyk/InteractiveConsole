package com.epam.console;

/**
 * Class for cd command.
 * User can change the current working directory using a ‘cd’ command with a parameter:
 * - ‘..’, for parent directory
 * - Name of existing subdirectory
 */

class Cd implements Command {

    public boolean matches(String command) {
        return command.matches("cd");
    }

    public void executeCommand() {
        System.out.println("cd");
        //to do something with this command
    }

    public boolean endLoop() {
        return true;
    }
}
