package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home) {
            this.finish();
        }
        else if(item.getItemId()==R.id.sign_out){
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
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