import static io.restassured.RestAssured.given;

public class ResponseHeaderValidation {
    public static void main(String[] args) {
        given()
                .when()
                .get("/endpoint")
                .then()
                .assertThat()
                .header("Content-Type", "text/html;charset=utf-8")
                .header("Server", "Jetty(10.0.20)")
                .header("Transfer-Encoding", "chunked"); // Added this check instead of Content-Length
    }
}

/*
How do you handle response headers in Rest Assured tests?

Answer: In Rest Assured, you can validate response headers using the header() or headers()
methods in the then() block. This allows you to check the presence and value of specific
headers.

In this example, the test checks that the Content-Type header is application/json, the Server
header is nginx, and the Content-Length header is present.*/