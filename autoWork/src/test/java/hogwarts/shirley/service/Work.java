package hogwarts.shirley.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Work {
    private static Work work;
    String token;

    public static Work getInstance() {
        if (work == null) {
            work = new Work();
        }
        return work;
    }


    public String getToken() {
        if (token == null) {
            token = given()
                    .param("corpid", "wwf3e4a736ed988d5c")
                    .param("corpsecret", "FHPeeo6hHTpHQxAFnvKUsiB_RajaNIgW2cVofIwzXXE")
                    .when()
                    .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                    .then()
                    .body("errcode", equalTo(0))
                    .extract()
                    .body().path("access_token");
        }

        return token;
    }
}
