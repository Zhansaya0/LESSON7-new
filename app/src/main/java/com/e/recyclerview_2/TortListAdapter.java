package com.e.recyclerview_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TortListAdapter extends RecyclerView.Adapter<TortListAdapter.MyTViewHolder> {
    private Context context;
    private List<Tort> tortList;

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public ImageView photo;
        public TextView title, taste_rating, price,weight;

        public MyTViewHolder(View view ){
            super(view);
            photo= view.findViewById(R.id.photo);
            title= view.findViewById(R.id.title);
            taste_rating= view.findViewById(R.id.taste_rating);
            price= view.findViewById(R.id.price);
            weight= view.findViewById(R.id.weight);
        }
    }
    public TortListAdapter(Context context, List<Tort> tortList) {
        this.context = context;
        this.tortList = tortList;
    }
    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foods, parent, false);
        return new MyTViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyTViewHolder sborka, int position) {
        Tort item = tortList.get(position);

        sborka.photo.setImageResource(item.getPhoto());
        sborka.title.setText(item.getTitle());
        sborka.taste_rating.setText(item.getTaste_rating());
        sborka.price.setText(""+item.getPrice());
        sborka.weight.setText(""+item.getWeight());
    }
    @Override
    public int getItemCount() {
        return tortList.size();
    }
}