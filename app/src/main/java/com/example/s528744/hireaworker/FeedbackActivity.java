package com.example.s528744.hireaworker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
    }


    public void insertFeedback(View v)
    {
        EditText phonenumber = (EditText) findViewById(R.id.editText8);
        EditText msg = (EditText) findViewById(R.id.editText10);

        if (phonenumber.getText().toString().trim().equals("")) {
            phonenumber.setError("Enter Phone Number");
        }

        if (msg.getText().toString().trim().equals("")) {
            msg.setError("Enter Feedback");
        }
        else
        {
            FeedbackInfo feedback = new FeedbackInfo();
            feedback.phonenumber=phonenumber.getText().toString();
            feedback.feedback=msg.getText().toString();
            Backendless.Data.of( FeedbackInfo.class ).save(feedback, new AsyncCallback<FeedbackInfo>() {


                @Override
                public void handleResponse(FeedbackInfo response) {
                    Log.d("DB","Inserted values into table"+response);
                }

                @Override
                public void handleFault(BackendlessFault fault) {
                    Log.e( "MYAPP", "Server reported an error " + fault.getMessage() );
                }
            });
        }

    }
}
