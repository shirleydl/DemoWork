package hogwarts.shirley.service.api;

import io.restassured.response.Response;

import java.util.HashMap;

public class User extends BaseApi {
    public Response get(String userid) {
        HashMap<String, Object> params=new HashMap<>();
        params.put("userid", userid);
        setBodyParams(params);
        return parseSteps();
    }

    public Response create(String userid, HashMap<String, Object> data) {
        data.put("userid", userid);
        setBodyParams(data);
        return parseSteps();
    }

    public Response getDepartmentUsers(String departmentId, String fetchChild) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("department_id", departmentId);
        if (null != fetchChild)
            params.put("fetch_child", fetchChild);
        setBodyParams(params);
        return parseSteps();
    }

    public Response delUsers(String[] useridlist) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("useridlist", useridlist);
        setBodyParams(params);
        return parseSteps();
    }
}
