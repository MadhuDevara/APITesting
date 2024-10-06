
// Explain the purpose of the auth().oauth2AuthorizationCodeFlow() method in Rest Assured

// Answer: The auth().oauth2AuthorizationCodeFlow() method in Rest Assured is used to handle
// OAuth 2.0 authentication using the authorization code flow. This method helps automate the
// process of obtaining an access token from an authorization server and using it to authenticate
// API requests.

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class OAuth2Example {
    public static void main(String[] args) {
        // Step 1: Obtain Authorization Code (manual step, not shown in code)

        // Assume we have the authorization code after the user has granted access
        String authorizationCode = "your_authorization_code_here";

        // Step 2: Exchange Authorization Code for Access Token
        String accessToken = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("grant_type", "authorization_code")
                .formParam("code", authorizationCode)
                .formParam("redirect_uri", "your_redirect_uri_here")
                .formParam("client_id", "your_client_id_here")
                .formParam("client_secret", "your_client_secret_here")
                .post("https://auth-server.com/token") // Replace with your token endpoint
                .jsonPath()
                .getString("access_token"); // Assuming the token is returned in the response as "access_token"

        // Step 3: Use the Access Token to access the secured endpoint
        RestAssured.given()
                .auth()
                .oauth2(accessToken) // Use the access token
                .when()
                .get("https://api.example.com/secured-endpoint") // Replace with your API endpoint
                .then()
                .statusCode(200); // Expecting a 200 OK response
    }
}



//import static io.restassured.RestAssured.given;
//
//public class OAuth2Example {
//    public static void main(String[] args) {
//
//      given()
//                .auth()
//                .oauth2AuthorizationCodeFlow("https://auth-server.com/authorize", // Authorization server URL
//                        "https://auth-server.com/token",    // Token endpoint
//                        "client_id",                        // Client ID
//                        "client_secret",                    // Client Secret
//                        "redirect_uri",                     // Redirect URI (set in client settings)
//                        "authorization_code")               // Authorization code (you receive after user authorization)
//                .when()
//                .get("/protected-resource")
//                .then()
//                .statusCode(200);// Corrected the method name
//    }
//}

/*
   In this example, the oauth2AuthorizationCodeFlow method is used to authenticate the request
   with an OAuth 2.0 secured endpoint.
*/



