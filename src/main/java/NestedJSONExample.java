/*
    How do you handle nested JSON structures in response validation?
    Answer: Nested JSON structures can be handled by specifying the full path to the desired value.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class NestedJSONExample {

    public static void main(String[] args) {

        // Set the base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";  // Public API for testing

        // Specify the endpoint (URI) for the API request
        String endpoint = "/posts";  // Endpoint to fetch posts

        // Send a GET request to the specified URI
        Response response = given()
                .when()
                .get(endpoint)  // Send GET request to the endpoint
                .then()
                .statusCode(200)  // Validate the status code is 200
                .log().all()  // Log the response details
                .extract()
                .response();

        // Parse the response body as JSON
        JsonPath jsonPath = response.jsonPath();

        // Navigate and retrieve data from the nested JSON response (e.g., title from first post)
        String title = jsonPath.getString("[0].title");

        // Assert that the title matches the expected value (just an example, you can change it)
        Assert.assertNotNull(title, "Title should not be null");

        // Additional validation using Rest-Assured's built-in matchers
        given()
                .when()
                .get(endpoint)  // Send GET request to the endpoint
                .then()
                .statusCode(200)  // Validate the status code is 200
                .body("[0].title", notNullValue());  // Validate the title of the first post is not null
    }
}


/*

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NestedJSONExample {

    public static void main(String[] args) {

        given()
                .when()
                .get("/endpoint")  // Ensure this is a valid endpoint in your API
                .then()
                // Proper case-sensitive path reference
                .body("store.book[0].author", equalTo("John"))
                .body("store.book[1].author", equalTo("Doe"));
    }
}
*/

