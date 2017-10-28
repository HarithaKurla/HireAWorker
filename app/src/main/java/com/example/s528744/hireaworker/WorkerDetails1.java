package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WorkerDetails1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_details1);
    }

    public void contact(View view)
    {
        EditText message=(EditText)findViewById(R.id.message);
        if(message.getText().toString().length()>0 && !message.getText().toString().matches("\\s+")) {
            Toast.makeText(WorkerDetails1.this,
                    "Message has been sent", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, SearchForWorker.class);
            startActivity(i);
        }
        else
        {
            message.setError("Please enter message");
        }

    }
    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    public void Rate(View v)
    {
        Toast.makeText(WorkerDetails1.this,
                "User has been rated", Toast.LENGTH_SHORT).show();
    }
}
