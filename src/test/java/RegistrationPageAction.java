import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageAction {

	public static void main(String[] args) {		
		BrowserFactory br=new BrowserFactory();
		WebDriver driver=br.launchBrowser("chrome");
		br.openApplication("https://demo.opencart.com/index.php?route=account/register");
		By firstName=By.id("input-firstname");
		By lastName=By.id("input-lastname");
		By emailId=By.id("input-email");
		By phone=By.id("input-telephone");
		By password=By.id("input-password");
		By confirmPassword=By.id("input-confirm");
		By subscribeBtn=By.xpath("(//label[@class='radio-inline'])[1]");
		By policyCheckBox=By.name("agree");
		By continueBttn=By.xpath("//input[@class='btn btn-primary']");		
		ElementUtil ele=new ElementUtil(driver);
		ele.doActionSendKeys(firstName, "QAFirstName");
		ele.doActionSendKeys(lastName, "QALastName");
		ele.doActionSendKeys(emailId, "QAEmail@gmail.com");
		ele.doActionSendKeys(phone, "123456789");
		ele.doActionSendKeys(password, "Test@123");
		ele.doActionSendKeys(confirmPassword, "Test@123");
		ele.doActionClick(subscribeBtn);
		ele.doActionClick(policyCheckBox);
		ele.doActionClick(continueBttn);
		
	}
;

}
