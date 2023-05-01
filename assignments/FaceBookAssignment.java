package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://en-gb.facebook.com/");

		// Maximize Window
		driver.manage().window().maximize();

		// Implicit Time Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click On "Create New Account" Button
		driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
		
		//Enter First Name, Last Name, Mobile No. & Password
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Priya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Priya");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("priyanaren0111@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("priyanaren0111@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Priya#0111");
		
		//Handling 3 Drop Down Lists of Date of Birth
		WebElement day = driver.findElement(By.id("day"));
		Select daydrop = new Select(day);
		daydrop.selectByVisibleText("11");
		
		WebElement month = driver.findElement(By.id("month"));
		Select monthdrop = new Select(month);
		monthdrop.selectByVisibleText("Aug");
		
		WebElement year = driver.findElement(By.id("year"));
		Select yeardrop = new Select(year);
		yeardrop.selectByVisibleText("1992");
		
		//Selecting Gender
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		
		
		
	}

}
