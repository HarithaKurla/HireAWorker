package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class SearchForWorker extends AppCompatActivity {

    //MyCursorAdapter myCursorAdapter;
    MyArrayAdapter myArrayAdapter;
    public ArrayList<RegistrationInfo> list;
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

        final DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        String value="Zipcode="+Integer.parseInt(getIntent().getStringExtra("zipcode"))+" and Capability='"+getIntent().getStringExtra("capability")+"'";
        queryBuilder.setWhereClause(value);

        final ListView lv = (ListView)   findViewById(R.id.listView);


            Backendless.Persistence.of(RegistrationInfo.class).find(queryBuilder, new AsyncCallback<List<RegistrationInfo>>() {
                @Override
                public void handleResponse(List<RegistrationInfo> response) {
                    list = new ArrayList<>();
                    Log.d("list view response is" ,"   kkkk"+response);
                    if (response.size() > 0) {
                        for (int i = 0; i < response.size(); i++) {
//                    ListView lv = (ListView)   findViewById(R.id.ListerLV);
                            list.add(new RegistrationInfo(response.get(i).getF_Name(), response.get(i).getPhoneNumber(),
                                    response.get(i).getCost_Per_Hour()));

                        }
                        myArrayAdapter = new MyArrayAdapter(getApplicationContext(), R.layout.workers_listview, R.id.textView13, list);
                        lv.setAdapter(myArrayAdapter);
                    } else {
                        Toast.makeText(getApplicationContext(), "No orders found", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void handleFault(BackendlessFault backendlessFault) {
                    Log.i("MYAPP", "error - " + backendlessFault.getMessage());
                }
            });

        }

//        String[] workers={"John Good $200","Mike Fair $150"};
//        ListAdapter workAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,workers);
//        ListView workerAdapterList = (ListView) findViewById(R.id.listView);
//        workerAdapterList.setAdapter(workAdapter);


//        workerAdapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    Intent i = new Intent(getApplicationContext(),WorkerDetails.class);
//                    startActivity(i);
//                }
//                else if(position==1){
//                    Intent i = new Intent(getApplicationContext(),WorkerDetails1.class);
//                    startActivity(i);
//                }
//            }
//        });


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