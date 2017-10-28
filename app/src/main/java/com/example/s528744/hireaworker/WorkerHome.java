package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class WorkerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_home);
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
