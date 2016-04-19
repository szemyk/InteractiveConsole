package com.epam.console;

/**
 * Class for unknown command.
 * User can typying basic commands implemented in this application.
 * If user typing commands not implemented in this apllication,
 * then it will display ‘[command] : unknown command’ message.
 */

class Unknown implements Command {
    private String command;

    public boolean matches(String command) {
        if (!command.matches("prompt (.*)")
                && !command.matches("exit")
                && !command.matches("dir")
                && !command.matches("tree")){
            this.command = command;
            return true;
        }
        else return false;
    }

    public void executeCommand() {
        System.out.println(command + ": unknown command");
    }

    public boolean endLoop() {
        return true;
    }
}
