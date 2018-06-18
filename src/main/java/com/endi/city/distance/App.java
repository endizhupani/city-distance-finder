package com.endi.city.distance;

import com.endi.locationservices.factories.ApiAccessFactory;
import com.endi.locationservices.interfaces.ApiAccess;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApiAccess apiAccessData = ApiAccessFactory.getInstance("AIzaSyBjTvvmLUYc0YqMhdRwMWkT3vEAd0ep8T4");
        System.out.println( "Hello World!" );
    }
}
