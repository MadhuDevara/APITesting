/*
    How do you perform query parameter validation in Rest Assured?
    Answer: Query parameters can be validated by specifying them in the request and then
    verifying their effect on the response.
    Example:
*/

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class QueryParamExample {

    public static void main(String[] args){

        given()
                .queryParam("name", "test")
                .when()
                .get("/endpoint")
                .then()
                .statusCode(200)
                .body("response",equalTo("expectedValue"));

    }

}
