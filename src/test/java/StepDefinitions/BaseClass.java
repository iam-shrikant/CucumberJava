package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriverWait wait;
	
	public void initBrowser(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "E:/Selenium Java/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
	}
	
	public WebElement getElement(WebDriver driver, By locator) {
		// TODO Auto-generated method stub
		//return null;
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("Some error/exception occure while locating web element : "+locator.toString());
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	public void waitForElementPresent(By locator) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("Some error/exception occure while waiting for web element : "+locator.toString());
			System.out.println(e.getMessage());
		}
	}

}
