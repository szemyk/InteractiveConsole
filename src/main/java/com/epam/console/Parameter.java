package com.epam.console;

/**
 * Class for parameter using in commands.
 * To create this class, was used Singleton pattern.
 * The Singleton pattern ensures that a class has only one instance
 * and provides a global point of access to that instance.
 */

class Parameter {
    private String parameter = "$";
    private String path = System.getProperty("user.dir");
    private static Parameter ourInstance = new Parameter();

    static Parameter getInstance() {
        return ourInstance;
    }

    private Parameter(){
    }

    String getParameter() {
        return parameter;
    }

    void setParameter(String parameter) {
        this.parameter = parameter;
    }

    String getPath(){
        return path;
    }

    void setPath(String parameter){
        this.path = parameter;
    }
}
