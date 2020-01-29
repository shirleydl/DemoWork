package hogwarts.shirley.appium.testcase;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.Arrays;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import hogwarts.shirley.appium.page.App;
import hogwarts.shirley.appium.page.LoginPage;
import hogwarts.shirley.appium.testcase.entity.LoginTestEntityList;
import hogwarts.shirley.appium.testcase.entity.LoginTestEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    public static LoginPage loginPage;
    public static LoginTestEntityList loginTestEntityList;

	public static LoginTestEntityList readLoginData(){
		ObjectMapper mapper=new ObjectMapper(new YAMLFactory());
		String path="/"+LoginTest.class.getCanonicalName().replace('.', '/')+".yaml";
		try {
			loginTestEntityList = mapper.readValue(LoginTest.class.getResourceAsStream(path), LoginTestEntityList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loginTestEntityList;
	}

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        App.getInstance().start();
        loginPage = App.getInstance().toMy().toLogin();
		loginTestEntityList=readLoginData();

    }

    @AfterAll
    public static void afterAll() {
        loginPage.close();
        loginPage.toApp();
    }

    @Order(100)
    @ParameterizedTest
    @MethodSource("loginByPwdData")
    public void loginByPwdContent(LoginTestEntity loginTestEntity) {
        assertThat(loginPage.loginByPwd(loginTestEntity.getAccount(), loginTestEntity.getPwd()).getContent(), equalTo(loginTestEntity.getContent()));
    }

    public static Stream<LoginTestEntity> loginByPwdData() {
		return (null!=loginTestEntityList)?loginTestEntityList.getLoginByPwdData().stream():null;
    }

    @Order(200)
    @ParameterizedTest
    @MethodSource("loginByCodeData")
    public void loginByCodeContent(LoginTestEntity loginTestEntity) {
        assertThat(loginPage.changeToLoginByCode().loginByCode(loginTestEntity.getPhone(), loginTestEntity.getCode()).getContent(),in(Arrays.asList(loginTestEntity.getContents())));

    }

	public static Stream<LoginTestEntity> loginByCodeData() {
		return (null!=loginTestEntityList)?loginTestEntityList.getLoginByCodeData().stream():null;
	}

//    public static Stream<Arguments> loginByCodeData() {
//        return Stream.of(
//                arguments("13610000000", "1234", "验证码错误")
//        );
//    }



}
