package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {

	public static String getOS() {
		String osType = null;
		String osName = System.getProperty("os.name");
		String osNameMatch = osName.toLowerCase();
		if (osNameMatch.contains("linux")) {
			osType = "OS_LINUX";
		} else if (osNameMatch.contains("windows")) {
			osType = "OS_WINDOWS";
		} else if (osNameMatch.contains("solaris") || osNameMatch.contains("sunos")) {
			osType = "OS_SOLARIS";
		} else if (osNameMatch.contains("mac os") || osNameMatch.contains("macos") || osNameMatch.contains("darwin")) {
			osType = "OS_MAC";
		} else {
			osType = "Unknown";
		}
		return osType;
	}

	public void clickByJS(WebDriver driver, WebElement ele) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElementByJS(WebDriver driver, WebElement ele) throws Exception {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView();", ele);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void scrollTillDown(WebDriver driver) throws Exception {
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
