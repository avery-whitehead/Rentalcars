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
        //Prints a list of the cars in the appropriate format
        for (int i = 0; i < vehicleList.size(); i++) {
            System.out.println((i + 1) + ". " + vehicleList.get(i).getName() + " - " + vehicleList.get(i).getPrice());
        }
    }
}
