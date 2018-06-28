package hristesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Logout {
	WebDriver driver;
	public Logout(WebDriver driver) {
		this.driver=driver;
	}
	public void logout() {
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[1]/div[2]/ul"));	
		dropdown.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@href='https://hris.qainfotech.com:8086/user/logoff']")).click();
	}
	public String getmessagewhenuserlogout() {
		return driver.findElement(By.xpath("/html/body/footer/div/div[1]/ul/li[1]/a")).getText();
	}
}
