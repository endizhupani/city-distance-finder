package com.endi.locationservices.objects;

import com.endi.locationservices.interfaces.ApiAccess;

/**
 * Created by Endi Zhupani on 30/04/2018.
 */
public class GoogleApiAccessData implements ApiAccess {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public GoogleApiAccessData(String apiKey) {
        this.apiKey = apiKey;
    }
}
