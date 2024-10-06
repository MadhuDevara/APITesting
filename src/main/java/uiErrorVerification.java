//Simulate the UI Action and Capture API Calls:
//• Browser Developer Tools: Use the network tab in browser developer tools to monitor
//      the API calls that are made when interacting with the UI. If an API call fails (e.g., returns
//      a 4xx or 5xx status), the issue likely stems from the API.
//• Check for Errors in the Network Tab: If the network tab shows that the API call failed,
//      then the issue is on the backend side. If the API call succeeds but the UI behaves
//      incorrectly, the issue is likely on the frontend.

//Steps to Verify via Developer Tools:
//  1. Open your application in a browser (e.g., Chrome).
//  2. Press F12 to open Developer Tools and navigate to the Network tab.
//  3. Perform the action that triggers the error (e.g., submitting a form).
//  4. Look for any failed requests in the Network tab.
//      o If you see a failed request (e.g., HTTP status 500), it indicates an API error.
//      o If all requests succeed but the UI still displays an error, it's likely a UI issue.

//2.3 Analyze UI Behavior:
//• Look for UI-Specific Issues: If the API returns the correct response but the UI displays an
//      error (e.g., misinterpreting the response or failing to render the data correctly), this
//      indicates a UI problem.
//• Check for JavaScript Errors: JavaScript errors can cause the UI to fail to handle valid API
//      responses correctly. Use the Console tab in browser developer tools to look for such
//      errors.

//Example: Identifying a UI Error in Selenium (Java)

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class uiErrorVerification {
    public static void main(String[] args) {
        // Set the path to the WebDriver executable

        ChromeDriver driver = new ChromeDriver();

         try {

            driver.get("https://www.saucedemo.com/");

             // Simulating a UI action
            driver.findElement(By.id("user-name")).sendKeys("Admin");
            driver.findElement(By.id("password")).sendKeys("Admin");
            driver.findElement(By.name("login-button")).click();

            // Checking if the UI shows an error
            List<WebElement> errorElements = driver.findElements(By.xpath("//h3"));

            if (!errorElements.isEmpty()) {
                System.out.println("UI Error Detected: " + errorElements.get(0).getText());
            } else {
                System.out.println("No UI Error Detected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             driver.quit();
         }
    }
}