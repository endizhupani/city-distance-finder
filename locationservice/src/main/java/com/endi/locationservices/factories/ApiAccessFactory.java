package com.endi.locationservices.factories;

import com.endi.locationservices.interfaces.ApiAccess;
import com.endi.locationservices.objects.GoogleApiAccessData;

/**
 * Created by Endi Zhupani on 18/06/2018.
 */
public class ApiAccessFactory {
    public static ApiAccess getInstance(String apiKey){
        return new GoogleApiAccessData(apiKey);
    }
}
