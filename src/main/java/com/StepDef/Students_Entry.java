package com.StepDef;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Students_Entry {
	public static WebDriver driver;
	public static String chromePath = "/Users/khosruzzaman/Current_Works/Zsolution_BDD/Drivers/chromedriver";
	public static String url = "file:///Users/khosruzzaman/Current_Works/Zsolution_BDD/CollegeDataBase/Zsolution.html";

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();

	}

	@Given("I am on home page of Zsolution website")
	public void i_am_on_home_page_of_zsolution_website() {
		initialization();
		String tit = driver.getTitle();
		System.out.println("Title is : " + tit);
	}

	@Given("I select Student Manue to see the student page option")
	public void i_select_student_manue_to_see_the_student_page_option() {
		driver.findElement(By.xpath("/html/body/div[1]/button[2]")).click();
		boolean visibleText = driver.findElement(By.xpath("//*[@id='Students']")).isDisplayed();
		System.out.println("Expected student page option is appears : " + visibleText);
		assertTrue(visibleText);

	}

	@When("I click on student button from student option to redirect to the student entry form")
	public void i_click_on_student_button_from_student_option_to_redirect_to_the_student_entry_form() {
		driver.findElement(By.xpath("//*[@id='Students']/button")).click();
		String titles = driver.getTitle();
		System.out.println("Successfully redirected to new Student entry form : " + titles);

	}

	@When("I start adding data for {string}, {string}, {string}, {string} {string}, {string} fields")
	public void i_start_adding_data_for_fields(String groupName, String id, String fName, String lName, String Grd,
			String emails) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='departmentsGroup']")).sendKeys(groupName);
		driver.findElement(By.xpath("//*[@id='id']")).sendKeys(id);
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lName);
		driver.findElement(By.xpath("//*[@id='Grade']")).sendKeys(Grd);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(emails);

		// *[@id='form_data']/input[7]
//		#form_data > input[type=submit]:nth-child(13)
//		document.querySelector("#form_data > input[type=submit]:nth-child(13)")
//		/html/body/form/input[7]
//		
	}

	@When("Click on Insert Value button once entry is completed")
	public void click_on_insert_value_button_once_entry_is_completed() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/form/input[7]")).click();
		Thread.sleep(5000);

	}

	@Then("I am able to see confirmation message")
	public void i_am_able_to_see_confirmation_message() {

		Alert alert = driver.switchTo().alert();
		String getMessageText = alert.getText();
		System.out.println("Success message : " + getMessageText);
		Assert.assertNotEquals("Data Stored successfully!!", "Message not found", getMessageText);
		alert.dismiss();
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
		// driver.quit();
	}

}
