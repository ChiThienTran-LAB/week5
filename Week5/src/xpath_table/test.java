package xpath_table;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test {
	@Test
	//1
	public static void Check_getTTC() {
		//Start Web
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		//cal func
		getTTC(driver);
		//close
		driver.close();
	}
	@Test
	//2
	public static void Check_getTTR() {
		//Start Web
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		//cal func
		getTTR(driver);
		//close
		driver.close();
	}
	@Test
	//3
	public static void Check_getRowNumber() {
		//Start Web
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		//cal func
		getRowNumberByValue(driver, "391.1");
	}
	//
	@Test
	//4
	public static void Check_getTableCellValue() {
		//Start Web
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		//cal func
		getTableCellValue(driver, 3);
	}
	@Test
	//5
	public static void Check_checkItemExist() {
		//Start Web
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		//cal func
		checkItemExist(driver,"917.6");
	}
	//1
	public static void getTTC(WebDriver dri) {
		List<WebElement> col = dri.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Total col: " +col.size());
	}
	//2
	public static void getTTR(WebDriver dri) {
		List<WebElement> row = dri.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("Total row: " +row.size());
	}
	//3
	public static void getRowNumberByValue(WebDriver dri, String data) {
		boolean found = true;
		List<WebElement> list_row = dri.findElements(By.xpath("//table/tbody/tr"));
		int size = list_row.size();
		for (int i=0; i<size; i++) {
			WebElement currentPrice = dri.findElement(By.xpath("//table/tbody/tr["+i+"]//td[4]"));
			if(currentPrice.equals(data)) {
				System.out.println("Gtrị "+data+" của dòng : "+i);
			}
			else if(i == list_row.size() && !currentPrice.equals(data)){
				found = false;
				System.out.println("Không có gtri cần tìm ứng với: "+data);
			}
		}
	}
	//4
	public static void getTableCellValue(WebDriver dri, int col) {
		//col cho trước
		WebElement currentPrice = dri.findElement(By.xpath("//table/tbody/tr["+col+"]//td[4]"));
		System.out.println("Kết quả: "+currentPrice.getText());	
	}
	//5
	public static void checkItemExist(WebDriver dri, String text) {
		boolean found = true;
		//tìm tất cả các dòng
		List<WebElement> list_row = dri.findElements(By.xpath("//table/tbody/tr"));
		for (int i = 1; i <=list_row.size();i++) {
			//code của getRowNumberByValue
			WebElement currentPrice = dri.findElement(By.xpath("//table/tbody/tr["+i+"]//td[4]"));
	
			if(currentPrice.equals(text)) {
				System.out.println(text+"của"+i);
			}
			else if(i == list_row.size() && !currentPrice.equals(text)){
				found = false;
				System.out.println("Không có gtri cần tìm ứng với: "+text);
			}
		}
	}
}	
	

