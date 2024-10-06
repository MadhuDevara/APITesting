/*. What is the "RootPath" feature in Rest Assured?
    Answer: The RootPath feature allows you to define a common path for JSON extraction, making
    it easier to retrieve values from deeply nested structure
*/

import io.restassured.path.json.JsonPath;
import java.util.List;

public class RootPathExample {
    public static void main(String[] args) {
        // The JSON string
        String json = "{ \"store\": { \"book\": [ { \"author\": \"John\" }, { \"author\": \"Doe\" } ] } }";

        // Parse the JSON string
        JsonPath jsonPath = new JsonPath(json);

        // Set the root path to "store.book" and extract the authors
        List<String> authors = jsonPath.getList("store.book.author");

        // Print the authors
        System.out.println("Authors: " + authors);
    }
}











/*
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.*;

public class RootPathExample {
    public static void main(String[] args){
        String json= "{ \"store\": { \"book\": [ { \"author\": \"John\" }, { \"author\": \"Doe\" } ] } }";
        with(json).rootPath("store.book");

        List<String> authors=getList("author");
        System.out.println("Authors: "+ authors);

    }
}*/
