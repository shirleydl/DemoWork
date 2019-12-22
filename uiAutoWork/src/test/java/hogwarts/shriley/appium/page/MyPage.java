package hogwarts.shriley.appium.page;

import org.openqa.selenium.By;

public class MyPage extends BasePage {
    private By toLoginByPwdBtn = By.xpath("//*[@text='帐号密码登录']");

    public LoginPage toLogin() {
        click(toLoginByPwdBtn);
        return new LoginPage();
    }
}
