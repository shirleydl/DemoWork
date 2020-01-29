package hogwarts.shirley.appium.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

public class CombinationTopListPage extends BasePage {
    private By titleText = By.id("com.xueqiu.android:id/top_list_item_title");
    private By backBtn = By.id("com.xueqiu.android:id/top_list_action_bar_back");

    public List<String> getAllTops() {
        List<String> tops = new ArrayList<>();
        findElements(titleText).forEach(element -> {
            tops.add(element.getText());
        });
        return tops;
    }

    public CombinationDetailPage toDetailPage(String name) {
        click(By.xpath("//*[contains(@resource-id, 'top_list_item_title') and @text='" + name + "']"));
        return new CombinationDetailPage();
    }

    public void back() {
        click(backBtn);
    }
}
