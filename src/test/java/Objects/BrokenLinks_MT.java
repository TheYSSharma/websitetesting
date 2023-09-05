package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinks_MT {
	WebDriver driver;
	CSVPrinter csvPrinter;

	public BrokenLinks_MT(WebDriver driver, CSVPrinter csvPrinter) {
		this.driver = driver;
		this.csvPrinter = csvPrinter;
	}

	By Homepage = By.xpath("//img[@alt='AL FARDAN EXCHANGE']");

	public void LinksinMt() throws IOException {
		String url;
		int i = 1;
		int count = 1;
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		try {
			for (WebElement link : allLinks) {
				url = link.getAttribute("href");
				if (url != null && url.contains("https://")) {
					URL Link1 = new URL(url);
					HttpURLConnection httpURLConnection = (HttpURLConnection) Link1.openConnection();
					httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
					httpURLConnection.connect();				
					try {

						if (httpURLConnection.getResponseCode() == 200) {

							System.out.println(i + ")" + link.getText() + "-" + url + "-"
									+ httpURLConnection.getResponseMessage());
							csvPrinter.printRecord(count, url, httpURLConnection.getResponseMessage());
						}

					} catch (IOException e) {
						System.out.println(url + "-" + "Something went wrong");
						csvPrinter.printRecord(count, url,
								httpURLConnection.getResponseMessage() + " - " + "is a broken link- catch");
					}

					i++;
					count++;
				} else {
					System.out.println(i + ")" + "-" + url + "-" + "Something went wrong");
					csvPrinter.printRecord(count, url, "Fail");
					i++;
					count++;
				}
			}

		} catch (Exception ex) {
			csvPrinter.flush();
		} finally {
			//csvPrinter.flush();
		}

	}


}
	
	

