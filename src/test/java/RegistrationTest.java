

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
	}

	@DataProvider
	public Object[][] getRegistrationData(){
		return new Object[][]{{"QAFirstName1","QALastName1","QAfirst0last01@gmail.com","123456789","test@123"},
				{"QAFirstName2","QALastName2","QAfirst2last2@gmail.com","234567891","test@123"},
				{"QAFirstName3","QALastName3","QAfirst3last3@gmail.com","234657891","test@123"}				
				};
	}
	
	@Test(dataProvider="getRegistrationData")
	public void verfiyRegistration(String fName,String lName,String email,String phone,String password) {
		Assert.assertTrue(fillRegistrationPage(fName,lName,email,phone,password));
	}
	

	public boolean fillRegistrationPage(String fName,String lName,String email,String phone,String password) {
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(fName);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(lName);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).clear();
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).clear();
		driver.findElement(By.id("input-confirm")).sendKeys(password);
		driver.findElement(By.xpath("(//label[@class='radio-inline'])[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		return driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).isDisplayed();
				
	}
	@AfterMethod
	public void logOut() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Register']")).click();
		Thread.sleep(1000);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
