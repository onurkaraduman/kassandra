package com.kassandra.job;

import java.io.IOException;

/**
 * @author Onur Karaduman
 * @since 16.07.17
 */
public interface Job {

    public void execute() throws IOException;

}
