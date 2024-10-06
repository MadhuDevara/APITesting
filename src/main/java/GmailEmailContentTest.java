/*
    Validating the Content of an Email Message
    You can use JsonPath to extract specific parts of the email, such as the body, and validate its
    content.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class GmailEmailContentTest {
    public static void main(String[] args){

        String accessToken = "YOUR_ACCESS_TOKEN";

        String response = RestAssured.given()
                .auth().oauth2(accessToken)
                .get("https://gmail.googleapis.com/gmail/v1/users/me/messages/{messageId}")
                .asString();

        JsonPath jsonPath = new JsonPath(response);

        // Extracting the email body(assuming it's in plain text)
        String emailBody = jsonPath.getString("payload.body.data");

        //Decoding from Base64(if necessary)
        byte[] decodeBytes=java.util.Base64.getDecoder().decode(emailBody);
        String decodeBody = new String(decodeBytes);

        //Validating content

        Assert.assertTrue(decodeBody.contains("expected content"),"Email body content validation failed");

    }
}
