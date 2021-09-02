

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarExample {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(1000);
		selectDepatureDate("February 2022","28");
	}

	public static void selectDepatureDate(String expectedMonthYear,String date) {
		String actualMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
		while(!actualMonthYear.equals(expectedMonthYear)) {
			driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
			actualMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();			
		}
		int totalDay=driver.findElements(By.xpath("//div[@class='DayPicker-Day']/div")).size();
		if(Integer.parseInt(date)<=totalDay) {
		driver.findElement(By.xpath("//div[@class='DayPicker-Day']/div[text()='"+date+"']")).click();
		}
		else {
			System.out.println("Enter valid date");
			return;
		}
	}
}
