package hogwarts.shirley.service.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hogwarts.shirley.appium.testcase.LoginTest;
import hogwarts.shirley.appium.testcase.entity.LoginTestEntityList;
import hogwarts.shirley.service.api.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestUser {
    @Test
    public void getDepartmentUsers() {
        User user = new User();
        user.getDepartmentUsers("1", null).then().body("errcode", equalTo(0));
    }

    @Test
    public void delUsers() {
        User user = new User();
        user.delUsers(new String[]{"Shirley"}).then().body("errcode", equalTo(0));
    }

    @Test
    public void get() {
        User user = new User();
        user.get("Shirley").then().body("errcode", equalTo(0));
    }

    @ParameterizedTest
    @MethodSource("loadUserInfo")
    public void create(String id, String name,List<Integer> departs) {
        String nameNew = name;
        String userid = id + System.currentTimeMillis();
        if(departs==null){
            departs= Arrays.asList(1);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", nameNew);
        data.put("department",departs);
        data.put("mobile", String.valueOf(System.currentTimeMillis()).substring(0, 11));
        data.put("address", "address for testing");

        User user = new User();
        user.create(userid, data).then().body("errcode", equalTo(0));

        user.get(userid).then().body("name", equalTo(nameNew));
    }

    public static Stream<Arguments> loadUserInfo() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //生成一个代表List<HashMap>的类型，用于传递给readValue
        TypeReference<List<Map<String, Object>>> typeRef =
                new TypeReference<List<Map<String, Object>>>() {
                };
        List<Map<String, Object>> data;
        try {
            data = mapper.readValue(TestUser.class.getResourceAsStream("TestUser.yaml"), typeRef);
            List<Arguments> results = new ArrayList<>();
            data.forEach(map -> {
                results.add(arguments(
                        map.get("userid").toString(),
                        map.get("name").toString(),
                        map.get("departs")

                ));
            });

            return results.stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of();

    }
}
