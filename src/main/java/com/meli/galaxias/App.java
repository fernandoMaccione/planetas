package com.meli.galaxias;

import com.meli.galaxias.server.core.job.ServiceCalculation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ServiceCalculation task = ServiceCalculation.getInstance();
        task.getSolarSystem("kkk");
        
        
    }
}
