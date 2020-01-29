package hogwarts.shirley.service.api;

import hogwarts.shirley.service.Work;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Tag {
    public Response list() {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/list")
                .then()
                .extract().response();
    }

    public Response create(String tagName, int tagId) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagName);
        data.put("tagid", tagId);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
                .then()
                .extract().response();
    }

    public Response create(String tagName) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagName);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/create")
                .then()
                .extract().response();
    }

    public Response update(String tagName, int tagId) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("tagname", tagName);
        data.put("tagid", tagId);

        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/tag/update")
                .then()
                .extract().response();
    }

    public Response delete(int id) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("tagid", id)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/tag/delete")
                .then()
                .extract().response();
    }
}
