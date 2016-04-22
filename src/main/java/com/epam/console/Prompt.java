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
        Parameter parameter = Parameter.getInstance();
        if(command.matches("prompt reset")){
            parameter.setParameter("$");
        }
        else if (command.matches("prompt \\$cwd")){
            parameter.setParameter(System.getProperty("user.dir"));
        }
        else {
            parameter.setParameter(command.substring(7));
        }
    }

    public boolean endLoop(){
        return true;
    }
}
