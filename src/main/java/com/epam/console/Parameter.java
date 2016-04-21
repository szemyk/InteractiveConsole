package com.epam.console;

/**
 * Class for parameter using in commands
 */

class Parameter {
    private String parameter = "$";
    private String path = System.getProperty("user.dir");

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
