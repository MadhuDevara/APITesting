/*
    How do you handle dynamic values in response validation?
    Answer: Dynamic values, such as timestamps, can be validated using matchesPattern() or by
    ignoring certain fields.
    Example:
*/


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.matchesPattern;

public class DynamicValueExample {

        public static void main(String[] args){

            given()
                    .when()
                    .get("/endpoint")
                    .then()
                    .body("timestamp", matchesPattern("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z"));

        }
}
