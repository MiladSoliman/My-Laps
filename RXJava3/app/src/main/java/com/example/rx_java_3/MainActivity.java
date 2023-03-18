package com.example.rx_java_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    EditText name ;
    EditText age ;
    Button send ;

    String pairs ;

    TextView total;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> ages =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pairs = " ";
        name = findViewById(R.id.tb_name);
        age = findViewById(R.id.tb_age);
        send = findViewById(R.id.tb_send);
        total =findViewById(R.id.tv_nameandage);


     /*   send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(" ");
                String user_name = name.getText().toString();
                String user_age = age.getText().toString();
              if(user_name !=null && user_age!=null){
                    StringTokenizer nameToke = new StringTokenizer(user_name," ");
                    while (nameToke.hasMoreTokens()){
                        names.add(nameToke.nextToken());
                    }
                  StringTokenizer ageToke = new StringTokenizer(user_age," ");
                    while (ageToke.hasMoreTokens()){
                        ages.add(ageToke.nextToken());
                    }
                }
              Observable<String> observableNames = Observable.fromIterable(names);
              Observable<String> observableAges = Observable.fromIterable(ages);

              Observable <String> result = Observable.zip(observableNames,observableAges,(pairName , pairAge)->{
                  pairs = pairName+" "+pairAge+" ";
                  total.append(pairs+"\n");
                  return pairs;
              });
             result.subscribe();



            }
        });*/





        Observable myObservable = Observable.create( source ->{
            Log.d("Tag","hello mad");
            source.onNext(1);
            source.onNext(2);
            source.onNext(3);
            source.onNext(4);
            source.onNext(5);
        });
        myObservable.subscribeOn(Schedulers.io())
                .doOnNext(Integer -> System.out.println("Emiiting item" + Integer + " on:" + Thread.currentThread().getName()))
                .observeOn(Schedulers.newThread())
                .doOnNext(Integer -> System.out.println("After Emiiting item" + Integer + " on:" + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .doOnNext(Integer -> System.out.println("After computation Thread Emiiting item" + Integer + " on:" + Thread.currentThread().getName()))
                .subscribe(Integer -> System.out.println("Consuming item" + Integer + " on:" + Thread.currentThread().getName()));





    }
}