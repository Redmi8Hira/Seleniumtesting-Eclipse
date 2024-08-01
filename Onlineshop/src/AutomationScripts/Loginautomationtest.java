package AutomationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginautomationtest {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hirantha Abeykoon\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the login page
        driver.get("http://localhost/grocery%20store/login.php");

        // Perform necessary actions (e.g., enter data, click buttons)
        // Provide user name
        WebElement username = driver.findElement(By.name("email"));
        username.sendKeys("nimal38@gmail.com");

        // Provide password
        WebElement password = driver.findElement(By.name("pass"));
        password.sendKeys("38");

        // Clicking on the login button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        // Verify the outcome (Asserting to ensure that login worked properly)
        // Use explicit wait if necessary to wait for the element to be visible
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement welcome = driver.findElement(By.id("welcome"));
        String actualValue = welcome.getText().trim(); // Use trim() to remove leading and trailing spaces

        String expectedValue = "Welcome, Nimal!";

        if (actualValue.equals(expectedValue)) {
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed. Actual value: " + actualValue);
        }

        // Close the browser
        driver.quit();
    }
}
