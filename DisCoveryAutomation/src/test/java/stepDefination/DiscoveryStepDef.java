package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.GenericMethods;
import base.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class DiscoveryStepDef extends TestBase {
	WebDriver driver;
	GenericMethods genericMethods;
	Actions actions;
	WebDriverWait wait;
	List<String> listOfTitle;

	public DiscoveryStepDef() throws IOException {
		super();

	}

	@Before
	public void setUp() throws InterruptedException, IOException {
		TestBase testBase = new TestBase();
		genericMethods = new GenericMethods();
		driver = testBase.initialization();
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.quit();
		driver = null;
	}

	@Given("^User navigates to discovery go website$")
	public void user_navigates_to_discovery_go_website() throws Throwable {
		driver.get("https://go.discovery.com");

	}

	@Given("^User clicks on the Select See All Shows available in Shows tab$")
	public void user_clicks_on_the_Select_See_All_Shows_available_in_Shows_tab() throws Throwable {
		driver.findElement(By.xpath("//span[contains(text(),'Shows')]")).click();
		WebElement allShowLink = driver.findElement(By.xpath(
				"//div[@id='show-drop-desktop']//a[@class='dscShowsDropContent__seeAllShows'][contains(text(),'See All Shows')]"));
		genericMethods.scrollToElementByJS(driver, allShowLink);
		genericMethods.clickByJS(driver, allShowLink);

	}

	@Given("^User click on select the shows which contain APOLLO$")
	public void user_click_on_select_the_shows_which_contain_APOLLO() throws Throwable {
		genericMethods.scrollTillDown(driver);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[contains(@href,'-apollo')]//picture//img")));
		WebElement appoloshow = driver.findElement(By.xpath("//a[contains(@href,'-apollo')]//picture//img"));
		genericMethods.scrollToElementByJS(driver, appoloshow);
		genericMethods.clickByJS(driver, appoloshow);

	}

	@Then("^Verify the Favorites icon status\\.$")
	public void verify_the_Favorites_icon_status() throws Throwable {
		List<WebElement> fabsBtn = driver.findElements(By.xpath("//div[@class='episodeVideoTile__right']//button"));
		for (WebElement plusBtn : fabsBtn) {
			genericMethods.scrollToElementByJS(driver, plusBtn);
			genericMethods.clickByJS(driver, plusBtn);
		}

	}

	@Then("^Store all the favorite or unfavorite done titles in list\\.$")
	public void store_all_the_favorite_or_unfavorite_done_titles_in_list() throws Throwable {
		List<WebElement> episodeTitles = driver
				.findElements(By.xpath("//div[@class='episodeVideoTile__middle']//p[@class='episodeTitle']"));
		listOfTitle = new ArrayList<String>();
		for (WebElement title : episodeTitles) {

			listOfTitle.add(title.getText());
			System.out.println(title.getText());
		}

	}

	@Then("^Once favorite or unfavorite is done, goto My Videos\\.$")
	public void once_favorite_or_unfavorite_is_done_goto_My_Videos() throws Throwable {
		driver.findElement(By
				.xpath("//li[contains(@class,'dscHeaderMain__hideMobile')]//*[contains(@class,'dscHeaderMain__iconMenu')]"))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'My Videos')]/parent::a")).click();

	}

	@Then("^Validate the favorite or unfavorite titles under FAVORITE SHOWS”$")
	public void validate_the_favorite_or_unfavorite_titles_under_FAVORITE_SHOWS() throws Throwable {
		List<String> fabListtitles = new ArrayList<String>();
		List<WebElement> fabTitles = driver
				.findElements(By.xpath("//a[contains(@href,'apollo')]//div[@class='thumbnailTile__titleLineClamp']"));
		for (WebElement fab_title : fabTitles) {
			genericMethods.scrollToElementByJS(driver, fab_title);
			fabListtitles.add(fab_title.getText());

			if (listOfTitle.retainAll(fabListtitles)) {
				System.out.println("Validation sucessfully");
			}

		}
	}

}
