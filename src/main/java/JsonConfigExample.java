/*
    What is the purpose of the config(JsonConfig.jsonConfig()) method in Rest Assured?

    Answer: The config(JsonConfig.jsonConfig()) method is used to configure how JSON data is
    handled during serialization and deserialization in Rest Assured. This is useful when you need to
    customize the way JSON data is processed, such as setting up a specific date format or
    controlling how null values are treated.

    Example:
*/

import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.config.JsonPathConfig;
import java.math.BigDecimal;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class JsonConfigExample {
    public static void main(String[] args) {
        // Configure JSON handling to return numbers as BigDecimal
        JsonConfig config = JsonConfig.jsonConfig()
                .numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL);

        try {
            // Set base URI to your API
            baseURI = "https://jsonplaceholder.typicode.com"; // Replace with actual API base URL

            String endpoint = "/posts/1"; // Replace with your actual endpoint

            given()
                    .config(RestAssuredConfig.config().jsonConfig(config)) // Use the JSON config
                    .when()
                    .get(endpoint) // Use the endpoint variable here
                    .then()
                    .statusCode(200) // Validate status code
                    .body("price", equalTo(new BigDecimal("19.99"))); // Validate the "price" field
        } catch (Exception e) {
            // Handle potential exceptions
            e.printStackTrace();
        }
    }
}

/*
    In this example, the JSON configuration ensures that numbers are returned as BigDecimal,
    allowing precise handling of monetary values.
*/

