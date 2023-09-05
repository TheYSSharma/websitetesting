package Test_Scenerio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.BrokenLinksinAboutUs;
import Objects.AlphaClub;
import Objects.AlphaPay;
import Objects.BrokenLinksinExcel;
import Objects.CSVWriter;
import Objects.BrokenLinks_Fe;
import Objects.HomePage;
import Objects.PPC_Classic;
import Objects.PPC_Platinum;
import Objects.BrokenLinks_MT;
import Objects.BrokenLinks_News;
import Objects.BrokenLinks_Promotions;
import Objects.BrokenLinks_Vas;
import Objects.BrokenLinksWU_MT;
import Objects.BrokenLinks_Blog;
import Objects.BrokenLinks_Branches;
import Objects.BrokenLinks_Careers;
import Objects.BrokenLinks_Corporate;
import Objects.Wps_PayrollService;

public class Testmethods {
	WebDriver driver;
	
	public static  String SAMPLE_CSV_FILE = "C:\\Users\\yash\\Desktop\\Testing - Yash\\Test.csv";
	CSVPrinter csvPrinter;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforetest() throws IOException 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://alfardanexchange.com/");
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
		csvPrinter= new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Srno", "Url", "Status"));
	}
	@Test
	public void GetLinks() throws IOException {

//		driver.get("https://alfardanexchange.com/");
//		System.out.println("HOMEPAGE");
//		HomePage hp = new HomePage(driver, csvPrinter);
//		hp.HomepageCSV();


		driver.get("https://alfardanexchange.com/");
		System.out.println("Homepage");
		BrokenLinksinExcel blx= new BrokenLinksinExcel(driver, csvPrinter);
		blx.LinksinCsv();
		
		driver.get("https://alfardanexchange.com/about");
		System.out.println("ABOUT US");
		BrokenLinksinExcel Abtus = new BrokenLinksinExcel(driver, csvPrinter);
		Abtus.LinksinCsv();

		driver.get("https://alfardanexchange.com/money-transfer");
		System.out.println("Services - Money Transfer");
		BrokenLinks_MT mt = new BrokenLinks_MT(driver, csvPrinter);
		mt.LinksinMt();
		
		System.out.println("Services - Foreign Exchange");
		driver.get("https://alfardanexchange.com/foreign-exchange");
		BrokenLinks_Fe fe = new BrokenLinks_Fe(driver, csvPrinter);
		fe.FeLinks();
		
		System.out.println("Services - Foreign Exchange");
		driver.get("https://alfardanexchange.com/value-added-services");
		BrokenLinks_Vas Vas = new BrokenLinks_Vas(driver, csvPrinter);
		Vas.VasLinks();

		System.out.println("Services - PPC Classic");
		driver.get("https://alfardanexchange.com/travelez-classic");
		PPC_Classic Ppc = new PPC_Classic(driver, csvPrinter);
		Ppc.Ppc_Links();

		System.out.println("Services - Prepaid Card Platinum");
		driver.get("https://alfardanexchange.com/travelez-platinum");
		PPC_Platinum ppcp = new PPC_Platinum(driver,csvPrinter);
		ppcp.Ppcp_Links();

		System.out.println("Services - WPS and Payroll Services");
		driver.get("https://alfardanexchange.com/wps-payroll-service");
		Wps_PayrollService Wpsps = new  Wps_PayrollService(driver,csvPrinter);
		Wpsps.Wpsps_Links();
 
		System.out.println("Services - Western Union Money Transfer");
		driver.get("https://alfardanexchange.com/western-union");
		BrokenLinksWU_MT wumt = new  BrokenLinksWU_MT(driver,csvPrinter);
		wumt.Wumt_Links();

		System.out.println("Services - Links in AlphaClub");
		driver.get("https://alfardanexchange.com/alfaclub");
		AlphaClub Apc = new  AlphaClub(driver,csvPrinter);
		Apc.Apc_Links();

		System.out.println("Services - Links in AlphaPay");
		driver.get("https://alfardanexchange.com/alfapay");
		AlphaPay App = new  AlphaPay(driver,csvPrinter);
		App.App_Links();

		System.out.println("Branches");
		driver.get("https://alfardanexchange.com/about");
		BrokenLinks_Branches Branches = new  BrokenLinks_Branches(driver,csvPrinter);
		Branches.Branches_Links();

		System.out.println("Corporate");
		driver.get("https://alfardanexchange.com/corporate");
		BrokenLinks_Corporate Corp = new  BrokenLinks_Corporate(driver,csvPrinter);
		Corp.Corp_Links();
 			
		System.out.println("Careers");
		driver.get("https://alfardanexchange.com/careers");
		BrokenLinks_Careers Car = new  BrokenLinks_Careers(driver,csvPrinter);
		Car.Career_Links();
		
		System.out.println("Media- Blog");
		driver.get("https://alfardanexchange.com/blog");
		BrokenLinks_Blog Blog = new  BrokenLinks_Blog(driver,csvPrinter);
		Blog.Blog_Links();
		
		System.out.println("Media- News");
		driver.get("https://alfardanexchange.com/news");
		BrokenLinks_News News = new  BrokenLinks_News(driver,csvPrinter);
		News.News_Links();

		System.out.println("Media- Promo");
		driver.get("https://alfardanexchange.com/promotions");
		BrokenLinks_Promotions Promo = new  BrokenLinks_Promotions(driver,csvPrinter);
		Promo.Promo_Links();


		
		
//		System.out.println("Writing in CSV");
//		CSVWriter wcsv = new CSVWriter();
//		String[] string = null;
//		wcsv.WriteinCSV(string);
	}

	@AfterTest
	public void aftertest() {
		driver.close();

	}

}
