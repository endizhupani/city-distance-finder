package com.endi.locationservices.objects;

/**
 * Object representing a city in the world
 */
public class City {
    private String name;
    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    private Location location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public City(String name, String countryName, Location location) {
        this.name = name;
        this.countryName = countryName;
        this.location = location;
    }

    public City() {
    }
}
