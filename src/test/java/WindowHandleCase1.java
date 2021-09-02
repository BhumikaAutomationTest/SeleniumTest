import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleCase1 {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//img[@alt=\"LinkedIn OrangeHRM group\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"OrangeHRM on Facebook\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"OrangeHRM on twitter\"]")).click();
		driver.findElement(By.xpath("//img[@alt=\"OrangeHRM on youtube\"]")).click();
		Set<String> handles=driver.getWindowHandles();
		List<String> handlesList=new ArrayList<String>(handles);
		for(int i=0;i<handlesList.size()-1;i++) {
			driver.switchTo().window(handlesList.get(i+1));
			System.out.println("Title is "+driver.getTitle());
			driver.close();
		}
		driver.switchTo().window(handlesList.get(0));
		System.out.println("Title is "+driver.getTitle());

	}

}
