package hogwarts.shriley.appium.page;

import org.openqa.selenium.By;

public class MessagePage extends BasePage {
    private By addBtn = By.id("com.xueqiu.android:id/action_more");
    private By addFriendBtn = By.id("com.xueqiu.android:id/item_add_friend");
    private By backBtn = By.id("com.xueqiu.android:id/action_back");

    public FindFriendListPage toAddFriend() {
        click(addBtn);
        click(addFriendBtn);
        return new FindFriendListPage();
    }

    public void back() {
        click(backBtn);
    }
}
