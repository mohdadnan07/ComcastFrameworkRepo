package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithAfterDateTest {

	public static void main(String[] args) throws Throwable {

		// Read the data from properties file

//		FileInputStream fis = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\commondata.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String BROWSER = pObj.getProperty("browser");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("username");
//		String PASSWORD = pObj.getProperty("password");

		FileUtility fLib = new FileUtility();

		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		// Generate the random number
//		Random random = new Random();
//		int randInt = random.nextInt(1000);
		
		JavaUtility jLib = new JavaUtility();

		// Read the data from Excel File
//		FileInputStream fis1 = new FileInputStream("C:\\Users\\Abdul Saad\\OneDrive\\Desktop\\data\\testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("contact");
//		Row row = sh.getRow(1);
//		String lastName = row.getCell(2).toString() + randInt;
//		System.out.println(lastName);
//		wb.close();
		
		ExcelUtility eLib = new ExcelUtility();
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// Generate date and after 30 days date
		Date dateObj = new Date();
		System.out.println(dateObj);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sdf.format(dateObj);
		System.out.println(startDate);

		Calendar cal = sdf.getCalendar();
		cal.add(cal.DAY_OF_MONTH, 30);
		String endDate = sdf.format(cal.getTime());

		System.out.println(endDate);

		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify the header msg of contact expected result
		String contactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactInfo.contains(lastName)) {
			System.out.println(lastName + " is created=====PASS");
		} else {
			System.out.println(lastName + " is not created=====fail");
		}

		// verify the header contactName lastName info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " is created=====PASS");
		} else {
			System.out.println(lastName + " is not created=====fail");
		}

		// verify the header of startDate and endDate
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " is created=====PASS");
		} else {
			System.out.println(startDate + " is not created=====fail");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actEndDate.contains(startDate)) {
			System.out.println(endDate + " is created=====PASS");
		} else {
			System.out.println(endDate + " is not created=====fail");
		}

		// LOGOUT
//				Actions act = new Actions(driver);
//				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//				driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.quit();

	}

}
