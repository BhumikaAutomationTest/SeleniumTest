import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryDropDownTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		BrowserFactory br=new BrowserFactory();
		driver=br.launchBrowser("chrome");
		br.openApplication("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		By optionDropDown=By.id("justAnInputBox1");
		ElementUtil ele=new ElementUtil(driver);
		WebElement optionList=ele.getElement(optionDropDown);
		optionList.click();
		Thread.sleep(2000);
		By choice =By.cssSelector(".comboTreeItemTitle");
		selectOptions(choice,"select_all");

	

}
public  static void selectOptions(By locator,String... value) {
	List<WebElement> choiceList = driver.findElements(locator);
	if(!value[0].equalsIgnoreCase("select_all")) {
	for(WebElement e:choiceList) {
		for(int i=0;i<value.length;i++)
		if(e.getText().equals(value[i])) {
			e.click();
			break;
		}
	}
	}else {
		try {
			for (WebElement e : choiceList) {
				e.click();
			}
		} catch (Exception e) {

		}
	}
		
	}

public static WebElement getElement(By locator) {
	return driver.findElement(locator);
}
	
}
