
/*
How do you handle Unicode characters in Rest Assured?
Answer: Unicode characters can be handled directly in Rest Assured, as it supports UTF-8
encoding by default.
Example:
*/


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UnicodeExample {

    public static void main(String[] args){

        given()
                .when()
                .get("/endpoint")
                .then()
                .body("message",equalTo("こんにちは"));

    }

}
