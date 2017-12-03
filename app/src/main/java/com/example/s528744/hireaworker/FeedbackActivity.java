package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_feedback);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
    }


    public void insertFeedback(View v)
    {
        EditText phonenumber = (EditText) findViewById(R.id.editText8);
        EditText msg = (EditText) findViewById(R.id.editText10);

        final String phone= phonenumber.getText().toString();
        final String mssg = msg.getText().toString();


        if (phone.trim().equals("")||phone.matches("\\s+")) {
            phonenumber.setError("Enter Phone Number");
        }

        if (mssg.equals("")||mssg.matches("\\s+")||mssg.isEmpty()) {
            msg.setError("Enter Feedback");
        }
        else
        {

            IDataStore<RegistrationInfo> userStorage = Backendless.Data.of(RegistrationInfo.class);
            DataQueryBuilder query = DataQueryBuilder.create();
            String value="phonenumber='"+phone+"'";
            query.setWhereClause(value);
            Log.d("print","phonenum"+value);
            userStorage.find(query, new AsyncCallback<List<RegistrationInfo>>() {
                @Override
                public void handleResponse(List<RegistrationInfo> response) {
                    Log.d("print","phonenum"+response);
                    String num = response.toString();
                    if(num.contains(phone)){
                        FeedbackInfo feedback = new FeedbackInfo();
                        feedback.phonenumber=phone;
                        feedback.feedback=mssg;
                        Backendless.Data.of( FeedbackInfo.class ).save(feedback, new AsyncCallback<FeedbackInfo>() {


                            @Override
                            public void handleResponse(FeedbackInfo response) {
                                Log.d("DB","Inserted values into table"+response);
                                Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
                                 final Intent i=new Intent(getApplicationContext(),EmployerActivity.class);
                                startActivity(i);
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Log.e( "MYAPP", "Server reported an error " + fault.getMessage() );
                            }
                        });
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Please Enter the Registered user Number",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void handleFault(BackendlessFault fault) {

                    Log.e("MYAPP", "Server reported an error " + fault.getMessage());
                }


        });

    }
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


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
