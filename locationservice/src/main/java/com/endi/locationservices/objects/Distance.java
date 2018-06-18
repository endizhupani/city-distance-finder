package com.endi.locationservices.objects;

/**
 * Created by Endi Zhupani on 18/06/2018.
 */
public class Distance {
    private City from;
    private City to;
    private double distance;
    private UnitOfMeasurement u;

    public Distance(City from, City to, double distance, UnitOfMeasurement u) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.u = u;
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

    public UnitOfMeasurement getU() {
        return u;
    }
}
