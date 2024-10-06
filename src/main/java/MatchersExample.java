
// What is the purpose of the Matchers class in Rest Assured?
// Answer: The Matchers class, part of the org.hamcrest library, provides a wide range of matchers
// (assertions) that you can use to validate responses in Rest Assured. It includes methods like
// equalTo(), containsString(), hasSize(), and more, which help in writing expressive and readable
// validation logic.

//Example:

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MatchersExample {

    public static void main(String[] args){

        given()
                .when()
                .get("/endpoint")
                .then()
                .statusCode(200)
                .body("key",equalTo("value"))
                .body("data.size()", greaterThan(0))
                .body("message",containsString("Success"));

    }

}

/*
Here, the equalTo() matcher checks if the value of key is value, greaterThan(0) checks if the data
array has elements, and containsString("success") verifies that the message contains the word
"success."
*/
