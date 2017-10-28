package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchForWorker extends AppCompatActivity {
    public SearchForWorker() {
    }

//
// 3) SearchForWorker
//    click on John/ Mike listview to view his details


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_worker);

        String[] workers={"John                     Good                     $200","Mike                     Fair                   $150"};
        ListAdapter workAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,workers);
        ListView workerAdapterList = (ListView) findViewById(R.id.listView);
        workerAdapterList.setAdapter(workAdapter);

        workerAdapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i = new Intent(getApplicationContext(),WorkerDetails.class);
                    startActivity(i);
                }
                else if(position==1){
                    Intent i = new Intent(getApplicationContext(),WorkerDetails1.class);
                    startActivity(i);
                }
            }
        });
    }

    public void workerDetails(View v){
        Intent i=new Intent(this,WorkerDetails.class);
        startActivity(i);
    }
    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}