package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadAssignment {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Priya");

		// Click on "Find Leads" Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(2000);
		// Click on the First Resulting Lead
		WebElement leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		System.out.println(leadID.getText());
		leadID.click();
		
		//Printing the found "Lead ID"
		//String leadID = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		//System.out.println("Found Lead ID is "+leadID);
		
		// Verify the Title of the Page
		System.out.println(driver.getTitle());

		// Click on the "Edit" Button
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();

		// Change the Company Name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("New Company");

		// Click on "Update" Button
		driver.findElement(By.xpath("//input[@value=\"Update\"]")).click();

		// Confirm that New Company Name Updated
		String cname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Updated Company Name: " + cname);

		// Thread.sleep(2000);
		// Close the Browser
		driver.close();
		
	
	}
}