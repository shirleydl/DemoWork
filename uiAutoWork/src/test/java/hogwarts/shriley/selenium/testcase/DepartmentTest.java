package hogwarts.shriley.selenium.testcase;

import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;

import hogwarts.shriley.selenium.page.ContactsPage;
import hogwarts.shriley.selenium.page.LoginPage;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.hasItem;


/**
 * @author 371683941@qq.com
 * @Description: TODO(这里用一句话描述这个类的作用)
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
    public static void afterAll() {
        contactsPage.quit();
    }

    @Before
    public void beforeCase() {
        contactsPage.refresh();
    }

    @Test
    public void addBelongDepartment() {
        String depName = "addDep" + System.currentTimeMillis() / 1000;
        String belongDep = "shirleyTest";
        List<String> departments = contactsPage.addDepartment(depName, belongDep).searchDep(depName).getDepartmentList();
        assertThat(departments, hasItem(depName));
//		contactsPage.searchClear().delDepartmentNotChild(depName);
    }

    @Test
    public void delDepartmentNotChild() {
        String depName = "delDep" + System.currentTimeMillis() / 1000;
        String belongDep = "shirleyTest";
        contactsPage.addDepartment(depName, belongDep).delDepartmentNotChild(depName);
    }

    @Test
    public void moveDepartment() {
        String depName = "moveDep" + System.currentTimeMillis() / 1000;
        String belongDep = "shirleyTest";
        contactsPage.addDepartment(depName, belongDep).moveDepartment(depName);
//		contactsPage.delDepartmentNotChild(depName);
    }

    @Test
    public void editDepartment() {
        String depName = "editDep" + System.currentTimeMillis() / 1000;
        String belongDep = "shirleyTest";
        String newDepName = "editDepN" + System.currentTimeMillis() / 1000;
        List<String> departments = contactsPage.addDepartment(depName, belongDep).editDepartment(depName, newDepName).searchDep(newDepName).getDepartmentList();
        assertThat(departments, hasItem(newDepName));
//		contactsPage.searchClear().delDepartmentNotChild(newDepName);
    }

}
