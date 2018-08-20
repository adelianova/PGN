package adel.co.asyst.test.retrofit.response;

import java.util.ArrayList;

import adel.co.asyst.test.model.TaskModel;

public class PgnResponse {

    String status;
    String message;
    ArrayList<TaskModel> data;

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

    public ArrayList<TaskModel> getData() {
        return data;
    }

    public void setData(ArrayList<TaskModel> data) {
        this.data = data;
    }
}
