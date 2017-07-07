import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\vehicles.json"));
        JsonParser jsonParser = new JsonParser();
        //Creates a JSON array out of the JSON file
        JsonArray jsonArray = jsonParser.parse(bufferedReader).getAsJsonObject().getAsJsonObject("Search").getAsJsonArray("VehicleList");
        Type listType = new TypeToken<List<Vehicle>>(){}.getType();
        //Converts the JSON array to a list of Vehicle objects
        List<Vehicle> vehicleList = gson.fromJson(jsonArray, listType);
        //Sorts the Vehicle list in ascending order by price
        Collections.sort(vehicleList, (v1, v2) -> Float.compare(v1.getPrice(), v2.getPrice()));
        //Prints a list of the car prices in the appropriate format
        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println((i + 1) + ". " + vehicleList.get(i).getName() + " - " + vehicleList.get(i).getPrice());
        }
        System.out.print("\n");
        //Calculates and sets the SIPP specifications
        for (int i = 0; i < vehicleList.size(); i++) {
        vehicleList.get(i).setCarType(vehicleList.get(i).calculateCarType());
        vehicleList.get(i).setDoors(vehicleList.get(i).calculateDoors());
        vehicleList.get(i).setTransmission(vehicleList.get(i).calculateTransmission());
        vehicleList.get(i).setFuel(vehicleList.get(i).calculateFuel());
        vehicleList.get(i).setAirCon(vehicleList.get(i).calculateAirCon());
        //Prints out the SIPP specifications in the appropriate format
        System.out.println((i + 1) + ". " + vehicleList.get(i).getName() + " - " + vehicleList.get(i).getSipp() +
                " - " + vehicleList.get(i).getCarType() + " - " + vehicleList.get(i).getDoors() + " - " +
                vehicleList.get(i).getTransmission() + " - " + vehicleList.get(i).getFuel() + " - " +
                vehicleList.get(i).getAirCon());
        }
        System.out.print("\n");
        //Sorts the Vehicle list in descending order by rating
        Collections.sort(vehicleList, (v1, v2) -> Float.compare(v2.getRating(), v1.getRating()));
        //Prints a list of the car ratings in the appropriate format
        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println((i + 1) + ". " + vehicleList.get(i).getName() + " - " + vehicleList.get(i).getCarType() +
                " - " + vehicleList.get(i).getSupplier() + " - " + vehicleList.get(i).getRating());
        }
    }
}
