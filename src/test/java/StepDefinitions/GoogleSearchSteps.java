package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	public WebDriver driver;
	

	@Given("open browser")
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:/Selenium Java/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		//driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("goto google.com")
	public void goToUrl() {
		driver.get("https://www.google.com/");
	}

	@When("user enter text for search")
	public void EnterSearchString() {
		driver.findElement(By.name("q")).sendKeys("Automation step by step");

	}

	@And("Press enter or search")
	public void doSearch() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user should navigate to search result page")
	public void showSearchResult() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals("Automation step by step - Google Search", actualTitle);
		
		driver.close();
		driver.quit();
	}
}
