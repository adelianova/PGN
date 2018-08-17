package adel.co.asyst.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adel.co.asyst.test.model.PgnModel;

public class PgnAdapter extends RecyclerView.Adapter<PgnAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<PgnModel> mListpgn;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    public interface OnItemClickListener {
        void onItemClick(PgnModel pgnModel);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
