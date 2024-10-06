/* Request Specifications allow you to define reusable settings (like base URL, headers,
   authentication) that apply to multiple requests.
   Example:
*/

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class RequestSpecExample {

    public static void main(String[] args){

        RequestSpecification requestSpec = given()
                .baseUri("https://reqres.in")
                .header("Content-Type", "application/json");

        given()
                .spec(requestSpec)
                .when()
                .get("/api/users")
                .then()
                .statusCode(200);
    }
}
