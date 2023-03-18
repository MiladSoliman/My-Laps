package com.example.recycelerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class MyAdabter extends RecyclerView.Adapter<MyAdabter.ViewHolder> {
    private static final String TAG = "MyAdabter";
    Context context ;
    Cakes [] cakes ;

    ViewPager2 viewPager ;
    public MyAdabter (Context _context , Cakes[] _cakes ){
        context =_context;
        cakes=_cakes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.cakes_item , parent ,false);
        ViewHolder vh = new ViewHolder(view);
        Log.i(TAG,"onCrewViewHolder");

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      Cakes current = cakes[position];
      holder.textTitle.setText(current.getName());
     // holder.textDesc.setText(current.getDescreiption());
      holder.imgCake.setImageResource(current.getImage_thumbnail());
      holder. constraintLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "Clicked on "+ current.getName(), Toast.LENGTH_SHORT).show();

          }

      });
     Log.i(TAG,"onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return cakes.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textTitle;
        public TextView textDesc;
        public ImageView imgCake;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder (View v){
            super(v);
            layout = v;
            textTitle= v.findViewById(R.id.tv_cakeName);
         //   textDesc = v.findViewById(R.id.cake_desc);
            imgCake=v.findViewById(R.id.imageView);
           constraintLayout = v.findViewById(R.id.constrain);
        }

    }
}
