package hogwarts.shirley.appium.page;

import org.openqa.selenium.By;

public class SearchPage extends BasePage {
    private By searchInput = By.id("com.xueqiu.android:id/search_input_text");
    private By searchStockNameText = By.id("com.xueqiu.android:id/name");
    private By currentStockNameText = By.id("com.xueqiu.android:id/stockName");
    private By currentStockPriceText = By.id("com.xueqiu.android:id/current_price");
    private By followFreeStockBtn = By.id("com.xueqiu.android:id/follow_btn");
    private By cancelBtn = By.id("com.xueqiu.android:id/action_close");

    public SearchPage search(String keyword) {
        findElement(searchInput).sendKeys(keyword);
        try {
            driver.findElement(searchStockNameText);
        } catch (Exception e) {
            findElement(searchInput).clear();
            findElement(searchInput).sendKeys(keyword);
        }
        click(searchStockNameText);
        return this;
    }

    public String getCurrentName() {
        return findElement(currentStockNameText).getText();
    }

    public Float getCurrentPrice() {
        return Float.valueOf(findElement(currentStockPriceText).getText());
    }

    public SearchPage addFreeStock() {
        click(followFreeStockBtn);
        return this;
    }

    public App cancel() {
        click(cancelBtn);
        return new App();
    }


}
