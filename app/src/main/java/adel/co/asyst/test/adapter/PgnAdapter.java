package adel.co.asyst.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import adel.co.asyst.test.model.PgnModel;

public class PgnAdapter extends RecyclerView.Adapter<PgnModel.MyViewHolder> {

    Context mContext;
    ArrayList<PgnModel> mListpgn;

    @NonNull
    @Override
    public PgnModel.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PgnModel.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
