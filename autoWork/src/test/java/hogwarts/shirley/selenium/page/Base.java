package hogwarts.shirley.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 371683941@qq.com
 * @date 2019年12月11日 下午1:24:37
 */
public class Base {
	protected static WebDriver driver;

	protected static WebDriver choiceDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("pageLoadStrategy", "none");
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	protected WebElement findElement(By by) {
		return findElement(by, 5);
	}

	protected List<WebElement> findElements(By by) {
		return findElements(by, 5);
	}

	protected WebElement findElement(By by, int timeout) {
		if (timeout > 0) {
			waitVisibility(by, timeout);
		}else
			waitPresenceOfElementLocated(by);
		return driver.findElement(by);
	}

	protected List<WebElement> findElements(By by, int timeout) {
		if (timeout > 0) {
			waitVisibility(by, timeout);
		}else
			waitPresenceOfElementLocated(by);
		return driver.findElements(by);
	}

	protected void waitPresenceOfElementLocated(By by) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void waitVisibility(By by, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitInvisibility(By by, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void quit(){
//		Thread.sleep(5000);
		driver.quit();
	}

}
