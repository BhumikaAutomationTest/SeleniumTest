import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JquerySlider {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/#default");
		driver.findElement(By.xpath("//a[text()='Vertical slider']")).click();
		WebElement sliderFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(sliderFrame);
		By slideBar=By.cssSelector(".ui-slider-handle");	
		Thread.sleep(2000);
		slideUsingJQuery(slideBar,driver, -60);
	}

	public static void slideUsingJQuery(By locator, WebDriver driver, int value) {
		 WebElement slider=driver.findElement(locator);
		 //JavascriptExecutor js=(JavascriptExecutor)driver;
		 Actions action =new Actions(driver);
		 action.click(slider).build().perform();
		 Keys key = value > 0 ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT;
		 value=Math.abs(value);
		 for(int i=0;i<value;i++) {
			 action.sendKeys(key).build().perform();			 
		 }
		
	}
}
