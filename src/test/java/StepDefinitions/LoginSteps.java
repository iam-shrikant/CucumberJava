package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	public WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("shrikant");
		System.setProperty("webdriver.chrome.driver", "E:/Selenium Java/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://example.testproject.io/web/");
	}

	@When("^user enter valid (.*) and (.*)$")
	public void user_enter_valid_username_and_password(String username, String password) {
		System.out.println("inside Step - user enter valid username and password");
		try {
			driver.findElement(By.id("name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
		}catch(Exception e) {
			System.out.println("Found Exceptions: "+e.getMessage());
		}
	}

	@And("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.id("login")).click();
	}

	@Then("user must redirect to home page")
	public void user_must_redirect_to_home_page() {
		boolean logOut = driver.findElement(By.id("logout")).isEnabled();
		Assert.assertTrue(logOut);
		
	}
}
