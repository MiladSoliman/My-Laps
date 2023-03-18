package com.example.mvc_project.allproducts.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvc_project.R;
import com.example.mvc_project.model.Product;

import java.util.ArrayList;

public class allAdabter extends  RecyclerView.Adapter<allAdabter.ViewHolder>{

    private Context context;
    private ArrayList<Product> products ;
    onAdd listnear;

    public allAdabter (Context context , ArrayList<Product> products , onAdd listnear){
        this.context = context ;
        this.products = products;
        this.listnear = listnear;
     }


    @NonNull
    @Override
    public allAdabter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.allprodcts, parent ,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull allAdabter.ViewHolder holder, int position) {
       Product product = products.get(position);
       holder.brand.setText(product.getBrand());
       holder.desc.setText(product.getDescription());
       holder.price.setText(String.valueOf(product.getPrice()));
       holder.title.setText(product.getTitle());
      // Glide.with(context).load(p.getThumbnail()).apply(new RequestOptions().override(150,150)).into(holder.imageView);
        Glide.with(context).load(product.getThumbnail()).into(holder.imageView);
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listnear.onClick(product);

            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }



    public class ViewHolder  extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;
        public TextView price;
        public TextView brand;
        public ImageView imageView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public Button btn_add ;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            title =v.findViewById(R.id.tv_title);
            desc = v.findViewById(R.id.tv_desc);
            price = v.findViewById(R.id.tv_price);
            brand = v.findViewById(R.id.tv_brand);
            imageView = v.findViewById(R.id.imageView2);
            btn_add = v.findViewById(R.id.btn_addToFav);
            constraintLayout = v.findViewById(R.id.cons_layout);

        }
    }
}
