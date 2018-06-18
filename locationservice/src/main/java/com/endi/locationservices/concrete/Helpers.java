package com.endi.locationservices.concrete;

import com.endi.locationservices.objects.City;
import com.endi.locationservices.objects.Location;
import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Endi Zhupani on 18/06/2018.
 */
public class Helpers {
    public static List<City> MapToCityList(GeocodingResult[] result) {
        if (result == null || result.length == 0) {
            return null;
        }

        List<City> cities = new ArrayList<>();
        for(GeocodingResult r : result) {
            Location l = new Location(r.geometry.location.lat, r.geometry.location.lng);
            City c = new City();
            c.setLocation(l);
            for(AddressComponent a: r.addressComponents) {
                if(Arrays.asList(a.types).contains(AddressComponentType.LOCALITY)){
                    c.setName(a.longName);
                }

                if(Arrays.asList(a.types).contains(AddressComponentType.COUNTRY)){
                    c.setCountryName(a.longName);
                }
            }
            cities.add(c);
        }

        return cities;
    }
}
