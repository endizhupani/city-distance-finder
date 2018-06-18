package com.endi.city.distance;

import com.endi.locationservices.factories.ApiAccessFactory;
import com.endi.locationservices.interfaces.ApiAccess;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApiAccess apiAccessData = ApiAccessFactory.getInstance("[LOCATION_API_KEY]");
        try {
            new Ui(apiAccessData).execute();
        } catch (IOException e) {
            System.out.println("Something went wrong. Exiting...");
        }
    }
}
