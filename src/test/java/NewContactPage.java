import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewContactPage {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserFactory br=new BrowserFactory();
		WebDriver driver=br.launchBrowser("chrome");
		br.openApplication("https://classic.freecrm.com/index.html");
		By loginText=By.name("username");
		By pwdText=By.name("password");
		By loginBtn=By.xpath("//input[@value='Login']");
		By contactMenu=By.linkText("CONTACTS");
		By newContactMenu=By.linkText("New Contact");
		By mainFrame=By.xpath("//frame[@name='mainpanel']");
		By firstName=By.id("first_name");
		By lastName=By.id("surname");
		By middleName=By.id("middle_initial");
		By nickName=By.xpath("//input[@name='nickname']");
		By companyName=By.xpath("//input[@name='client_lookup']");
		By position =By.id("company_position");
		By department=By.id("department");
		By supervisor=By.xpath("//input[@name='contact_lookup_sup']");
		By assistant=By.xpath("//input[@name='contact_lookup_ass']");
		By referredBy=By.xpath("//input[@name='contact_lookup_ref']");
		By phone=By.id("phone");
		By mobile=By.id("mobile");
		By homePhone=By.id("home_phone");
		By email=By.id("email");
		By saveButton=By.xpath("//input[@value='Save']");
		
		ElementUtil ele=new ElementUtil(driver);
		ele.doSendKeys(loginText, "groupautomation");
		ele.doSendKeys(pwdText, "Test@12345");
		ele.doClick(loginBtn);
		Thread.sleep(2000);
		driver.switchTo().frame(ele.getElement(mainFrame));
		ele.twoLevelMenuHandle(contactMenu,newContactMenu);
		ele.doActionSendKeys(firstName, "QAFirst");
		ele.doActionSendKeys(middleName, "QAMiddle");
		ele.doActionSendKeys(lastName, "QALast");
		ele.doActionSendKeys(nickName, "QANickName");
		ele.doActionSendKeys(companyName, "QACompnay");
		ele.doActionSendKeys(position, "QAPosition");
		ele.doActionSendKeys(department, "QADepartment");
		ele.doActionSendKeys(supervisor, "QASupervisor");
		ele.doActionSendKeys(assistant, "QAAssistant");
		ele.doActionSendKeys(referredBy, "QAReferredBy");
		ele.doActionSendKeys(phone, "123456789");
		ele.doActionSendKeys(mobile, "2345678991");
		ele.doActionSendKeys(homePhone, "0233456781");
		ele.doActionSendKeys(email, "QAtest@abc.com");
		ele.doActionClick(saveButton);
		
	}

}
