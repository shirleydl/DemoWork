package hogwarts.shriley.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

/**
 * Hello world!
 */
public class LoginPage extends Base {
    public IndexPage loginWithCookie() {
        String sid = "you cookie";
        return loginWithCookie(sid);
    }

    public IndexPage loginWithCookie(String sid) {
        String url = "https://work.weixin.qq.com/";
        driver = choiceDriver();
        driver.get(url);
        driver.manage().window().maximize();
        findElement(By.linkText("企业登录")).click();
        driver.manage().addCookie(new Cookie("wwrtx.sid", sid));
        refresh();
        return new IndexPage();
    }

}
