// 1.How do you validate and differentiate UI error responses and API error responses ?
//      To validate and differentiate UI error responses and API error responses, you'll need to
//      understand the differences in how these responses are delivered and how they should be
//      handled in automation testing. Let's break it down:

//1.1 UI Error Responses:
//• Nature: UI error responses are presented directly on the user interface. They may
//      appear as pop-ups, error messages, or other visual elements like warnings or red
//      banners.
//• Validation: To validate these errors using automation tools like Selenium, you would
//      typically interact with the UI elements where the error messages are displayed.

//Example: Validating a UI Error Response in Selenium (Java)

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class uiErrorResponseValidation {

    public static class uierrorresponsevalidation {
        public static void main(String[] args) {
            // Initialize WebDriver
            ChromeDriver driver = new ChromeDriver();

            try {
                // Navigate to URL
                driver.get("https://www.saucedemo.com/");

                // Perform login operation
                driver.findElement(By.id("user-name")).sendKeys("Admin");
                driver.findElement(By.id("password")).sendKeys("Admin");
                driver.findElement(By.name("login-button")).click();

                // Validating the UI error message
                WebElement errorMessage = driver.findElement(By.className("error-message-container"));
                String actualErrorMessage = errorMessage.getText();
                String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

                // Debugging - Print out the actual error message
                System.out.println("Actual Error Message: " + actualErrorMessage);

                // Assert the error message matches the expected message
                Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the driver
                driver.quit();
            }
        }
    }
}