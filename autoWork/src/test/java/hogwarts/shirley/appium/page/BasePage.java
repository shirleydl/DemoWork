package hogwarts.shirley.appium.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    protected static AndroidDriver<WebElement> driver;
    private static int sumTimes = 3;
    private static int execution = sumTimes;

    public WebElement findElement(By by) {
        try {
            return driver.findElement(by);
        } catch (Exception e) {
            handleAlert();
            if (execution > 0) {
                execution--;
                return findElement(by);
            } else {
                execution = sumTimes;
                return driver.findElement(by);
            }
        }
    }

    public List<WebElement> findElements(By by) {
        try {
            return driver.findElements(by);
        } catch (Exception e) {
            handleAlert();
            if (execution > 0) {
                execution--;
                return findElements(by);
            } else {
                execution = sumTimes;
                return driver.findElements(by);
            }
        }
    }

    public static void click(By by) {
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            handleAlert();
            if (execution > 0) {
                execution--;
                click(by);
            } else {
                execution = sumTimes;
                driver.findElement(by).click();
            }
        }
    }

    private static void handleAlert() {
//        By tips = By.id("com.xueqiu.android:id/snb_tip_text");
        By tips = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[1]");
        By tips2 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView");

        List<By> alertBoxs = new ArrayList<>();
        alertBoxs.add(By.id("com.xueqiu.android:id/image_cancel"));
        alertBoxs.add(By.id("com.xueqiu.android:id/ib_close"));
        alertBoxs.add(By.id("com.xueqiu.android:id/md_buttonDefaultNegative"));
        alertBoxs.add(tips);
        alertBoxs.add(tips2);


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        alertBoxs.forEach(alert -> {
            List<WebElement> ads = driver.findElements(alert);
            if (ads.size() > 0) {
                ads.get(0).click();
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                return;
            }
        });
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}
