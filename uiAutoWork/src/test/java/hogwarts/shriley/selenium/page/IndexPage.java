package hogwarts.shriley.selenium.page;

import org.openqa.selenium.By;

/**
 * @author 371683941@qq.com
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2019年12月11日 下午1:42:15
 */
public class IndexPage extends Base {

    public ContactsPage toContacts() {
        findElement(By.linkText("通讯录")).click();
        return new ContactsPage();
    }

    public manageToolsPage toManageTools() {
        findElement(By.linkText("管理工具")).click();
        return new manageToolsPage();
    }
}
