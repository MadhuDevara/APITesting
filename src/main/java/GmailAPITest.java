/*
    Validating the Dynamic Structure of a Gmail API Response :
    When dealing with a dynamic JSON response where the number of unread emails can vary, you
    can use JsonPath in RestAssured to extract and validate the relevant data dynamically.
    Example:
*/

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class GmailAPITest {
    public static void main(String[] args){

        // Sample API endpoint
        String response = RestAssured.given()

               .auth().oauth2("Your_access_Token")
                .get("GmailPath")
                .asString();

        // Extracting the count of unread emails using jsonPath

        JsonPath jsonPath= new JsonPath(response);
        int unreadEmailCount=jsonPath.getList("messages").size();

        //Validating that the number of unread emails is greater than 0

        Assert.assertTrue(unreadEmailCount>0,"Uread email count is 0");

        System.out.println("Number of unread emails: " + unreadEmailCount);

    }
}
