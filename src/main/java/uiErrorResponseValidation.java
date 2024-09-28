import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class APIT1 {

    public static class UIErrorResponseValidation {
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