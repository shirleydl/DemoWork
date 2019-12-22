package hogwarts.shriley.appium.testcase;

import hogwarts.shriley.appium.page.App;
import hogwarts.shriley.appium.page.SearchPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest {
    public static SearchPage searchPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.getInstance().start();
        searchPage = App.getInstance().toSearch();
    }

    @AfterAll
    public static void afterAll() {
        searchPage.cancel();
    }

    @Test
    public void search() {
        searchPage.search("alibaba");
        assertThat(searchPage.getCurrentName(), equalTo("阿里巴巴"));
    }
}
