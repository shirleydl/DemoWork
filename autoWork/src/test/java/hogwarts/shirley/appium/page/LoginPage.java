package hogwarts.shirley.appium.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By accountInput = By.id("com.xueqiu.android:id/login_account");
    private By pwdInput = By.id("com.xueqiu.android:id/login_password");
    private By confirmBtn = By.id("com.xueqiu.android:id/button_next");
    private By contentText = By.id("com.xueqiu.android:id/md_content");
    private By defaultPositiveBtn = By.id("com.xueqiu.android:id/md_buttonDefaultPositive");
    private By closeBtn = By.id("com.xueqiu.android:id/iv_action_back");
    private By changeToLoginByCodeBtn = By.id("com.xueqiu.android:id/login_without_password");
    private By loginPhone = By.id("com.xueqiu.android:id/register_phone_number");
    private By loginCode = By.id("com.xueqiu.android:id/register_code");

    public LoginPage loginByPwd(String account, String pwd) {
        findElement(accountInput).clear();
        findElement(pwdInput).clear();
        findElement(accountInput).sendKeys(account);
        findElement(pwdInput).sendKeys(pwd);
        click(confirmBtn);
        return this;
    }

    public LoginPage changeToLoginByCode() {
        click(changeToLoginByCodeBtn);
        return this;
    }

    public LoginPage loginByCode(String phone, String code) {
        findElement(loginPhone).clear();
        findElement(loginCode).clear();
        findElement(loginPhone).sendKeys(phone);
        findElement(loginCode).sendKeys(code);
        click(confirmBtn);
        return this;
    }

    public String getContent() {
        String content = findElement(contentText).getText();
        click(defaultPositiveBtn);
        return content;
    }

    public void close() {
        click(closeBtn);
    }

    public App toApp() {
        click(By.xpath("//*[contains(@resource-id, 'tab_name') and @text='雪球']"));
        return new App();
    }
}
