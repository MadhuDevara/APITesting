import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseSpecExample {

    public static void main (String[] args){


        ResponseSpecification responseSpec = expect()
                .statusCode(200)
                .contentType("application/json");
        given()
                .when()
                .get("/endpoint")
                .then()
                .spec(responseSpec)
                .body("key",equalTo("value"));

    }
}
