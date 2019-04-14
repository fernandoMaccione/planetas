package com.meli.galaxias;

import com.meli.galaxias.server.core.job.TaskExecutor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        TaskExecutor task = new TaskExecutor();
        task.run();
    }
}
