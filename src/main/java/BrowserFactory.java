import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private WebDriver driver;

	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Please enter the correct browser name");
		}
		return driver;
	}

	public void openApplication(String url) {
		if (url == null || url.isEmpty() || url.isBlank()) {
			System.out.println("Enter valid url");
		}
		driver.get(url);
	}

	public String getCurrentTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageSource() {
		return driver.getPageSource();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
