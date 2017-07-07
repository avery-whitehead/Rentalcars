import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\vehicles.json"));
        JsonParser jsonParser = new JsonParser();
        //JSON structure is <Search<Vehicle List>>
        JsonArray jsonArray = jsonParser.parse(bufferedReader).getAsJsonObject().getAsJsonObject("Search").getAsJsonArray("VehicleList");
        System.out.println(jsonArray.get(0));
    }
}
