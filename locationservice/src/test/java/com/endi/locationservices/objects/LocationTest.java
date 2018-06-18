package com.endi.locationservices.objects;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Endi Zhupani on 18/06/2018.
 */
public class LocationTest {
    @Test
    public void findDistance() throws Exception {
        // Arrange
        Location loc1 = new Location(50.0663888889, 5.71472222222);
        Location loc2 = new Location(new Coordinate(58, 38, 38), new Coordinate(3,4,12));

        // Act
        double distance = loc1.findDistance(loc2, UnitOfMeasurement.METERS) / 1000;

        // Assert
        Assert.assertEquals(968.9, distance, 0.1);
    }

}