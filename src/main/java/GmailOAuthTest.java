/*

    Automating OAuth2 Authentication for Gmail APIs
    Automating OAuth2 authentication involves obtaining an access token and using it to authorize
    subsequent requests.
    Example:

*/


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GmailOAuthTest {

    public static void main(String[] args){

        // Obtain OAuth2 token (this part usually involves a few steps, here it's simplified)

        String accessToken="Your_access_token";

        //Use the token to authenticate API requests

        Response response = RestAssured.given()
                .auth().oauth2(accessToken)
                .get("https://gmail.googleapis.com/gmail/v1/users/me/messages");


        // Print response for verification
        System.out.println("Response: " + response.asString());

    }

}
