package hogwarts.shirley.service.testcase;

import hogwarts.shirley.service.Work;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestClassictDepart {
    static String token;
    static int parentDepartId=1;
    @BeforeAll
    public static void getToken() {
        token= Work.getInstance().getToken();
    }

    @Test
    public void departCreate(){
        HashMap<String, Object> data=new HashMap<>();
        data.put("name", "shirley");
        data.put("parentid", parentDepartId);

        given()
                .queryParam("access_token", token)
                .contentType(ContentType.JSON)
                .body(data)
        .when().log().all()
                .post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
        .then().log().all()
                .body("errcode", equalTo(0));

    }

    @Test
    public void departList(){
        given()
                .queryParam("access_token", token)
                .queryParam("id", parentDepartId)
        .when().log().all()
                .get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
        .then().log().all()
                .body("errcode", equalTo(0));

    }
}
