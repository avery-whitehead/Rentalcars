import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\vehicles.json"));
        JsonParser jsonParser = new JsonParser();
        //JSON structure is <Search<Vehicle List>>
        JsonArray jsonArray = jsonParser.parse(bufferedReader).getAsJsonObject().getAsJsonObject("Search").getAsJsonArray("VehicleList");
        //JsonObject jsonObject = jsonParser.parse(bufferedReader).getAsJsonObject().getAsJsonObject("Search").getAsJsonObject("VehicleList");
        //JsonObject jsonObject = jsonParser.parse(bufferedReader).getAsJsonObject().getAsJsonObject("Search");
        //JsonObject jsonObject = new Gson().fromJson(jsonArray.get(0), JsonObject.class);
        //Creates an ArrayList of all the Vehicles in the JSON file
        /*for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = new Gson().fromJson(jsonArray.get(i), JsonObject.class);
            Vehicle vehicle = new Vehicle(
                    jsonObject.get("sipp").getAsString(),
                    jsonObject.get("name").getAsString(),
                    jsonObject.get("price").getAsFloat(),
                    jsonObject.get("supplier").getAsString(),
                    jsonObject.get("rating").getAsFloat());
            vehicles.add(vehicle);
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getSipp());
            System.out.println(vehicle.getName());
            System.out.println(vehicle.getPrice());
            System.out.println(vehicle.getSupplier());
            System.out.println(vehicle.getRating());
        }*/
        Type listType = new TypeToken<List<Vehicle>>(){}.getType();
        List<Vehicle> vehicleList = gson.fromJson(jsonArray, listType);
        vehicleList.get(8).printPrice();
        //Vehicle vehicle = gson.fromJson(jsonArray, Vehicle.class);
        //System.out.println(vehicle);
    }
}
