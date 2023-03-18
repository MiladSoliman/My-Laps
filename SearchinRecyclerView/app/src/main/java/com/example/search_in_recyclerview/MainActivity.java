package com.example.search_in_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    myAdabter myAdabter;
    EditText search;

    private static String TAG = "milad";
   // String[] names = {"Milad Soliman ", "Eslam Gamal", "Essam Mohamed ", " Mina Nageh", "Abdallah Elgedawy", "Sara Rady", "Mayada Mansour", "Clara Kamel", "Sahar Naser", "Hadia teama", "Nada Youssef "};

    ArrayList<String> names = new ArrayList<>();

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.name_recyclerView);
        search = findViewById(R.id.tb_search);


        names.add("Milad Soliman ");
        names.add("Eslam Gamal ");
        names.add("Essam Mohamed  ");
        names.add("Mina Nageh ");
        names.add("Abdallah Elgedawy ");
        names.add("Sara Rady ");
        names.add("Mayada Mansour");
        names.add("Hadia teama ");
        names.add("Nada Youssef ");
        names.add("Eng Hager");
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        myAdabter = new myAdabter(this, names);
        recyclerView.setAdapter(myAdabter);


        Observable.create(new ObservableOnSubscribe<Object>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                         emitter.onNext(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }

        }).doOnNext(s->Log.d(TAG,"on doOnNext "+s))
                .subscribe(i->{Log.d("search","on search "+i);
                        changeData((CharSequence) i);
                                   });

    }

    private void changeData(CharSequence i) {
       ArrayList<String> fillterNames = new ArrayList<>();
       for(int j = 0 ; j<names.size() ;j++){
           if(names.get(j).toLowerCase().startsWith(i.toString())){
               fillterNames.add(names.get(j));
           }
       }
       if(fillterNames.isEmpty()){
           Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
       }else{
           myAdabter.setNames(fillterNames);
       }


    }


}
