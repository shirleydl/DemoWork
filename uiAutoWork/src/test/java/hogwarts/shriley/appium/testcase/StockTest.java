package hogwarts.shriley.appium.testcase;

import hogwarts.shriley.appium.page.App;
import hogwarts.shriley.appium.page.CombinationTopListPage;
import hogwarts.shriley.appium.page.StockPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockTest {
    public static StockPage stockPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.getInstance().start();
        stockPage = App.getInstance().toStocks();
    }

    @AfterAll
    public static void afterAll() {
        stockPage.toApp();
    }

    @AfterEach
    public void deleteAll() {
        if (stockPage.getAllStocks().size() > 0)
            stockPage.delateAll();
    }

    @Order(100)
    @ParameterizedTest
    @MethodSource("data")
    public void searchToAddFreeStock(String searchName, String name) {
        stockPage.toSearch().search(searchName).addFreeStock().cancel();
        assertThat(stockPage.getAllStocks(), hasItem(name));
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                arguments("pdd", "拼多多"),
                arguments("JD", "京东")
        );
    }

    @Order(200)
    @Test
    public void addCombinationStock() {
        CombinationTopListPage combinationTopListPage = stockPage.toCombinationTopListPage();
        List<String> tops = combinationTopListPage.getAllTops();
        combinationTopListPage.toDetailPage(tops.get(0)).follow().back();
        combinationTopListPage.back();
        assertThat(stockPage.getAllStocks(), hasItem(tops.get(0)));
    }

}
