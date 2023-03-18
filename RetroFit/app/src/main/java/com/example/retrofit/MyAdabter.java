package com.example.retrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MyAdabter extends RecyclerView.Adapter<MyAdabter.ViewHolder>{
    private ArrayList<MyResponse> responses ;
    private static final String TAG2 = "MyAdabter";

  static ArrayList<Proudcts> p ;
    Context context;
    public MyAdabter (Context _context , ArrayList<MyResponse> _response){
        context =_context;
        responses = _response;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.product_item, parent ,false);
        ViewHolder vh = new ViewHolder(view);
        Log.i(TAG2,"onCrewViewHolder");

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    ArrayList<Proudcts> p = responses.get(position).getProudcts();
    holder.id.setText(String.valueOf(p.get(position).getId()));
    holder .title.setText(p.get(position).getTitle());
    holder.desc.setText(p.get(position).getDescribtion());
    holder.price.setText(String.valueOf(p.get(position).getPrice()));
    holder.discount.setText(String.valueOf(p.get(position).getDiscountPercentage()));
//    holder.stock.setText(String.valueOf(p.get(position).getStock()));
    holder.brand.setText(p.get(position).getBrand());
    holder.category.setText(p.get(position).getCategory());
    holder.rating.setRating((float)p.get(position).getRating());
    Glide.with(context).load(p.get(position).getThumbnail()).apply(new RequestOptions().override(150,150)).into(holder.imageView);
    Log.i(TAG2,"onBindViewHolder");

    }

    @Override
    public int getItemCount() {
        return p.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView id;
        public TextView title;
        public TextView desc;
        public TextView price;
        public TextView discount;
        public TextView stock;
        public TextView brand;
        public TextView category;
        public RatingBar rating;
        public ImageView imageView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder (View v){
            super(v);
            layout = v;
            id=v.findViewById(R.id.tv_id);
            title =v.findViewById(R.id.tv_title);
            desc = v.findViewById(R.id.tv_desc);
            price = v.findViewById(R.id.tv_price);
            discount = v.findViewById(R.id.tv_discount);
            stock = v.findViewById(R.id.tv_stock);
            brand = v.findViewById(R.id.tv_brand);
            category = v.findViewById(R.id.tv_category);
            rating = v.findViewById(R.id.rate_bar);
            imageView = v.findViewById(R.id.im_view);
            constraintLayout = v.findViewById(R.id.cons_layaout);
        }

    }
}
