//package practice.test;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.comcast.crm.generic.fileutility.ExcelUtility;
//
//public class GetProductInfoTest {
//	
//	@Test(dataProvider = "getData")
//	public void getProductInfoTest(String brandName, String productName) {
//		
//		WebDriver driver  = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://amazon.in");
//		
//		//Search Product
//		
////		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
//		
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
//		
//		//capture the product info
////		String a = "//span[text()='iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
//		
//		String a = "//span[text()='"+ productName +"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
//		String price = driver.findElement(By.xpath(a)).getText();
//		System.out.println(price);
//		
//		driver.quit();
//		
//	}
//	
//	@DataProvider
//	public Object[][] getData(){
//		ExcelUtility eLib = new ExcelUtility();
//		int rowCount = eLib.getRowCount("product");
//		
//		
//		Object[][] objArr = new Object[rowCount][2];
//		
//		for(int i = 0; i<=rowCount; i++) {
//		objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
//		objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
//		}
//		return objArr;
//		}
//		
//	
//	
//	
//	
////	@DataProvider
////	public Object[][] getData(){
////		Object[][] objArr = new Object[3][2];
////		objArr[0][0] = "iphone";
////		objArr[0][1] = "iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine";
////		
////		objArr[1][0] = "iphone";
////		objArr[1][1] = "iPhone 17 256 GB: 15.93 cm (6.3″) Display with Promotion, A19 Chip, Center Stage Front Camera for Smarter Group Selfies, Improved Scratch Resistance, All-Day Battery Life; Black";
////		
////		objArr[2][0] = "iphone";
////		objArr[2][1] = "iPhone Air 256 GB: Thinnest iPhone Ever, 16.63 cm (6.5″) Display with Promotion up to 120Hz, Powerful A19 Pro Chip, Center Stage Front Camera, All-Day Battery Life; Light Gold";
////		return objArr;
////		
////	}
//
//}
