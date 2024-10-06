
/*
    How can you reuse specifications and expectations in Rest Assured?
    Answer: You can reuse request and response specifications by creating them separately and
    applying them to multiple requests or responses.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.expect;

public class ReuseSpecExample {
    public static void main(String[] args) {

        // Create a request specification
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com/")
                .addHeader("Content-Type", "application/json")
                .build();

        // Create a response specification
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();

        // Use the specifications in multiple requests
        given()
                .spec(requestSpec)
                .when()
                .get("posts") // Use actual endpoint, e.g., /posts
                .then()
                .spec(responseSpec);

        given()
                .spec(requestSpec)
                .when()
                .get("comments") // Use actual endpoint, e.g., /comments
                .then()
                .spec(responseSpec);
    }
}





















/*
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.expect;
import static io.restassured.path.xml.XmlPath.given;

public class ReuseSpecExample {
    public static void main(String[] args){

        ResponseSpecification responseSpec=given()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-Type","application/json");

        ResponseSpecification responseSpec = expect()
                .statusCode(200)
                .contentType("application/json");

        given()
                .spec(requestSpec)
                .when()
                .get("/endpoint1")
                .then()
                .spec(responseSpec);

        given()
                .spec(requestSpec)
                .when()
                .get("/endpoint2")
                .then()
                .spec(responceSpec);

    }
}
*/
