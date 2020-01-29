package hogwarts.shirley.service.testcase;

import hogwarts.shirley.service.api.Tag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class TestTag {
    static Tag tag = new Tag();

    @BeforeAll
    public static void beforeAll() {

        //数据清理
        ArrayList<Integer> ids = tag.list().then()
                .extract().body().path("taglist.findAll {t-> t.tagid!=0}.tagid");

        ids.forEach(id -> tag.delete(id));

    }

    @Test
    public void list() {
        tag.list().then().body("errmsg", equalTo("ok"));
    }

    @Test
    public void create() {
        String name = "标签2";
        tag.create(name).then().body("errmsg", equalTo("created"));
        tag.list().then().body("taglist.findAll {t->t.tagname=='" + name + "' }.id", hasSize(1));
    }


    @Test
    public void delete() {
        int id = tag.create("标签3").then().body("errmsg", equalTo("created"))
                .extract().body().path("tagid");
        tag.delete(id).then().body("errmsg", equalTo("deleted"));
    }
}
