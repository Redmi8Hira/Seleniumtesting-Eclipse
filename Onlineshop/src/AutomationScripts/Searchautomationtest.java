package AutomationScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Searchautomationtest {

    Actions action;
    WebDriver driver;

    public Searchautomationtest(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void pressEnter() {
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hirantha Abeykoon\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Searchautomationtest objSearch = new Searchautomationtest(driver);

        // Navigate to the login page
        driver.get("http://localhost/grocery%20store/login.php");
        driver.manage().window().maximize();

        // Perform login (example with email and password fields)
        WebElement emailField = driver.findElement(By.name("email")); 
        WebElement passwordField = driver.findElement(By.name("pass")); 
        emailField.sendKeys("kamal5@gmail.com");
        passwordField.sendKeys("45");
        driver.findElement(By.xpath("/html/body/section/form/input[3]")).click();

        // Navigate to the search page after login
        driver.get("http://localhost/grocery%20store/search_page.php");

        // Find the search input field and perform a search
        WebElement inputSearch = driver.findElement(By.xpath("/html/body/section[1]/form/input[1]"));
        inputSearch.sendKeys("Chicken");
        objSearch.pressEnter();
        
        // Verify the outcome (Asserting to ensure that search_product worked properly)
        WebElement product = driver.findElement(By.id("pn"));
        String actualValue = product.getText();
        String expectedValue = "Chicken - 1.00 kg";

        // Debugging: Print the actual value retrieved
        System.out.println("Actual Value: '" + actualValue + "'");
        System.out.println("Expected Value: '" + expectedValue + "'");

        // Compare the actual and expected values
        if (actualValue.equals(expectedValue)) {
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed");
        }

        // Close the browser
       driver.quit();
    }
}
