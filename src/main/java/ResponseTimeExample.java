
/*
How can you extract response time information using Rest Assured?
Answer: Response time can be extracted using the time() method, which returns the time taken
for the request to complete.
Example:
*/

import static io.restassured.RestAssured.given;

public class ResponseTimeExample {

        public static void main(String[] args){

            String baseUri = "https://jsonplaceholder.typicode.com"; // Example base URI

            long responseTime=given()
                    .baseUri(baseUri) // set the base URI
                    .when()
                    .get("/posts") // use a valid endpoint
                    .time();

            System.out.println("Response Time: " + responseTime+ "ms");

        }
}
