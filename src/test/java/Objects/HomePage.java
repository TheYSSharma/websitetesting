package Objects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	CSVPrinter csvPrinter;
	
	public HomePage(WebDriver driver, CSVPrinter csvPrinter) {
		this.driver = driver;
		this.csvPrinter = csvPrinter;
	}
	By Homepage = By.xpath("");
	
	public void HomepageCSV() throws IOException
	{	String url;
		int i = 1;
		int count=1;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		try {

		for (WebElement link : allLinks) {
			url= link.getAttribute("href");	
			System.out.println(i + ")" + link.getText() + " - " + url);
			URL link1 = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link1.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			i++;
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
				csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage());
			} 
			else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
				csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			count++;
		}
		catch (IOException e) {				
			System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage());
		}
		
		
	}

}

	public HomePage(WebDriver driver, CSVPrinter csvPrinter) {
		this.driver = driver;
		this.csvPrinter = csvPrinter;
	}

	By Homepage = By.xpath("//img[@alt='AL FARDAN EXCHANGE']");

	public void GetHomepagelinks() {
		int i = 1;
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {

			System.out.println(i + ")" + link.getText() + " - " + link.getAttribute("href"));
			i++;
		}

		for (WebElement link : allLinks) {
			String url = link.getAttribute("href");
			verifyLink(url);

		}

		try {
			csvPrinter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	int count = 1;

	public void verifyLink(String url) throws IOException {
		int i = 1;
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {

		
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
				csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage());
			} 
			else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
				csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
			count++;
		} 
	}


