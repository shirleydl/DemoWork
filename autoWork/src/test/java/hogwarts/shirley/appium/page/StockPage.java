package hogwarts.shirley.appium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class StockPage extends BasePage {
    private By stockNameText = By.id("com.xueqiu.android:id/portfolio_stockName");
    private By searchBtn = By.id("com.xueqiu.android:id/action_search");
    private By editBtn = By.id("com.xueqiu.android:id/edit_group");
    private By checkAll = By.id("com.xueqiu.android:id/check_all");
    private By cancelFollowBtn = By.id("com.xueqiu.android:id/cancel_follow");
    private By defaultPositiveBtn = By.id("com.xueqiu.android:id/md_buttonDefaultPositive");
    private By editCloseBtn = By.id("com.xueqiu.android:id/action_close");
    private By changeViewBtn = By.id("com.xueqiu.android:id/title_img_right");
    private By toCombinationTopBtn = By.id("com.xueqiu.android:id/extend_page_entrance");


    public List<String> getAllStocks() {
        List<String> stocks = new ArrayList<>();
        findElements(stockNameText).forEach(element -> {
            stocks.add(element.getText());
        });
        return stocks;
    }

    public SearchPage toSearch() {
        click(searchBtn);
        return new SearchPage();
    }

    public StockPage delateAll() {
        click(editBtn);
        click(checkAll);
        click(cancelFollowBtn);
        click(defaultPositiveBtn);
        click(editCloseBtn);
        return this;
    }

    public CombinationTopListPage toCombinationTopListPage() {
        changeView("Combination");
        click(toCombinationTopBtn);
        return new CombinationTopListPage();
    }

    public App toApp() {
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='雪球']"));
        return new App();
    }

    private void changeView(String viewName) {
        click(changeViewBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("Combination".equals(viewName)) {
            combination();
        }
    }

    private void combination() {
        Dimension size = driver.manage().window().getSize();
        new TouchAction(driver).tap(PointOption.point((int) (size.width * 0.85), (int) (size.height * 0.15))).perform();
    }


}
