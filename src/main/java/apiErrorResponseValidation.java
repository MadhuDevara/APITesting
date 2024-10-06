// 1.2 API Error Responses:

//• Nature: API error responses are typically delivered as HTTP status codes and JSON/XML
//      payloads. These errors are more structured and can provide specific error codes,
//      messages, and even suggestions for correction.
//• Validation: Validating API error responses is done by verifying the status code, error
//      message in the response body, and other relevant fields using tools like RestAssured.

//Example: Validating an API Error Response in RestAssured (Java)

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class apiErrorResponseValidation {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://www.saucedemo.com/";

        try {
            // Sending a request that triggers an error response
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body("{ \"username\": \"wrongUser\", \"password\": \"wrongPass\" }")
                    .post("/login");

            // Log the entire response for debugging
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            // Validate the status code and error message in the response
            response.then().statusCode(401)
                    .body("error", equalTo("Unauthorized"))
                    .body("message", equalTo("Invalid username or password."));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}