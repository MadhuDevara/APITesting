//How to Validate Error Responses in API Testing?

//Validating error responses is crucial in API testing to ensure that the API behaves correctly under
//invalid or unexpected conditions. You should verify that the API returns appropriate HTTP status
//codes and error messages.

//Steps to Validate Error Responses:
//  • Send a request with invalid data or parameters.
//  • Assert the HTTP status code matches the expected error code (e.g., 400 Bad Request,
//      404 Not Found, etc.).
//  • Verify the error message content.
//      Programming Example: Here’s an example using RestAssured in Java to validate a 404 Not
//      Found error response:

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;

public class ErrorResponseValidation {
    public static void main(String[] args) {

        Response response = given()
                .baseUri("https://www.saucedemo.com/")
                .basePath("/invalidEndpoint")
                .when()
                .get();

        // Print the response content type
        System.out.println("Content-Type: " + response.getContentType());

        // Check the content type before parsing
        if (response.getContentType().contains("application/json")) {
            // Handle JSON response
            response.then()
                    .statusCode(404)
                    .body("error", equalTo("Not Found"));
        } else {
            // Handle unexpected content type (print the response body)
            System.out.println(response.asString());
            response.then()
                    .statusCode(404);
        }
    }
}
// In this example, we check that the status code is 404 and the response body contains the
//  expected error message.