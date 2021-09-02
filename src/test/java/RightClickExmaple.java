import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightClickExmaple {

	public static void main(String[] args) {
		BrowserFactory br=new BrowserFactory();
		WebDriver driver=br.launchBrowser("chrome");
		br.openApplication("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement button=driver.findElement(By.xpath("//span[text()='right click me']"));	
		Actions action=new Actions(driver);
		action.contextClick(button).perform();
		List<WebElement> options=driver.findElements(By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span"));
		for(WebElement e:options) {
			String text=e.getText();
			if(text.equals("Quit")) {
				e.click();
				break;
			}
		}
	

	}

}
