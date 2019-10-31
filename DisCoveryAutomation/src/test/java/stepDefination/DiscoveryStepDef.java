package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.GenericMethods;
import base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

	// **************Task-2 Scenario************\\

	@Given("^Scroll down to popular shows$")
	public void scroll_down_to_popular_shows() throws Throwable {
		WebElement popularShowTxt = driver.findElement(By.xpath("//h2[@class='popularShowsCarousel__header']"));
		genericMethods.scrollToElementByJS(driver, popularShowTxt);

	}

	@Given("^Go to the last video by pressing the icon >$")
	public void go_to_the_last_video_by_pressing_the_icon() throws Throwable {

		List<WebElement> noOfDots = driver.findElements(By.xpath("//ul[@class='popularShowsCarousel__dotsPager']/li"));
		for (int i = 0; i < noOfDots.size() - 1; i++) {
			// go to last episode
			genericMethods.clickByJS(driver, driver.findElement(By.xpath(
					"//div[@class='carousel__arrowWrapper popularShowsCarousel__controlsProp']//i[@class='icon-arrow-right']")));

		}

	}

	@Then("^click on EXPLORE THE SHOW$")
	public void click_on_EXPLORE_THE_SHOW() throws Throwable {

		WebElement ExploreShow = driver.findElement(
				By.xpath("//a[contains(@href,'/tv-shows/deadliest-catch/')]//button[text()='Explore the Show']"));

		genericMethods.clickByJS(driver, ExploreShow);
	}

	@Then("^User Click on SHOW MORE and you will see the list of shows and again Click on SHOW MORE and few shows will be added$")
	public void user_Click_on_SHOW_MORE_and_you_will_see_the_list_of_shows_and_again_Click_on_SHOW_MORE_and_few_shows_will_be_added()
			throws Throwable {
		WebElement showMoreBtn;
		showMoreBtn = driver.findElement(By.xpath("//button[contains(@class,'episodeList__showMoreButton')]"));

		genericMethods.scrollToElementByJS(driver, showMoreBtn);
		genericMethods.clickByJS(driver, showMoreBtn);
		showMoreBtn = driver.findElement(By.xpath("//button[contains(@class,'episodeList__showMoreButton')]"));

		genericMethods.scrollToElementByJS(driver, showMoreBtn);
		genericMethods.clickByJS(driver, showMoreBtn);

	}

	@Then("^Create a new file and write all the show titles and duration into it\\.$")
	public void create_a_new_file_and_write_all_the_show_titles_and_duration_into_it() throws Throwable {
		List<WebElement> listOfTitle = driver
				.findElements(By.xpath("//div[@class='episodeVideoTile__middle']//p[@class='episodeTitle']"));
		// print all title present in that page

		try {
			PrintWriter pw = new PrintWriter(
					new FileOutputStream(System.getProperty("user.dir") + "/src/test/java/stepDefination/Titles.txt"));
			for (WebElement webElement : listOfTitle) {

				System.out.println("Show Title :" + webElement.getText());

				pw.println(webElement.getText().toString());

			}
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
