import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePrint {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com");
		By loginText=By.name("username");
		By pwdText=By.name("password");
		By loginBtn=By.xpath("//input[@value='Login']");
		By contactMenu=By.linkText("CONTACTS");
		By mainFrame=By.xpath("//frame[@name='mainpanel']");
		driver.findElement(loginText).sendKeys("groupautomation");
		driver.findElement(pwdText).sendKeys("Test@12345");
		driver.findElement(loginBtn).click();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(mainFrame));
		driver.findElement(contactMenu).click();
		int rowCount=driver.findElements(By.xpath("//form[@id='vContactsForm']//table//tr")).size();
		int columnCount=driver.findElements(By.xpath("//form[@id='vContactsForm']//table//tr[4]/td")).size();
		System.out.println("Total number of row is " +rowCount);
		System.out.println("Total number of row is " +columnCount);
		String beforXpath="//form[@id='vContactsForm']//table//tr[";
		String afterXpath= "]/td[";
		String lastXpath="]";
		for(int i=4;i<rowCount-1;i++) {
			for (int j=2;j<columnCount-1;j++) {
				String fullXpath=beforXpath+i+afterXpath+j+lastXpath;
				//System.out.println("Full xpath is " +fullXpath);
				//driver.findElement(By.xpath(fullXpath)).getText();
				System.out.println(driver.findElement(By.xpath(fullXpath)).getText());
			}
			
			
		}
	}

}
