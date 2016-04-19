package com.epam.console;

import java.io.File;

/**
 * Class for dir command.
 * User can display the content of current working directory using a ‘dir’ command.
 * Format of the display: type of the item (DIR|FILE) and name of the item.
 * Example:
 * DIR      classes
 * FILE     pom.xml
 */

class Dir implements Command{
    private String workingDir = System.getProperty("user.dir");
    private File[] files = new File(workingDir).listFiles();

    public boolean matches(String command) {
        return command.matches("dir");
    }

    public void executeCommand() {
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            System.out.println("Content of " + workingDir);
            for(File f : files){
                if(f.isDirectory())
                    System.out.println("DIR \t\t"+f.getName());
                if(f.isFile()){
                    System.out.println("FILE \t\t"+f.getName());
                }
            }
        }
    }

    public boolean endLoop() {
        return true;
    }
}
