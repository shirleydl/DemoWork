package hogwarts.shriley.appium.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App extends BasePage {
    private static App app;

    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    public void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("deviceName", "1");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("dontStopAppOnReset", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        new WebDriverWait(driver, 30).until(x -> {
            String pageSource = driver.getPageSource();
            return (pageSource.contains("home_search") || pageSource.contains("image_cancel"));
        });
    }

    public SearchPage toSearch() {
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage();
    }

    public StockPage toStocks() {
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='行情']"));
        return new StockPage();
    }

    public MessagePage toMessage() {
        click(By.id("com.xueqiu.android:id/action_message"));
        return new MessagePage();
    }

    public MyPage toMy() {
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='我的']"));
        return new MyPage();
    }
}
