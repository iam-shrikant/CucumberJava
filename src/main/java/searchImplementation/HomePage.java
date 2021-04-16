package searchImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass{
	
	private By closeSignUpPopUp = By.cssSelector("button[class='_2KpZ6l _2doB4z']");
	private By searchBox = By.name("q");
	private By submitSearch = By.xpath("//button[@type='submit' and @class='L0Z3Pu']");
	
	public void closeSignUpPopUp() {
		driver.findElement(closeSignUpPopUp).click();
	}

	public SearchResultPage doSearch(String queryString) {
		// TODO Auto-generated method stub
		driver.findElement(searchBox).sendKeys(queryString);
		driver.findElement(submitSearch).click();
		SearchResultPage search = new SearchResultPage();
		search.filterResultWithCategory("Mobiles");	
		return search;
	}
}
