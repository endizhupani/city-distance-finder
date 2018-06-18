package com.endi.locationservices.objects;

/**
 * Location object with various details about a specific location on the planet
 */
public class Location {
    private double latitude;
    private double longitude;

    /**
     * Gets the latitude of this location
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of this location
     * @param latitude the latitude to set.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets the longitude of this location
     * @return The longitude.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of this location
     * @param longitude The longitude to set.
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Creates a new instance of the {@link Location} object.
     * @param latitude The latitude associated with the location.
     * @param longitude The longitude associated with the location.
     */
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(Coordinate latitudeCoord, Coordinate longitudeCoord) {
        this.latitude = latitudeCoord.getDegrees() + (double)latitudeCoord.getMinutes() / 60 + (double)latitudeCoord.getSeconds() / 3600;
        this.longitude = longitudeCoord.getDegrees() + (double)longitudeCoord.getMinutes() / 60 + (double)longitudeCoord.getSeconds() / 3600;
    }

    public double findDistance(Location location, UnitOfMeasurement unit) {
        double R = 6371e3; // metres
        double phi1 = Math.toRadians(this.getLatitude());
        double phi2 = Math.toRadians(location.getLatitude());
        double deltaphi = Math.toRadians((location.getLatitude() - this.latitude));
        double deltaLambda = Math.toRadians((location.longitude-this.longitude));
        double a = Math.sin(deltaphi / 2) * Math.sin(deltaphi/2) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(deltaLambda / 2) * Math.sin(deltaLambda / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        switch (unit)
        {
            case CENTIMETERS:
                return R * c * 100;
            case METERS:
                return R * c;
            case KILOMETERS:
                return (R * c) / 1000;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (Double.compare(location.getLatitude(), getLatitude()) != 0) return false;
        return Double.compare(location.getLongitude(), getLongitude()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getLatitude());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
