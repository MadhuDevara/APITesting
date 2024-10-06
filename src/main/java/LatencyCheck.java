// What is Latency in API Testing?
//  Latency refers to the time delay between the client sending a request and receiving a response
//  from the server. It is a crucial performance metric in API testing, indicating how responsive the

//API is.
//  • Latency is measured in milliseconds (ms).
//  • Lower latency is better as it means the API responds faster.

//Example to Measure Latency:
//You can measure the latency using RestAssured by extracting the response time:

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LatencyCheck {

    public static void main(String[] args) {

        Response response=null;
        response = given()
                .baseUri("https://www.saucedemo.com/")
                .when()
                .get("/endpoint");

        long LATENCY=response.getTime();
        System.out.println("Latency: " + LATENCY + "ms");

    }

}

// Explanation:
//• response.getTime(): This method returns the time taken (in milliseconds) for the entire
//round trip of the request and response.
//• Output: The program prints the latency to the console, helping you assess the
//performance of the API.
