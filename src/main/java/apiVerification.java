// Differentiating UI and API Error Responses:
//1. Location:
//      o UI Errors: Displayed on the web page and require interaction with UI elements.
//      o API Errors: Delivered via HTTP responses and contain structured data (status
//      codes, JSON/XML).
//2. Validation Approach:
//      o UI Errors: Use UI automation tools like Selenium to check for error messages or
//      visual cues.
//      o API Errors: Use API testing tools like RestAssured to validate the status code and
//      response body.
//3. Technical Information:
//      o UI Errors: Usually more user-friendly and less technical, designed for end-users.
//      o API Errors: Provide detailed technical information useful for debugging, such as
//      error codes and stack traces.

//Conclusion:
//While both UI and API errors need to be validated, the method differs significantly. UI errors
//require interaction with the UI elements, whereas API errors are validated through HTTP
//responses. Knowing how to handle and validate each type is crucial in automation testing to
//ensure comprehensive test coverage.

//2.How do you verify in testing whether it is a API error or UI error ?
//To verify whether an issue is due to an API error or a UI error during testing, you can follow a
//systematic approach. This involves isolating the problem to determine if the error originates
//from the backend (API) or from the frontend (UI). Here’s how you can do it:

// Checking the API Response Directly:

//Use API Testing Tools: Tools like Postman or RestAssured can be used to directly test the
//      API endpoints. By sending the same request that your UI would send, you can check if
//      the API itself is returning an error.

//Look for Status Codes: If the API returns a 4xx or 5xx status code, it’s likely an API issue.
//      For example, a 500 Internal Server Error would indicate a server-side issue, while a 400
//      Bad Request might indicate invalid input sent by the UI.

// Example: Testing the API Directly with RestAssured (Java)

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class apiVerification {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://www.saucedemo.com/";

        //Directly sending the request to the API

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{ \"username\": \"testUser\", \"password\": \"testPass\" }")
                .post("/login");


        //Check if the API is returning an error

        int statusCode = response.getStatusCode();
        if(statusCode == 400){
            System.out.println("API Error:"+response.getBody().asString());
        }else{
            System.out.println("API Success");
        }

    }

}
