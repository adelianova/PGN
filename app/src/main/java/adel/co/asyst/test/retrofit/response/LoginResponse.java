package adel.co.asyst.test.retrofit.response;

import adel.co.asyst.test.model.UserModel;

public class LoginResponse {
    String status;
    String message;
    UserModel data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getData() {
        return data;
    }

    public void setData(UserModel data) {
        this.data = data;
    }
}
