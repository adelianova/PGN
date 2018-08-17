package adel.co.asyst.test.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PgnModel {
    String customer_name;
    String customer_address;
    String startDate;
    String finishDate;
    String task_id;
    String customer_id;

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public String getTask_id() {
        return task_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
