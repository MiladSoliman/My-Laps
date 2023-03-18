package com.example.rx_java_day2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import io.reactivex.rxjava3.core.Observable;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names.add("Patrick Ross");
        names.add("Kelly Wood");
        names.add("James More");
        names.add("Mary Cartet");
        names.add("Janice Coleman");
        Stream<String> stream = names.stream().filter(element-> element.length()<12 && element.startsWith("J"));
        Log.i("Tag","Count is " +stream.count());



        Stream<String> stream1 = Stream.of("one","two","three","four");
        boolean match =  stream1.anyMatch(s->s.contains("four"));
        Log.i("Tag"," match is "+match);




        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("milad");
        list.add("from");
        list.add("iterable");
        list.add("observable");
        Observable<String> observable = Observable.fromIterable(list);
        observable.debounce(1,TimeUnit.SECONDS).subscribe(
                item->Log.i("Tag",""+item)
        );




    }

}