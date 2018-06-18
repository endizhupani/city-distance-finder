package com.endi.locationservices.objects;

import com.endi.locationservices.concrete.Helpers;

/**
 * Class representing a distance object
 */
public class Distance {
    private City from;
    private City to;
    private double distance;
    private UnitOfMeasurement unitOfMeasurement;

    public Distance(City from, City to, double distance, UnitOfMeasurement unitOfMeasurement) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Override
    public String toString() {
        return "Distance " +
                "from '" + from.getName() + ", " + from.getCountryName() +
                "' to '" + to.getName() + ", " + to.getCountryName() +
                "' is: " + (double) Math.round(distance * 100) / 100 + " " + Helpers.getUnitText(getUnitOfMeasurement());
    }
}
