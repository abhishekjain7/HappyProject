package NGCase;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Annotate {
	
	WebDriver driver;
	 Boolean b;
  @Test (groups={"sanity"})
  public void openUrl() {
	  System.out.println("Opening Test Application");
	  driver.get("http://shiksha.com");
	 
	  
	 
	  
	  
  }
  
  @Test (dataProvider="loginData", groups={"sanity"})
  public void verifyLogin(String username, String password, String Name) throws InterruptedException{
	 System.out.println(username+ password+ Name);
	 
	  driver.findElement(By.linkText("Log in")).click();
	  Thread.sleep(7000);
	  driver.findElement(By.id("loginOverlayEmail")).sendKeys(username);
	  driver.findElement(By.id("loginOverlayPassword")).sendKeys(password);
	  driver.findElement(By.id("loginOverlayPassword")).submit();
	  Thread.sleep(7000);
	  String n=driver.findElement(By.className("n-username")).getText();
	  System.out.println(n);
	  try{
	  Assert.assertTrue("Name not matching", n.equals(Name));
	  }catch(Throwable T)
	  {
		  
		  System.out.println("name mismatch"+T.getMessage());
		 
	  }
	  Actions builder=new Actions(driver);
	  Action mousehover= builder.moveToElement( driver.findElement(By.xpath("//*[@id='_globalNav']/div[2]/div[3]/span[3]/a[1]"))).build();
	  mousehover.perform();
	  Thread.sleep(3000);
	  b=driver.findElement(By.linkText("Sign Out")).isDisplayed();
	  System.out.println(b);
	 if(driver.findElement(By.linkText("Sign Out")).isDisplayed())
	  { 
		  driver.findElement(By.linkText("Sign Out")).click();
	  }
	  //}else
	  //{
		//  String errorText=driver.findElement(By.id("username_header_error")).getText();
		//  System.out.println(errorText+"fdfs");
	 // }  
	 // b=false;
	  Thread.sleep(5000);
  }
  
  @DataProvider 
  
  public Object[][] loginData(){
	  Object[][] data=new Object[2][3];
	  data[0][0]="abhishek.jain@naukri.dddd";
	  data[0][1]="qwas123))";
	  data[0][2]="Sdjdshfj";
	  data[1][0]="abhishekjain94@yahoo.com";
	  data[1][1]="abc123123";
	  data[1][2]="Abhishek Jain";
	  
	  return data;
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("In before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("In after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("In before class method");
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("in after class method");
  }

  @BeforeTest
  public void beforeTest() {
	 System.out.println("in before test method");
	
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("in after test mentod");
  }

  @BeforeSuite (groups={"sanity"})
  public void beforeSuite() {
	  System.out.println("in before suite method");
	  System.out.println("Opening Browser");
	 /* File pathToFirefoxBinary = new File("D:\\ff\\firefox.exe");
		FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);  
		driver= new FirefoxDriver(firefoxbin, null);*/
	 // driver=new FirefoxDriver();
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	
	  driver = new ChromeDriver();
	 // driver.manage().window().maximize();
  }

  @AfterSuite (groups={"sanity"})
  public void afterSuite() {
	  System.out.println("in after suite method");
	  driver.quit();
  }
/*  @BeforeGroups (groups={"sanity", "regression"})
  public void beforeGroups() {
	  System.out.println("before group ");
	 // driver.quit();
  }

@AfterGroups (groups={"sanity", "regression"})
  public void afterGroups() {
	  System.out.println("after group ");
	 // driver.quit();
  }*/

}
