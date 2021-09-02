
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectDropDownExample {

	
	public static void main(String[] args) {
		 WebDriver driver;
		// TODO Auto-generated method stub
		BrowserFactory br=new BrowserFactory();
		driver=br.launchBrowser("chrome");
		br.openApplication("https://www.orangehrm.com/orangehrm-30-day-trial/");
		ElementUtil ele=new ElementUtil(driver);
		By industryDropDown=By.id("Form_submitForm_Industry");
		By conturyDropDown=By.id("Form_submitForm_Country");
		ele.doSelectByIndex(industryDropDown, 12);
		ele.doSelectByIndex(conturyDropDown, 20);
		ele.doSelectByValue(industryDropDown, "health");
		ele.doSelectByValue(conturyDropDown, "Benin");
		ele.doSelectByVisibleText(industryDropDown, "Finance/ Banking / Insurance / Real Estate / Legal");
		ele.doSelectByVisibleText(conturyDropDown, "Papua New Guinea");
		ele.selectDropDownValue(conturyDropDown, "India");
		List<String> industry_list=ele.getDropDownOptionList(industryDropDown);
		for(String e:industry_list) {
			System.out.println("List values is " +e );
		}
	}

}
