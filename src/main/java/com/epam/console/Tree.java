package com.epam.console;

/**
 * Class for tree command.
 * User can display the directory structure of current working directory
 * and its subdirectories using a ‘tree’ command.
 */

class Tree implements Command{

    public boolean matches(String command) {
        return command.matches("tree");
    }

    public void executeCommand() {
        System.out.println("tree");
        //to do something with command tree
    }

    public boolean endLoop() {
        return true;
    }
}
