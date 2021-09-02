import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpiceJetMouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserFactory br=new BrowserFactory();
		WebDriver driver=br.launchBrowser("chrome");
		br.openApplication("https://book.spicejet.com/search.aspx");
		Thread.sleep(3000);
		ElementUtil ele=new ElementUtil(driver);
		By menuList=By.id("Login");
		By subMenuList=By.linkText("SpiceClub Members");
		By childMenu=By.linkText("Member Login");
		ele.threeLevelMenuHandle(menuList, subMenuList, childMenu);
		br.closeBrowser();
	
	
	}

}
