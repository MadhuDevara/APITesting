
/*
    Ensuring Test Resilience to API Changes
    To ensure that your tests are resilient to changes like new fields being added, you can use JSON
    Schema validation.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator; // Import JsonSchemaValidator
import java.io.File;

public class GmailSchemaValidationTest {
    public static void main(String[] args) {

        String accessToken = "YOUR_ACCESS_TOKEN";  // Ensure access token is dynamically managed

        RestAssured.given()
                .auth().oauth2(accessToken)
                .baseUri("https://gmail.googleapis.com/gmail/v1/") // Set the base URI
                .get("users/me/messages")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(new File("path/to/your/schema.json"))); // Provide correct schema file path
    }
}

/*
    In the schema file (schema.json), you can define the expected structure of the JSON response,
    allowing your tests to pass even if new fields are added to the response, as long as the existing
    structure remains intact.
*/
