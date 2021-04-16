package searchImplementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;

public class BaseClass {
	public static WebDriver driver;
	String path = System.getProperty("user.dir");
	
	/*
	 * Param: search result
	 * Function: Fetching Device Name,Price,Storage and Rating; 
	 * 			Used comparable interface for sorting.
	 * */
	

	public void intiBrowser() {
		System.setProperty("webdriver.chrome.driver", path+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void doSearchAndSaveResult(List<WebElement> searchResult) {
		ArrayList<Mobile> list = new ArrayList<Mobile>();
		
		for(int i =0;i<searchResult.size()-2;i++) {
			//Get Device Name
			String deviceName = searchResult.get(i).findElement(By.xpath(".//a/div[2]/div[1]/div")).getText();
			int deviceRating;
			
			//Get Device Rating
			String ratingAndReview = searchResult.get(i).findElement(By.xpath(".//a/div[2]/div[1]/div[2]/span[2]")).getText();
			String[] ratingAndReviewArray = ratingAndReview.split("&");			
			String[] rateArray = ratingAndReviewArray[0].trim().split(" ");
			deviceRating = Integer.parseInt(rateArray[0].replace(",", ""));
			
			//Get Device Storage
			int deviceStorage = Integer.parseInt(searchResult.get(i).findElement(By.xpath(".//a/div[2]/div[1]/div[3]/ul/li[1]")).getText().replace("GB ROM", "").trim());			
			
			//Get Device Price
			double devicePrice = Double.parseDouble(searchResult.get(i).findElement(By.xpath(".//a/div[2]/div[2]/div[1]/div/div")).getText().replaceAll("[\\u20B9,]", "").trim());
			list.add(new Mobile(deviceName, deviceRating, deviceStorage, devicePrice));
		}
				
        Collections.sort(list); 
        saveResultInCSV(list);
	}
	
	/*
	 * Param: List type of Mobile
	 * Function: Save Device information in CSV format
	 * */
	public void saveResultInCSV(ArrayList<Mobile> list) {
		File file = new File(path+"/target/result.csv");
        FileWriter outputfile;
		try {
			outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			// adding header to csv
	        String[] header = { "Device Name", "Price","Storage", "Rating" };
	        writer.writeNext(header);
	        
	        for (Mobile mobile: list)
	        {
	        	String[] data1 = { mobile.getDeviceModel(), String.valueOf(mobile.getDevicePrice()), String.valueOf(mobile.getDeviceStorage()), String.valueOf(mobile.getRating()) };
	            writer.writeNext(data1);
	        }
	        writer.close();
			System.out.println("Data Successfully saved in CSV ");
		} catch (IOException  e) {
			System.out.println("Something went wrong while saving search result in CSV");
			e.printStackTrace();
		}
	}
	
	public void tearDown() {
		driver.close();
	}
}
