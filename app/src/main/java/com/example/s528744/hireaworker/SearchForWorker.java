package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
        String value="zipcode="+Integer.parseInt(getIntent().getStringExtra("zipcode"))+" and capability='"+getIntent().getStringExtra("capability")+"' and usertype='Worker'";
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
                        list.add(new RegistrationInfo(response.get(i).getFname(), response.get(i).getPhonenumber(),response.get(i).getCost()));

                    }
                    myArrayAdapter = new MyArrayAdapter(getApplicationContext(), R.layout.workers_listview, R.id.textView13, list);
                    lv.setAdapter(myArrayAdapter);
 lv.setOnItemClickListener(new ListView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                RegistrationInfo workers=list.get(position);
                                String phnum=workers.getPhonenumber();
//                                String item= (String) parent.getItemAtPosition(position);
//                                String value= (String) myArrayAdapter.getItem(position);
//                                Log.d("aaaaaaaaaaaaaaaaaaaa",value);

                                if(parent.getItemAtPosition(position)==lv.getItemAtPosition(position)) {
                                    Intent i = new Intent(getApplicationContext(), ReplyMsgActivity.class);
                                i.putExtra("phnumber",phnum);
                                    startActivity(i);


                                }



                            }
                        });
//                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            if(position==0){
//                                Intent i = new Intent(getApplicationContext(),WorkerDetails.class);
//                                startActivity(i);
//                            }
//                            if(position==1){
//                                Intent i = new Intent(getApplicationContext(),WorkerDetails1.class);
//                                startActivity(i);
//                            }
//
//                        }
//                    });
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