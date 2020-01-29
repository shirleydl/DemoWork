package hogwarts.shirley.appium.page;

import org.openqa.selenium.By;

public class CombinationDetailPage extends BasePage {
    private By follow = By.id("com.xueqiu.android:id/follow_btn");
    private By defaultNegative = By.id("com.xueqiu.android:id/md_buttonDefaultNegative");
    private By back = By.id("com.xueqiu.android:id/rl_action_back");

    public CombinationDetailPage follow() {
        click(follow);
        click(defaultNegative);
        return this;
    }

    public void back() {
        click(back);
    }
}
