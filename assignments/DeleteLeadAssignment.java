package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadAssignment {

	public static void main(String[] args) throws InterruptedException {
		// Launch Browser
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// UserName & Password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on Log In Button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Click on Leads Tab
		driver.findElement(By.linkText("Leads")).click();

		// Click on "Find Lead"
		driver.findElement(By.xpath("//a[contains(text(),'Find')]")).click();

		// Enter First Name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("priya");

		// Click on "Find Leads" Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(1000);
		// Click on the First Resulting Lead
		WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		System.out.println(leadID.getText());
		String checkid = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		leadID.click();

		// Click on "Delete" Button
		driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).click();
		
		// Click on "Find Leads" Button
		driver.findElement(By.xpath("//a[contains(text(),'Find')]")).click();
		
		Thread.sleep(1000);
		//Input the deleted Lead ID
		driver.findElement(By.xpath("//input[@name=\"id\"]")).sendKeys(checkid);
		//String storeid = driver.findElement(By.xpath("//input[@name=\"id\"]")).getText();
		
		Thread.sleep(1000);
		//Clicking "Find Leads" Button again
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		
		//Confirming that the found first resultant lead record is deleted
		WebElement delconfirm = driver.findElement(By.xpath("//div[contains(text(),'No records to display')]"));
		
		System.out.println(delconfirm.getText());
	
		//Closing the Browser
		driver.close();
	}
}
