import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.client.config.RequestConfig;

import static io.restassured.RestAssured.given;

public class TimeoutExample {
    public static void main(String[] args) {

        RestAssuredConfig config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000)
                        .setParam("http.socket.timeout", 5000)
                        .setParam("http.connection-manager.timeout", 5000));

        given()
                .config(config)
                .when()
                .get("https://jsonplaceholder.typicode.com")
                .then()
                .statusCode(200);
    }
}




/* ORIGINAL CODE
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.params.CoreConnectionPNames;
import org.hamcrest.CoreMatchers;

import static io.restassured.RestAssured.given;

public class TimeoutExample {
    public static void main(String[] args){

        given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig())
                        .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT,5000)
                        .setParam(CoreConnectionPNames.so_TIMEOUT,5000)
                        .when()
                        .get("/endpoint")
                        .then()
                        .statusCode(200);

    }
}
*/
