package com.epam.console;

interface Command {
    boolean matches(String command);
    void executeCommand();
    boolean endLoop();
}
