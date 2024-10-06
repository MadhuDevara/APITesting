/*
    What is the purpose of the relaxedHTTPSValidation() method in Rest Assured?
    Answer: The relaxedHTTPSValidation() method is used to disable SSL certificate validation,
    which can be useful for testing APIs in non-production environments where the certificate might
    not be valid.
    Example:
*/

import static io.restassured.RestAssured.given;

public class RelaxedHTTPSValidationExample {
    public static void main (String[] args){

        given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://self-signed.badssl.com/")
                .then()
                .statusCode(200);

    }
}


/*
    This example allows you to test an endpoint with a self-signed SSL certificate without validation
    errors.
*/

