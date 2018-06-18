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
import java.util.List;

/**
 * Class that will be used to communicate with the user
 */
public class Ui {
    private List<City> fromCities;
    private List<City> toCities;
    private UnitOfMeasurement unit;
    private List<Distance> distances;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private ILocationServiceProvider locationServiceProvider;

    public Ui(ApiAccess apiAccessData) {
        this.locationServiceProvider = new GoogleLocationServiceProvider(apiAccessData);
    }

    public void execute() throws IOException{
        this.readInput();
    }

    /**
     * Reads the input from the user
     */
    private void readInput() throws IOException{
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
            this.retrieveCities(city1, country1);
        } catch (CityDistanceException e) {

        }

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
    }

    /**
     * Retrieves the cities that match the search criteria.
     */
    private void retrieveCities(String city, String country) throws CityDistanceException{

    }

    /**
     * Prints an error in the console
     * @param e The error to be printed
     */
    private void printError(CityDistanceException e) {

    }

    /**
     * Prints the distances into console
     * @param distances
     */
    private void printDistances(List<Distance> distances) {

    }

    /**
     * Calculates the list of distances;
     */
    private void calculateDistances(){

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
