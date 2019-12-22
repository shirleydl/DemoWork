package hogwarts.shriley.appium.testcase;

import hogwarts.shriley.appium.page.App;
import hogwarts.shriley.appium.page.FindFriendListPage;

import hogwarts.shriley.appium.page.MessagePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;


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
