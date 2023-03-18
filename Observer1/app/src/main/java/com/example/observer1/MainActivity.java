package com.example.observer1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class MainActivity extends AppCompatActivity {

    TextView text ;
    Button array ;
    Button iterable ;

    private Spinner days_spinner;


    String [] days ={"satrday","sunday","monday","tusday"};

    private static final String TAG = "interval";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.tv_shwo);
        array = findViewById(R.id.btn_Array);
        iterable = findViewById(R.id.btn_iterable);
        days_spinner =findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,days);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        days_spinner.setAdapter(adapter);




         Integer [] arrays = {1,2,3,4,5};
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("milad");
        list.add("from");
        list.add("iterable");
        list.add("observable");

         array.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 text.setText("");
                 Observable observable = Observable.fromArray(arrays);
                 observable.subscribe(
                      item->text.append("\n"+item),
                      error-> Log.i("Tag","error"+error.toString()),
                         ()->Log.i("Tag","Completed")
                 );
             }
         });

        iterable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
                Observable<String> observable = Observable.fromIterable(list);
                observable.subscribe(
                        item->text.append("\n"+item),
                        error-> Log.i("Tag","error"+error.toString()),
                        ()->Log.i("Tag","Completed")
                );

            }
        });
        ConnectableObservable<Long> observable = ConnectableObservable.intervalRange(0,5,0,2, TimeUnit.SECONDS).publish();
        observable.connect();
        observable.subscribe(
          item->Log.i(TAG,"on observal 1 "+"//"+item)
        );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        observable.subscribe(
                item->Log.i(TAG,"on observal 2"+"//"+item)
        );



        Observable<Integer> observable2 =Observable.never();
        observable2.subscribe(
          item->Log.i("on observal","it's neve show"+item)
        );

    }
}