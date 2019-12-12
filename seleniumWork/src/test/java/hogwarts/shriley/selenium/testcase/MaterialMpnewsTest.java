package hogwarts.shriley.selenium.testcase;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hogwarts.shriley.selenium.page.LoginPage;
import hogwarts.shriley.selenium.page.MaterialPage;

/**
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 371683941@qq.com
* @date 2019年12月12日 下午1:15:15
*/
public class MaterialMpnewsTest {
	public static MaterialPage materialPage;
	
	@BeforeClass
	public static void beforeAll() {
		materialPage = new LoginPage().loginWithCookie().toManageTools().toMaterial();
	}

	@AfterClass
	public static void afterAll() throws InterruptedException {
//		materialPage.quit();
	}

	@Before
	public void beforeCase() {
		materialPage.refresh();
	}
	
	@Test
	public void addMaterialMpnews() throws InterruptedException {
		materialPage.addMpnews("title"+new Date().getTime()/1000, "content",MaterialMpnewsTest.class.getResource("/favicon.png").getPath());
	}

}
