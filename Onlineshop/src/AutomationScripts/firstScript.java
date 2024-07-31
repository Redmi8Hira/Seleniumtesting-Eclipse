 package AutomationScripts;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class firstScript {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hirantha Abeykoon\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/grocery%20store/login.php");

	}

}
