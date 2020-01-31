package hogwarts.shirley.service.api;

import java.util.Map;

public class ApiObjectModel {
    private Map<String, ApiObjectMethodModel> methods;

    public Map<String, ApiObjectMethodModel> getMethods() {
        return methods;
    }

    public void setMethods(Map<String, ApiObjectMethodModel> methods) {
        this.methods = methods;
    }
}
