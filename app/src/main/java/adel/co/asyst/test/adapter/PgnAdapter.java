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
import adel.co.asyst.test.model.PgnModel;

public class PgnAdapter extends RecyclerView.Adapter<PgnAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<PgnModel> mListpgn;
    onItemClickListener mListener;

    public PgnAdapter(Context context, ArrayList<PgnModel> listTask) {
        this.mContext = context;
        this.mListpgn = listTask;
    }

    public PgnAdapter(Context context, ArrayList<PgnModel> listTask, onItemClickListener listener) {
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
        final PgnModel pgnModel = mListpgn.get(position);

        holder.taskidtv.setText(pgnModel.getTask_id());
        holder.customeridtv.setText(pgnModel.getCustomer_id());
        holder.nametv.setText(pgnModel.getCustomer_name());
        holder.locationtv.setText(pgnModel.getCustomer_address());
        holder.starttv.setText(pgnModel.getStartDate());
        holder.finishtv.setText(pgnModel.getFinishDate());

        holder.taskCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClickListener(pgnModel);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mListpgn.size();
    }

    public interface onItemClickListener {
        void onItemClickListener(PgnModel pgnModel);
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
