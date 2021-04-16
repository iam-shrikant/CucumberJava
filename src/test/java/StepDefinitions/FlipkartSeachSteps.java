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
import searchImplementation.BaseClass;
import searchImplementation.HomePage;
import searchImplementation.SearchResultPage;

public class FlipkartSeachSteps extends BaseClass{
		
	//WebDriver driver;
	String path = System.getProperty("user.dir");
	HomePage home;
	SearchResultPage search;
	
	@Given("Open browser")
	public void open_browser() {		
		intiBrowser();
	}
	
	@And("Goto Flipkart.com")
	public void goto_flipkart_com() {
		driver.get("https://www.flipkart.com/");
		home = new HomePage();
		home.closeSignUpPopUp();
		//driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
	}

	@When("User search for {string} mobile")
	public void user_search_for_mobile(String queryString) {		
		search = home.doSearch(queryString);		
	}

	//Using price filter value as 50000 bcz 40000 is not available 
	@And("Having maximum price of INR 50000")
	public void having_maximum_price_of_inr() throws InterruptedException {  
		search.filterResultWithPrice("50000");
	}

	@Then("Retrive and Save device model, Storage capacity and customer rating")
	public void retrive_and_save_device_model_storage_capacity_and_customer_rating() {
		search.retriveAndSave();
		//Get all search result
		tearDown();		
	}	
}
