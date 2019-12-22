package hogwarts.shriley.appium.page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class FindFriendListPage extends BasePage {
    private By screenNameText = By.id("com.xueqiu.android:id/screen_name");
    private By searchInput = By.id("com.xueqiu.android:id/input_text");
    private By followBtn = By.id("com.xueqiu.android:id/follow_btn");
    private By defaultPositiveBtn = By.id("com.xueqiu.android:id/md_buttonDefaultPositive");
    private By backBtn = By.xpath("//*[@content-desc='转到上一层级']");

    public List<String> getAllHotFriends() {
        List<String> friends = new ArrayList<>();
        findElements(screenNameText).forEach(element -> {
            friends.add(element.getText());
        });
        return friends;
    }

    public FindFriendListPage search(String keyword) {
        findElements(searchInput).clear();
        findElement(searchInput).sendKeys(keyword);
        return this;
    }

    public FindFriendListPage followListFriend() {
        click(followBtn);
        click(defaultPositiveBtn);
        return this;
    }

    public void back() {
        click(backBtn);
    }
}
