package com.examplef.kiran.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    order or;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv=findViewById(R.id.list);
        Intent intent=getIntent();
        or= (order) intent.getSerializableExtra("order");
        AdapterPerson adbOrder;
        ArrayList<order> myListItems  = new ArrayList<order>();

//then populate myListItems

        adbOrder= new AdapterPerson (youractivity.this, 0, myListItems);
        lv.setAdapter(adbOrder);

    }
}
