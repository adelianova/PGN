package adel.co.asyst.test.retrofit.request;

import adel.co.asyst.test.model.PgnModel;

public class PgnRequest {
    String method;
    PgnModel param;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PgnModel getParam() {
        return param;
    }

    public void setParam(PgnModel param) {
        this.param = param;
    }
}
