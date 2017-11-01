package com.example.s528744.hireaworker;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
// created by raveendranath eluri
public class ReplyMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_msg);
    }
    public void message(View view){
        EditText msg=(EditText) findViewById(R.id.msgET);
        if(msg.getText().toString().length()<=0||msg.getText().toString().matches("\\s+")) {

            msg.setError("type your message");
        }
        else{
//            Toast.makeText(this, "Type message", Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Message has been sent", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,WorkerHome.class);
            startActivity(intent);
        }

    }
}

