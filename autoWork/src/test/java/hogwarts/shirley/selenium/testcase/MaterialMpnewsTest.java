package hogwarts.shirley.selenium.testcase;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hogwarts.shirley.selenium.page.LoginPage;
import hogwarts.shirley.selenium.page.MaterialPage;

/**
 * @author 371683941@qq.com
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年12月12日 下午1:15:15
 */
public class MaterialMpnewsTest {
    public static MaterialPage materialPage;

    @BeforeClass
    public static void beforeAll() {
        materialPage = new LoginPage().loginWithCookie().toManageTools().toMaterial();
    }

    @AfterClass
    public static void afterAll() {
        materialPage.quit();
    }

    @Before
    public void beforeCase() {
        materialPage.refresh();
    }

    @Test
    public void addMaterialMpnews() throws InterruptedException {
        materialPage.addMpnews("title" + System.currentTimeMillis() / 1000, "content", MaterialMpnewsTest.class.getResource("/favicon.png").getPath());
    }

}
