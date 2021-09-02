import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterOpenCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = "fireFox";
		BrowserFactory brObj = new BrowserFactory();
		WebDriver driver = brObj.launchBrowser(browser);
		brObj.openApplication("https://demo.opencart.com/index.php?route=account/register");
		System.out.println("Page current title is " + brObj.getCurrentTitle());
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By phone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPwd = By.id("input-confirm");

		ElementUtil ele = new ElementUtil(driver);
		ele.doSendKeys(firstName, "QAFirst");
		ele.doSendKeys(lastName, "QALast");
		ele.doSendKeys(email, "QAfirst@gmail.com");
		ele.doSendKeys(phone, "1234567");
		ele.doSendKeys(password, "qatest123");
		ele.doSendKeys(confirmPwd, "qatest123");
		driver.close();
	}

}
