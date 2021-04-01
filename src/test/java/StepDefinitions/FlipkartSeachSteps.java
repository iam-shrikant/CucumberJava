package StepDefinitions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSeachSteps extends BaseClass{
	WebDriver driver;
	String path = System.getProperty("user.dir");
	
	
	@Given("Open browser")
	public void open_browser() {		
		System.setProperty("webdriver.chrome.driver", path+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@And("Goto Flipkart.com")
	public void goto_flipkart_com() {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
	}

	@When("User search for iPhones mobile")
	public void user_search_for_i_phones_mobile() {
		driver.findElement(By.name("q")).sendKeys("iphones");
		driver.findElement(By.xpath("//button[@type='submit' and @class='L0Z3Pu']")).click();
		driver.findElement(By.cssSelector("a[title='Mobiles']")).click();
	}

	//Using price filter value as 50000 bcz 40000 is not available 
	@And("Having maximum price of INR 50000")
	public void having_maximum_price_of_inr() throws InterruptedException {  
		Select priceRange = new Select(driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")));
		priceRange.selectByValue("50000");
		Thread.sleep(2000);
	}

	@Then("Retrive and Save device model, Storage capacity and customer rating")
	public void retrive_and_save_device_model_storage_capacity_and_customer_rating() {
		
		//Get all search result
		List<WebElement> searchResult = driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[@class='_1AtVbE col-12-12']"));
		
		//Defined in baseClass
		doSearchAndSaveResult(searchResult);
		driver.close();
	}

	
}
