package com.endi.city.distance;

import com.endi.locationservices.concrete.GoogleLocationServiceProvider;
import com.endi.locationservices.errors.CityDistanceException;
import com.endi.locationservices.interfaces.ApiAccess;
import com.endi.locationservices.interfaces.ILocationServiceProvider;
import com.endi.locationservices.objects.City;
import com.endi.locationservices.objects.Distance;
import com.endi.locationservices.objects.UnitOfMeasurement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that will be used to communicate with the user
 */
class Ui {
    private List<City> fromCities;
    private List<City> toCities;
    private UnitOfMeasurement unit;
    private List<Distance> distances;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ILocationServiceProvider locationServiceProvider;

    Ui(ApiAccess apiAccessData) {
        this.locationServiceProvider = new GoogleLocationServiceProvider(apiAccessData);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    void execute() throws IOException {
        while (!this.readInputCity1()) {
        }
        this.printCities(fromCities);
        while (!this.readInputCity2()) {
        }
        this.printCities(toCities);
        while (!this.readInputUnit()) {
        }

        this.calculateDistances();
        System.out.println("Distances:");
        printDistances(distances);
        if (this.promptFurtherInput()) {
            this.execute();
        }
    }

    /**
     * Reads the input for the first city from the user
     */
    private boolean readInputCity1() throws IOException {
        System.out.println("Please enter the name of the first city you want to search:");
        String city1 = "";
        while (city1.equals("")) {
            city1 = br.readLine();
        }

        System.out.println("Please enter the country in which the first city is located:");
        String country1 = "";
        while (country1.equals("")) {
            country1 = br.readLine();
        }

        try {
            System.out.println("Searching...");
            this.fromCities = this.locationServiceProvider.getCitiesMatching(city1, country1);
            if (this.fromCities == null || this.fromCities.size() == 0) {
                System.out.println("No cities where found for these search params. Please enter new search params:");
                return false;
            }
            return true;
        } catch (CityDistanceException e) {
            printError(e);
            return false;
        }
    }

    /**
     * Reads the input for the first city from the user
     */
    private boolean readInputCity2() throws IOException {
        System.out.println("Please enter the name of the second city you want to search:");
        String city2 = "";
        while (city2.equals("")) {
            city2 = br.readLine();
        }

        System.out.println("Please enter the country in which the second city is located:");
        String country2 = "";
        while (country2.equals("")) {
            country2 = br.readLine();
        }
        try {
            System.out.println("Searching...");
            this.toCities = this.locationServiceProvider.getCitiesMatching(city2, country2);
            if (this.toCities == null || this.toCities.size() == 0) {
                System.out.println("No cities where found for these search params. Please enter new search params:");
                return false;
            }
            return true;
        } catch (CityDistanceException e) {
            printError(e);
            return false;
        }
    }

    /**
     * Reads the input for the unit.
     *
     * @return True if input was read successfully, false otherwise
     * @throws IOException Exception in case something goes wrong with the input read
     */
    private boolean readInputUnit() throws IOException {
        System.out.println("Please enter the unit in which you want the distance displayed:");
        String unit = "";
        while (unit.equals("") || (!unit.equals("km") && !unit.equals("m") && !unit.equals("cm"))) {
            unit = br.readLine();
        }
        switch (unit) {
            case "m":
                this.unit = UnitOfMeasurement.METERS;
                break;
            case "cm":
                this.unit = UnitOfMeasurement.CENTIMETERS;
                break;
            default:
                this.unit = UnitOfMeasurement.KILOMETERS;
                break;
        }
        return true;
    }
    /**
     * Prints an error in the console
     * @param e The error to be printed
     */
    private void printError(CityDistanceException e) {
        System.out.println("Error!");
    }

    /**
     * Prints the cities in {@code cities}
     *
     * @param cities The cities to be printed.
     */
    private void printCities(List<City> cities) {
        if (cities == null || cities.size() == 0) {
            return;
        }

        System.out.println("Cities found:");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + 1 + ". " + cities.get(i).getName() + ", " + cities.get(i).getCountryName());
        }
    }

    /**
     * Prints the distances into console
     * @param distances Distances to be printed.
     */
    private void printDistances(List<Distance> distances) {
        if (distances == null || distances.size() == 0) {
            return;
        }

        System.out.println("Distances");
        for (int i = 0; i < distances.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, distances.get(i).toString()));
        }
    }

    /**
     * Calculates the list of distances;
     */
    private void calculateDistances() {
        distances = new ArrayList<>();
        for (City c :
                this.fromCities) {
            distances.addAll(locationServiceProvider.getDistance(c, toCities, this.unit));
        }
    }

    /**
     * Asks the user if they want to repeat the execution
     * @return True of answered yes, False otherwise
     */
    private boolean promptFurtherInput() throws IOException{
        String answer = "";
        while (answer.equals("")) {
            System.out.println("Would you like to run another search (Y/N):");
            answer = br.readLine();
            if (answer.toLowerCase().equals("y"))
            {
                return true;
            }
            else if (answer.toLowerCase().equals("n")){
                return false;
            }
            else {
                answer = "";
            }
        }
        return false;
    }
}
