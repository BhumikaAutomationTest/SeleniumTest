import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistraionOpenHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = "fireFox";
		BrowserFactory brObj = new BrowserFactory();
		WebDriver driver = brObj.launchBrowser(browser);
		brObj.openApplication("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println("page title is " + brObj.getCurrentTitle());
		ElementUtil ele = new ElementUtil(driver);
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By email = By.id("Form_submitForm_Email");
		By jobTitle = By.id("Form_submitForm_JobTitle");
		By compnayName = By.id("Form_submitForm_CompanyName");
		By phoneNumber = By.id("Form_submitForm_Contact");

		ele.doSendKeys(firstName, "QATest");
		ele.doSendKeys(lastName, "QALast");
		ele.doSendKeys(email, "Qatest@gmail.com");
		ele.doSendKeys(jobTitle, "TestJob");
		ele.doSendKeys(compnayName, "QACompany");
		ele.doSendKeys(phoneNumber, "123456789");

		driver.close();

	}

}
