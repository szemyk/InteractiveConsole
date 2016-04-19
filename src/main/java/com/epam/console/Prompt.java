package com.epam.console;

/**
 * Class for prompt command.
 * User can customize the presented prompt using a ‘prompt’ command with a parameter.
 * Possible values of the parameter:
 * -‘$cwd’, will result in displaying a path to current working directory in the prompt
 * -‘reset’, will reset the prompt to default ($ sign)
 * - Any other string will display the parameter in the prompt
 */

class Prompt implements Command {
    private String command;

    public boolean matches(String command) {
        if (command.matches("prompt (.*)")){
            this.command = command;
            return true;
        }
        else return false;
    }

    public void executeCommand() {
        if(command.matches("prompt reset")){
            Main.parameter = "$";
        }
        else if (command.matches("prompt \\$cwd")){
            Main.parameter = System.getProperty("user.dir");
        }
        else {
            Main.parameter = command.substring(7);
        }
    }

    public boolean endLoop(){
        return true;
    }
}
