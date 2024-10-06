/*Programming Example in Java Rest Assured

Let's create a simple API automation example using Rest Assured in Java. This example will
demonstrate how to automate a GET request to verify the response status code and a specific
field in the JSON response.*/


import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiAutomationPostExample {
    public static void main(String[] args) {
        // Base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Automated GET request to verify status code and a specific field in the response
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/posts/1")
                .then()
                .assertThat()
                .statusCode(200)    // Verify status code
                .body("userId", equalTo(1)) // Correcting 'userid' to 'userId'
                .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")) // Correcting the title to match actual response
                .extract()
                .response();

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());
    }
}



/*
//Why Do We Go for API Automation?

    API automation is crucial in modern software development for several reasons:
            1. Speed and Efficiency:
    o Rapid Feedback: API automation provides quick feedback to developers about
    the functionality of their code. Manual testing can be time-consuming, especially
    with complex APIs.
    o Continuous Integration/Continuous Deployment (CI/CD): Automated API tests
    can be integrated into the CI/CD pipeline, allowing tests to run automatically
    whenever code is pushed or deployed. This ensures that any issues are detected
    early in the development process.
    2. Consistency and Reliability:
    o Elimination of Human Error: Automated tests reduce the risk of human errors
    that can occur during manual testing.
    o Reusability: Once written, automated tests can be reused across different builds,
    saving time and ensuring consistent results.
            3. Coverage:
    o Broader Test Coverage: Automation allows for more extensive test coverage,
    including edge cases and negative scenarios that might be missed during manual
    testing.
    o Parallel Testing: API tests can be run in parallel, covering multiple scenarios
    simultaneously, which is not feasible with manual testing.
    4. Cost-Effectiveness:
    o Reduced Manual Effort: Once automated, tests can be executed multiple times
    at no additional cost, reducing the manual effort required to test the application.
    o Long-Term Savings: Though there is an initial investment in creating automated
    tests, the long-term savings in time and resources are significant.
            5. Scalability:
    o Handling Large Volume of Requests: Automated tests can simulate a large
    number of API requests, allowing for performance and load testing that is
    difficult to achieve manually.
    o Integration with Other Systems: APIs often interact with multiple systems.
    Automated tests can verify these interactions efficiently.
    Advantages of API Automation
    1. Faster Execution:
    o Automated tests execute much faster than manual testing. They can be run in
    minutes, whereas manual testing might take hours.
            2. Early Bug Detection:
    o Bugs can be detected early in the development cycle, reducing the cost and
    effort required to fix them later.
            3. Improved Test Coverage:
    o Automation allows for comprehensive testing, including edge cases, which
    improves the overall quality of the software.
    4. Efficiency in Regression Testing:
    o Automated tests are perfect for regression testing, ensuring that new code
    changes do not break existing functionality.
            5. Repeatability:
    o Automated tests can be executed multiple times with consistent results, ensuring
    the reliability of the application over time.
    Programming Example in Java Rest Assured
    Let's create a simple API automation example using Rest Assured in Java. This example will
    demonstrate how to automate a GET request to verify the response status code and a specific
    field in the JSON response.
    */

/*
Explanation:
        1. Base URI: The base URI (https://jsonplaceholder.typicode.com) is set for the API we are
        testing.
        2. GET Request: A GET request is made to the endpoint /posts/1.
        3. Assertions:
        o statusCode(200): Verifies that the response status code is 200.
        o body("userId", equalTo(1)): Verifies that the userId field in the response is 1.
        o body("title", equalTo("sunt aut facere repellat provident occaecati excepturi
        optio reprehenderit")): Verifies that the title field matches the expected value.
        4. Response Extraction: The response is extracted and printed to the console for
        verification.
                This example highlights the simplicity and power of API automation with Rest Assured, enabling
               rapid and reliable testing of APIs.*/
