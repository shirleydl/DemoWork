package hogwarts.shirley.appium.testcase;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import hogwarts.shirley.appium.page.App;
import hogwarts.shirley.appium.page.FindFriendListPage;
import hogwarts.shirley.appium.page.MessagePage;


public class FriendTest {
    public static FindFriendListPage findFriendListPage;
    public static MessagePage messagePage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.getInstance().start();
        messagePage = App.getInstance().toMessage();
        findFriendListPage = messagePage.toAddFriend();
    }

    @AfterAll
    public static void afterAll() {
        findFriendListPage.back();
        messagePage.back();
    }

    @Test
    public void follow() {
        findFriendListPage.followListFriend();
    }
}
