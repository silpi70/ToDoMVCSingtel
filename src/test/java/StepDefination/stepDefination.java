package StepDefination;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class stepDefination {
	WebDriver driver;
	WebElement textBox;
	
	 @Given("navigate to the given URL in a Browser")
	  public void open_the_given_url_in_a_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\SILPI\\OneDrive\\Desktop\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://todomvc.com/examples/vue/");
	  }
	
	 @When("add the item {string} to the list")
	 public void add_the_item_to_the_list(String items) {
		 textBox = driver.findElement(By.className("new-todo"));
		 textBox.sendKeys(items);
		 textBox.sendKeys(Keys.ENTER);
	 }

	 @Then("check the added item {string}")
	 public void check_the_added_item(String expectedItem) {
		 try {
		      WebElement e =
		          driver.findElement(
		              By.xpath(
		                  "//div[@class='view']//label[contains(text(),'"
		                      + expectedItem
		                      + "')]//preceding-sibling::input[1]"));
		      e.click();
		    } catch (StaleElementReferenceException exp) {
		      Assert.assertFalse(false);
		      driver.quit();
		    }
		    Assert.assertTrue(true);
		   driver.quit();
		 
	 }	
	
	 @Then("mark the added item {string} completed")
	 public void mark_the_added_item_completed(String item) {
	     
		 try {
		      WebElement e =
		          driver.findElement(
		              By.xpath(
		                  "//div[@class='view']//label[contains(text(),'"
		                      + item
		                      + "')]//preceding-sibling::input[1]"));
		      e.click();
		    } catch (StaleElementReferenceException exp) {
		      Assert.assertFalse(false);
		      driver.quit();
		    }
		    Assert.assertTrue(true);
		    driver.quit();
	 }

	 @When("add the item {string},{string} to the list")
	 public void add_the_item_to_the_list(String item1, String item2) {
		 textBox = driver.findElement(By.className("new-todo"));
		 textBox.sendKeys(item1);
		 textBox.sendKeys(Keys.ENTER);
		 textBox.sendKeys(item2);
		 textBox.sendKeys(Keys.ENTER);
	     
	 }

	 @Then("get the count of {string} added")
	 public void get_the_count_of_added(String string) {
		 List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo']"));
		    System.out.println(we.size());
		    int count = we.size();
		    Iterator<WebElement> list = we.iterator();
		    while (list.hasNext()) {
		      WebElement val = list.next();
		      System.out.println(val.getText());
		    }
		    Assert.assertEquals(2, count);
		    driver.quit();
	 }

	 @Then("select the completed {string}")
	 public void select_the_completed(String items) {
		 WebElement e =
			        driver.findElement(
			            By.xpath(
			                "//div[@class='view']//label[contains(text(),'"
			                    + items
			                    + "')]//preceding-sibling::input[1]"));
			    e.click();
			    List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo completed']"));
			    System.out.println(we.size());
			    int count = we.size();
			    Iterator<WebElement> list = we.iterator();
			    while (list.hasNext()) {
			      WebElement val = list.next();
			      System.out.println(val.getText());
			    }
			    Assert.assertEquals(1, count);
			    driver.quit();
	 }

	 @Then("delete the item added {string}")
	 public void delete_the_item_added(String item1) {
		 WebElement myElement = driver.findElement(By.xpath("//div[@class='view']//label[contains(text(),'" + item1 + "')]//following-sibling::button[@class='destroy']"));
		    JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();", myElement);
		    List<WebElement> we = driver.findElements(By.xpath("//*[@class='todo']"));
		    System.out.println(we.size());
		    int count = we.size();
		    Assert.assertEquals(0, count);
		    driver.quit();
	 }
	
}
