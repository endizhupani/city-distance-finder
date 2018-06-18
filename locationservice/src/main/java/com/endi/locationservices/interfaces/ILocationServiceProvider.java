package com.endi.locationservices.interfaces;

import com.endi.locationservices.errors.CityDistanceException;
import com.endi.locationservices.objects.City;
import com.endi.locationservices.objects.Distance;
import com.endi.locationservices.objects.UnitOfMeasurement;

import java.util.List;

/**
 * Provides location services such as city search, distance calculation, etc.
 */
public interface ILocationServiceProvider {
    List<City> getCitiesMatching(String name, String countryName) throws CityDistanceException;
    Distance getDistance(City from, City to, UnitOfMeasurement unit);
    List<Distance> getDistance(City from, List<City> to, UnitOfMeasurement unit);
}
