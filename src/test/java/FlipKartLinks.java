import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipKartLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = "fireFox";
		BrowserFactory brObj = new BrowserFactory();
		WebDriver driver = brObj.launchBrowser(browser);
		brObj.openApplication("https://www.myntra.com/");
		ElementUtil eleObj = new ElementUtil(driver);
		By link=By.tagName("a");
		List<WebElement> linkList=eleObj.getElements(link);
		int i=0;
		for(WebElement e:linkList) {
			String text=e.getText();
			//if(!text.isEmpty()) {
			System.out.println("index is " + i + "and link text is " +text);
			//}
			i++;
		}
		System.out.println("Total links are: " +i);
	}

}
