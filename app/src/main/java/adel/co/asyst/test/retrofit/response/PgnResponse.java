package adel.co.asyst.test.retrofit.response;

import java.util.ArrayList;

import adel.co.asyst.test.model.PgnModel;

public class PgnResponse {

    String status;
    String message;
    ArrayList<PgnModel> data;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<PgnModel> getData() {
        return data;
    }
}
