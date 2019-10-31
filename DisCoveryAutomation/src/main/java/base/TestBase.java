package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.GenericMethods;

/**
 * @author samarendra
 *
 */
public class TestBase {

	public WebDriver driver;
	public static Properties prop;

	// Load properties file
	public TestBase() throws IOException {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initialization() {
		// String browserName = prop.getProperty("browser");
		String browserName = "chrome";

		if (browserName.equals("chrome")) {
			// for mac
			if (GenericMethods.getOS().contains("OS_MAC")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/java/driver/mac_chromedriver");
			} // for linux
			else if (GenericMethods.getOS().contains("OS_LINUX")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/java/driver/linux_chromedriver");
			} // for windows
			else if (GenericMethods.getOS().contains("OS_WINDOWS")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/java/driver/window_chromedriver.exe");
			}

			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;

		// driver.get(prop.getProperty("appUrl"));

	}

}
