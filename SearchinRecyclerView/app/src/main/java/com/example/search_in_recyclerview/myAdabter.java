package com.example.search_in_recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdabter extends  RecyclerView.Adapter<myAdabter.ViewHolder> {

    Context context ;
    ArrayList<String> names ;

    public myAdabter(Context context, ArrayList<String> names) {
        this.context = context;
        this.names = names;
    }

    public void setNames (ArrayList<String> names){
        this.names=names;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.name_layout , parent ,false);
        ViewHolder vh = new ViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = names.get(position);
        holder.textTitle.setText(name);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView textTitle;

    public View layout;

    public ViewHolder (View v){
        super(v);
        layout = v;
        textTitle= v.findViewById(R.id.tv_name);

    }

}
}
