package adel.co.asyst.test.retrofit.request;

import adel.co.asyst.test.model.LoginModel;

public class LoginRequest {

    String method;
    LoginModel param;

    public String getMethod() {
        return method;
    }

    public LoginModel getParam() {
        return param;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam(LoginModel param) {
        this.param = param;
    }
}
