package hristesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserLogin {
	WebDriver driver;
	  
	  public UserLogin(WebDriver driver) {
		  this.driver = driver;
	  }
	public void login(String user, String password) {
		
		driver.findElement(By.id("txtUserName")).sendKeys(user);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("#login > form > div.loginTxtBtn.extraText > div > input")).click();
	}
	public String getmessagewhenwrongcredentials() {
		return driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[1]/div")).getText();
	}
	public  String behaviourwhennousernameandpasswordisentered() {
		return driver.findElement(By.xpath("//*[@id=\"txtUserName\"]")).getAttribute("style");
		
	}
	public String behaviourwhennopasswordisentered() {
		return driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).getAttribute("style");
	}
	public String getmessagewhenrightcredentials() {
		return driver.findElement(By.xpath("//*[@id=\"drawerDiv\"]/user-profile-sidebar/div/div[2]/div/ul[1]/li[3]/span[2]")).getText();
	}
}
