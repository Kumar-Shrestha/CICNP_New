package com.reckontech.cicnp.cicnp.Watch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reckontech.cicnp.cicnp.R;

import java.util.List;

/**
 * Created by Dell on 9/3/2016.
 */
public class WatchRecyclerAdapter extends RecyclerView.Adapter<WatchRecyclerAdapter.ViewHolder>{


    private List<WatchRecyclerDataWrapper> recyclerDataList;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView phone;
        public ImageView image;

        public ViewHolder(View view){
            super(view);
            name = (TextView) view.findViewById(R.id.watch_recycler_row_textView_name);
            phone = (TextView) view.findViewById(R.id.watch_recycler_row_textView_phone);
            image = (ImageView) view.findViewById(R.id.watch_recycler_row_image);
        }
    }

    public WatchRecyclerAdapter(List<WatchRecyclerDataWrapper> recyclerDataList){
        this.recyclerDataList = recyclerDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.watch_recycler_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(recyclerDataList.get(position).name);
        holder.phone.setText(recyclerDataList.get(position).phone);

        if(!(recyclerDataList.get(position).image == null)) {
            String uri = "@drawable/" + recyclerDataList.get(position).image;
            int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
            holder.image.setImageResource(imageResource);
        }

    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, WatchRecyclerDataWrapper data) {
        recyclerDataList.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(String data) {
        int position = recyclerDataList.indexOf(data);
        recyclerDataList.remove(position);
        notifyItemRemoved(position);
    }
}
