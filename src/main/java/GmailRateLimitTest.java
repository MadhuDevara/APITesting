
/*
    Testing the Rate Limits for Gmail API
    To test rate limits, you can simulate multiple requests in a loop and detect when the API starts
    returning a 429 Too Many Requests response.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GmailRateLimitTest {
    public static void main(String[] args){

        String accessToken = "Your_access_Token";
        int requestCount=0;

        while (true){
            Response response = RestAssured.given()
                    .auth().oauth2(accessToken)
                    .get("https://gmail.googleapis.com/gmail/v1/users/me/messages");

            requestCount++;

            if(response.getStatusCode()==429){
                System.out.println("Rate limit reached after" + requestCount + "request.");
                break;
            }
        }
    }
}
