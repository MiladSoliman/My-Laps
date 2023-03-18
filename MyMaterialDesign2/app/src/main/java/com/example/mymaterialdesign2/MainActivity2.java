package com.example.mymaterialdesign2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

  /*  TextInputLayout textInputLayout;
     AutoCompleteTextView autoCompleteTextView ;
    String [] days = {"saturday" , "sunday" ,"monday"};*/
  String[] items =  {"Material","Design","Components","Android","5.0 Lollipop"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     /*  // setContentView(R.layout.activity_main2);
       // textInputLayout = findViewById(R.id.label);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);

                //adapterItems = new ArrayAdapter<String>(this,R.layout.item_list,items);
        adapterItems=new ArrayAdapter<String>(this,R.layout.item_list);
        adapterItems.addAll("ddddddddddd");

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.showDropDown();

        // autoCompleteTextView.setAdapter(daysAdabter);
      /* autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String day = String.valueOf(parent.getItemIdAtPosition(position));
               Toast.makeText(MainActivity2.this,day, Toast.LENGTH_SHORT).show();
           }
       });*/

        autoCompleteTextView =findViewById(R.id.auto_complete_txt);
      //  adapterItems=new ArrayAdapter<String>(this,R.layout.item_list);
        adapterItems = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.showDropDown();
            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  autoCompleteTextView.showDropDown();
                Toast.makeText(MainActivity2.this, "Meal added to "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
           //     autoCompleteTextView.setHint("Add to plane");
            }
        });

    }
}