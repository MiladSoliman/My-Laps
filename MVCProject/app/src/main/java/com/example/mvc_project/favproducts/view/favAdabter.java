package com.example.mvc_project.favproducts.view;

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
import com.example.mvc_project.allproducts.view.allAdabter;
import com.example.mvc_project.model.Product;

import java.util.List;

public class favAdabter extends  RecyclerView.Adapter<favAdabter.ViewHolder>{
    Context context;
    private List<Product>favProducts;

    onRemove removeListener;

public favAdabter (Context context , List<Product> favProducts , onRemove listner){
    this.context = context;
    this.favProducts =favProducts;
    this.removeListener = listner;
}

public void setList(List<Product> uodatedProduct ){this.favProducts = uodatedProduct;}

    @NonNull
    @Override
    public favAdabter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fav_product, parent ,false);
        favAdabter.ViewHolder vh = new favAdabter.ViewHolder(view);

    return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = favProducts.get(position);
        holder.brand.setText(p.getBrand());
        holder.desc.setText(p.getDescription());
        holder.price.setText(String.valueOf(p.getPrice()));
        holder.title.setText(p.getTitle());
        Glide.with(context).load(p.getThumbnail()).into(holder.imageView);
        holder.btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeListener.onDelete(p);
            }

        });


    }

    @Override
    public int getItemCount() {
        return favProducts.size();
    }


    public class ViewHolder  extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;
        public TextView price;
        public TextView brand;
        public ImageView imageView;
        public ConstraintLayout constraintLayout;
        public View layout;
        public Button btn_remove;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            title =v.findViewById(R.id.tv_title);
            desc = v.findViewById(R.id.tv_desc);
            price = v.findViewById(R.id.tv_price);
            brand = v.findViewById(R.id.tv_brand);
            imageView = v.findViewById(R.id.imageView2);
            constraintLayout = v.findViewById(R.id.cons_layout);
            btn_remove = v.findViewById(R.id.btn_remove);
        }
    }


}
