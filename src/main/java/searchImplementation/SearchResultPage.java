package searchImplementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchResultPage extends BaseClass {
	private By catMobileFilter = By.cssSelector("a[title='Mobiles']");
	private By priceFilter = By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']");
	private By searchResults = By.xpath("//*[@id='container']/div/div[3]/div/div[2]/div[@class='_1AtVbE col-12-12']");
	
	public void filterResultWithCategory(String filterKey) {
		driver.findElement(By.cssSelector("a[title='"+filterKey+"']")).click();
	}

	public void filterResultWithPrice(String string) {
		// TODO Auto-generated method stub
		Select priceRange = new Select(driver.findElement(priceFilter));
		priceRange.selectByValue("50000");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void retriveAndSave() {
		List<WebElement> searchResult = driver.findElements(searchResults);
		doSearchAndSaveResult(searchResult);
	}
}
