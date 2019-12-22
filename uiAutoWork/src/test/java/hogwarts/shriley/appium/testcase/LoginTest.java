package hogwarts.shriley.appium.testcase;

import hogwarts.shriley.appium.page.App;
import hogwarts.shriley.appium.page.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    public static LoginPage loginPage;

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.getInstance().start();
        loginPage = App.getInstance().toMy().toLogin();
    }

    @AfterAll
    public static void afterAll() {
        loginPage.close();
        loginPage.toApp();
    }

    @Order(100)
    @ParameterizedTest
    @MethodSource("loginByPwdData")
    public void loginByPwdContent(String account, String pwd, String content) {
        assertThat(loginPage.loginByPwd(account, pwd).getContent(), equalTo(content));
    }

    public static Stream<Arguments> loginByPwdData() {
        return Stream.of(
                arguments("13610000000", "123456", "用户名或密码错误"),
                arguments("1", "123456", "手机号码填写错误"),
                arguments("", "123456", "手机号不能为空")
        );
    }

    @Order(200)
    @ParameterizedTest
    @MethodSource("loginByCodeData")
    public void loginByCodeContent(String phone, String code, String content) {
        assertThat(loginPage.changeToLoginByCode().loginByCode(phone, code).getContent(), equalTo(content));

    }

    public static Stream<Arguments> loginByCodeData() {
        return Stream.of(
                arguments("13610000000", "1234", "验证码错误")
        );
    }
}
