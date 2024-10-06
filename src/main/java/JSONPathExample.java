/* How do you extract data using JSONPath with Rest Assured?
   Answer: JSONPath is used to extract specific data from JSON responses. You can use the
   jsonPath() method to retrieve values from the response body.

   Example:
*/

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class JSONPathExample {

    public static void main(String[] args){

        Response response= given()
                .when()
                .get("/endpoint");

        String value=response.jsonPath().getString("key");
        System.out.println("Extractred Value: " + value);

    }

}
