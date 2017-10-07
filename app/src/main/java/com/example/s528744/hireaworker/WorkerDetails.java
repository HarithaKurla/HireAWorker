package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WorkerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_details);
    }

    public void contact(View view)
    {

        Toast.makeText(WorkerDetails.this,
                "Message has been sent", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,EmployerActivity.class);
        startActivity(i);


    }
    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }

    public void Rate(View v)
    {
        Toast.makeText(WorkerDetails.this,
                "User has been rated", Toast.LENGTH_SHORT).show();
    }
}
