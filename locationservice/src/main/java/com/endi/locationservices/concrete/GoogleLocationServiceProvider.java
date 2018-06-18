package com.endi.locationservices.concrete;

import com.endi.locationservices.errors.CityDistanceException;
import com.endi.locationservices.interfaces.ApiAccess;
import com.endi.locationservices.interfaces.ILocationServiceProvider;
import com.endi.locationservices.objects.City;
import com.endi.locationservices.objects.Distance;
import com.endi.locationservices.objects.UnitOfMeasurement;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.model.ComponentFilter;
import com.google.maps.model.GeocodingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provider for the services of Google location API
 */
public class GoogleLocationServiceProvider implements ILocationServiceProvider {

    private ApiAccess apiAccess;
    private static GeoApiContext geoApiContext;

    public GoogleLocationServiceProvider(ApiAccess apiAccess) {
        this.apiAccess = apiAccess;
        if (geoApiContext == null) {
            //"AIzaSyBjTvvmLUYc0YqMhdRwMWkT3vEAd0ep8T4"
            geoApiContext = new GeoApiContext.Builder()
                    .apiKey(apiAccess.getApiKey())
                    .build();
        }
    }

    @Override
    public List<City> getCitiesMatching(String name, String countryName) throws CityDistanceException {
        String operation = "Getting cities matching:\nCity - " + name + "\nCountry - " +countryName;
        try {
            GeocodingApiRequest request = new GeocodingApiRequest(geoApiContext);
            ComponentFilter filterCity = new ComponentFilter("locality", name);
            ComponentFilter filterCountry = new ComponentFilter("country", countryName);
            request.components(filterCity, filterCountry);
            GeocodingResult[] result = request.await();
            return Helpers.MapToCityList(result);
        } catch (ApiException e) {

            if (e instanceof InvalidRequestException)
            {
                throw new CityDistanceException("Invalid request to the API", operation);
            }
            throw new CityDistanceException(e, operation);
        } catch (InterruptedException | IOException e) {
            throw new CityDistanceException(e, operation);
        }
    }

    @Override
    public Distance getDistance(City from, City to, UnitOfMeasurement unit) {
        if (from.equals(to))
        {
            return new Distance(from, to, 0, unit);
        }
        return new Distance(from, to, from.getLocation().findDistance(to.getLocation(), unit), unit);
    }

    @Override
    public List<Distance> getDistance(City from, List<City> to, UnitOfMeasurement unit) {
        List<Distance> distances = new ArrayList<>();

        for(City c : to){
            distances.add(getDistance(from, c, unit));
        }
        return distances;
    }


}
