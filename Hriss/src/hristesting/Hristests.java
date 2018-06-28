package hristesting;

import hristesting.UserLogin;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hristests {
	WebDriver driver;
	String url="http://hris.qainfotech.com";
	@BeforeTest
	public void launch() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.className("active")).click();
	}
	@Test(priority=0)
	public void invalidusercredentials() {
		UserLogin obj= new UserLogin(driver);
		obj.login("robinsingh","password");
		driver.findElement(By.className("active")).click();
		Assert.assertTrue(obj.getmessagewhenwrongcredentials().contains("Invalid Login"));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(priority=1)
	public void nousernameandpassword() {
		UserLogin obj = new UserLogin(driver);
		obj.login("","");
		driver.findElement(By.className("active")).click();
		Assert.assertTrue(obj.behaviourwhennousernameandpasswordisentered().contains("border: 1px solid red; box-shadow: red 0px 1px 1px inset, red 0px 0px 4px"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	@Test(priority=2)
	public void onlyusernameisentered() {
		UserLogin obj=new UserLogin(driver);
		obj.login("robinsingh","");
		driver.findElement(By.className("active")).click();
		Assert.assertTrue(obj.behaviourwhennopasswordisentered().contains("border: 1px solid red"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.className("active")).click();
	}
	@Test(priority=3)
	public void onlypasswordisentered() {
		UserLogin obj=new UserLogin(driver);
		obj.login("","password");
		driver.findElement(By.className("active")).click();
		Assert.assertTrue(obj.behaviourwhennousernameandpasswordisentered().contains("border: 1px solid red; box-shadow: red 0px 1px 1px inset, red 0px 0px 4px"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().refresh();
		driver.findElement(By.className("active")).click();
	}
	
	
	@Test(priority=4)
	public void validcredentials() {
		UserLogin obj =new UserLogin(driver);
		obj.login("robinsingh", "Robin@321#");
		Assert.assertTrue(obj.getmessagewhenrightcredentials().contains("4575"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(priority=5)
	public void logoutfromaccount() {
		Logout obj = new Logout(driver);
		obj.logout();
		Assert.assertTrue(obj.getmessagewhenuserlogout().contains("Access Payroll Online"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
	
}
