package hogwarts.shriley.selenium.testcase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;

import hogwarts.shriley.selenium.page.ContactsPage;
import hogwarts.shriley.selenium.page.LoginPage;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 371683941@qq.com
 * @date 2019年12月11日 下午4:29:54
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentTest {
	public static ContactsPage contactsPage;

	@BeforeClass
	public static void beforeAll() {
		contactsPage = new LoginPage().loginWithCookie().toContacts();
	}

	@AfterClass
	public static void afterAll(){
		contactsPage.quit();
	}

	@Before
	public void beforeCase(){
		contactsPage.refresh();
	}

	@Test
	public void addBelongDepartment() {
		String depName = "addDep" + new Date().getTime() / 1000;
		String belongDep = "shirleyTest";
		contactsPage.addDepartment(depName, belongDep).searchDep(depName).searchClear();
//		contactsPage.searchClear().delDepartmentNotChild(depName);
	}

	@Test
	public void delDepartmentNotChild() {
		String depName = "delDep" + new Date().getTime() / 1000;
		String belongDep = "shirleyTest";
		contactsPage.addDepartment(depName, belongDep).delDepartmentNotChild(depName);
	}

	@Test
	public void moveDepartment() {
		String depName = "moveDep" + new Date().getTime() / 1000;
		String belongDep = "shirleyTest";
		contactsPage.addDepartment(depName, belongDep).moveDepartment(depName);
//		contactsPage.delDepartmentNotChild(depName);
	}

	@Test
	public void editDepartment(){
		String depName = "editDep" + new Date().getTime() / 1000;
		String belongDep = "shirleyTest";
		String newDepName = "editDepN" + new Date().getTime() / 1000;
		contactsPage.addDepartment(depName, belongDep).editDepartment(depName, newDepName);
//		contactsPage.delDepartmentNotChild(newDepName);
	}

}
