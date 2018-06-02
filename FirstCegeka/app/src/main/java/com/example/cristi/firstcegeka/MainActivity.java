package com.example.cristi.firstcegeka;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView my_list ;
    String[] items;
    String[] price;
    String[] descrtiption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        my_list = (ListView) findViewById(R.id.my_list);
        items = res.getStringArray(R.array.items);
        price = res.getStringArray(R.array.price);
        descrtiption = res.getStringArray(R.array.description);

       ItemAdapter itemAdapt =  new ItemAdapter(this , items , price , descrtiption);
        my_list.setAdapter(itemAdapt);

        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailIntent = new Intent (getApplicationContext() , DetailActivity_Image.class);
                detailIntent.putExtra("com.example.cristi.firstcegeka.Item" , position);
                startActivity(detailIntent);
            }
        });

    }
}
