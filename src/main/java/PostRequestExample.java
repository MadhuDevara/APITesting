
/*
   How do you perform a POST request with a JSON payload in Rest Assured?
   Answer: To send a POST request with a JSON payload, you use the body() method to include the
   JSON data. You can specify the payload directly as a string or by using a POJO (Plain Old Java
   Object) that is serialized to JSON.

   Example:
*/

import static io.restassured.RestAssured.given;

public class PostRequestExample {

    public static void main(String[] args){

        given()
                .header("Content-Type", "application/json")
                .body("{\"key\":\"value\"}")
                .when()
                .post("/endpoint")
                .then()
                .statusCode(201);

    }
}

/*
 This example sends a POST request with the JSON payload {"key": "value"} and expects a 201
 Created status code.
*/