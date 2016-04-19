package com.epam.console;

/**
 * Class for exit command.
 * User can terminate the application by using ‘exit’ command.
 */

class Exit implements Command{

    public boolean matches(String command) {
        return command.matches("exit");
    }

    public void executeCommand() {
        System.out.println("Bye.");
    }

    public boolean endLoop(){
        return false;
    }
}
