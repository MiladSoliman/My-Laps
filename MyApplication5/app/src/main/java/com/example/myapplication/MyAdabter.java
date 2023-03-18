package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MyAdabter extends RecyclerView.Adapter<MyAdabter.ViewHolder> {
    private Context context ;
    private ArrayList<Product> myProudcts ;
    public  MyAdabter (Context context,ArrayList<Product> myProudcts ){
        this.context = context;
        this.myProudcts = myProudcts;
    }

    public ViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     /*   context=parent.getContext();
        return new ViewHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.myitem,null,false));*/
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.myitem, parent ,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = myProudcts.get(position);
        holder.title.setText(p.getTitle());
        holder.brand.setText(p.getBrand());
        holder.desc.setText(p.getDescription());
        holder.price.setText(String.valueOf(p.getPrice()));
        holder.rating.setRating((float) p.getRating());

       Glide.with(context).load(p.getThumbnail()).apply(new RequestOptions().override(150,150)).into(holder.imageView);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),p.getTitle() , Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return myProudcts.size();
    }






    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView desc;
        public TextView price;

        public TextView brand;

        public RatingBar rating;
        public ImageView imageView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder (View v){
            super(v);
            layout = v;
            title =v.findViewById(R.id.tv_id);
            desc = v.findViewById(R.id.tv_desc);
            price = v.findViewById(R.id.tv_price);
            brand = v.findViewById(R.id.tv_brand);
            rating = v.findViewById(R.id.rate_bar);
            imageView = v.findViewById(R.id.im_view);
            constraintLayout = v.findViewById(R.id.cons_layout);
        }

    }

}
