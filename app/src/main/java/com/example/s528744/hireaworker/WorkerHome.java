package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.exceptions.BackendlessFault;

import java.util.List;

public class WorkerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_worker_home);

        String email=getIntent().getStringExtra("email");
        Backendless.setUrl( Defaults.SERVER_URL);
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY);

        IDataStore<RegistrationInfo> userStorage = Backendless.Data.of(RegistrationInfo.class);
        DataQueryBuilder query = DataQueryBuilder.create();
        String value="email='"+email+"' and usertype='Worker'";
        query.setWhereClause(value);
        userStorage.find(query,new AsyncCallback<List<RegistrationInfo>>() {


            @Override
            public void handleResponse(List<RegistrationInfo> response) {
              //  Log.d("Printing : ", "user Details: " + response);
                TextView fname=(TextView)findViewById(R.id.textView2);
                TextView lname=(TextView)findViewById(R.id.textView4);
                TextView cap=(TextView)findViewById(R.id.textView6);
                TextView Addr=(TextView)findViewById(R.id.textView8);
               // TextView zip=(TextView)findViewById(R.id.textView10);
                TextView pn=(TextView)findViewById(R.id.textView12);
                TextView email=(TextView)findViewById(R.id.textView14);
                final TextView feed=(TextView)findViewById(R.id.textView16);
                String num=null;
                for (int i = 0; i < response.size(); i++) {
                    fname.setText(response.get(i).getFname());
                    lname.setText(response.get(i).getLname());
                    cap.setText(response.get(i).getCapability());
                    Addr.setText(response.get(i).getAddress());
                 //   zip.setText(response.get(i).getZipcode());
                    pn.setText(response.get(i).getPhonenumber());
                    email.setText(response.get(i).getEmail());
                    num=response.get(i).getPhonenumber();

                }
                IDataStore<FeedbackInfo> feedinfo = Backendless.Data.of(FeedbackInfo.class);
                DataQueryBuilder query = DataQueryBuilder.create();
                String value="phonenumber='"+num+"'";
                query.setWhereClause(value);
                feedinfo.find(query,new AsyncCallback<List<FeedbackInfo>>() {

                    @Override
                    public void handleResponse(List<FeedbackInfo> response) {
                        Log.d("Printing : ", "Fedback Details: " + response);
                        for (int i = 0; i < response.size(); i++) {
                        feed.setText(response.get(i).getFeedback());
                        }

                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {

                    }
                });
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("MYAPP", "Server reported an error " + fault.getMessage());
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.sign_out:
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void reply(View v){
        Intent i=new Intent(this,WorkerHome.class);
        startActivity(i);
        Toast.makeText(WorkerHome.this,
                "Message has been sent", Toast.LENGTH_SHORT).show();

    }
    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }

//      8)WorkerHome
//    click on reply
//    enter message and click on immage >
//    click Signout
    public void ReplyAction(View v){
        Intent it = new Intent(this,ReplyMsgActivity.class);
        startActivity(it);
    }
}
