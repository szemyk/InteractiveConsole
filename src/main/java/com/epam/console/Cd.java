package com.epam.console;

import java.io.File;

/**
 * Class for cd command.
 * User can change the current working directory using a ‘cd’ command with a parameter:
 * - ‘..’, for parent directory
 * - Name of existing subdirectory
 */

class Cd implements Command {
    private String command;
    private Parameter parameter = Parameter.getInstance();

    public boolean matches(String command) {
        if (command.matches("cd (.*)")){
            this.command = command;
            return true;
        }
        else return false;
    }

    public void executeCommand() {
        if(command.matches("cd ..")){
            File directory = new File(parameter.getPath());
            if (directory.getParent() != null) {
                setDir(directory.getParent());
            }
            else System.out.println("This path does not have parent directory");
        }
        else {
            command = command.substring(3);
            File directory = new File(command).getAbsoluteFile();
            if(directory.exists()){
                setDir(directory.getAbsolutePath());
            }
            else System.out.println("This directory does not exists in this scope");
        }
    }

    public boolean endLoop() {
        return true;
    }

    private void setDir(String varDir){
        parameter.setParameter(varDir);
        System.setProperty("user.dir", varDir);
        parameter.setPath(System.getProperty("user.dir"));
    }

}
