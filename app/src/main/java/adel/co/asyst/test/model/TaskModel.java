package adel.co.asyst.test.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TaskModel implements Parcelable {
    public static final Creator<TaskModel> CREATOR = new Creator<TaskModel>() {
        @Override
        public TaskModel createFromParcel(Parcel in) {
            return new TaskModel(in);
        }

        @Override
        public TaskModel[] newArray(int size) {
            return new TaskModel[size];
        }
    };
    String task_id;
    String customer_id;
    String customer_name;
    String customer_address;
    String startDate;
    String finishDate;

    protected TaskModel(Parcel in) {
        task_id = in.readString();
        customer_id = in.readString();
        customer_name = in.readString();
        customer_address = in.readString();
        startDate = in.readString();
        finishDate = in.readString();
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(task_id);
        dest.writeString(customer_id);
        dest.writeString(customer_name);
        dest.writeString(customer_address);
        dest.writeString(startDate);
        dest.writeString(finishDate);
    }
}
