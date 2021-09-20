package com.project.HomeShop;

import java.io.IOException;

public interface Writter {

    /**
     * Start writting process
     */
    public void start();

    /**
     * Write on line
     * @param line
     */
    public void writeLine(String line);

    /**
     * Stop writting process
     */
    public void stop() throws IOException;
}
