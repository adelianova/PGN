package adel.co.asyst.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import adel.co.asyst.test.R;
import adel.co.asyst.test.model.TaskModel;
import adel.co.asyst.test.utility.DateUtils;

public class PgnAdapter extends RecyclerView.Adapter<PgnAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<TaskModel> mListpgn;
    onItemClickListener mListener;

    public PgnAdapter(Context context, ArrayList<TaskModel> listTask, onItemClickListener listener) {
        this.mContext = context;
        this.mListpgn = listTask;
        this.mListener = listener;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new PgnAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TaskModel taskModel = mListpgn.get(position);

        holder.taskidtv.setText(taskModel.getTask_id());
        holder.customeridtv.setText("#" + taskModel.getCustomer_id());
        holder.nametv.setText(taskModel.getCustomer_name());
        holder.locationtv.setText(taskModel.getCustomer_address());
        holder.starttv.setText(taskModel.getStartDate());
        holder.starttv.setText(DateUtils.formatDate("yyyy-MM-dd", "EEEE, dd MMMM yyyy", taskModel.getStartDate()));
        if (taskModel.getFinishDate() == null) {
            holder.finishtv.setVisibility(View.GONE);
        } else {
            holder.finishtv.setVisibility(View.VISIBLE);
            holder.finishtv.setText("Selesai " + DateUtils.formatDate("yyyy-MM-dd", "dd MMMM yyyy", taskModel.getFinishDate()));
        }
        holder.taskCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClickListener(taskModel);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mListpgn.size();
    }

    public interface onItemClickListener {
        void onItemClickListener(TaskModel taskModel);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametv, locationtv, starttv, finishtv, customeridtv, taskidtv;
        CardView taskCardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            taskidtv = itemView.findViewById(R.id.text_view_task_id);
            customeridtv = itemView.findViewById(R.id.text_view_customer_id);
            nametv = itemView.findViewById(R.id.text_view_name);
            locationtv = itemView.findViewById(R.id.text_view_location);
            starttv = itemView.findViewById(R.id.text_view_start);
            finishtv = itemView.findViewById(R.id.text_view_finish);
            taskCardView = itemView.findViewById(R.id.cardView);
        }
    }
}
