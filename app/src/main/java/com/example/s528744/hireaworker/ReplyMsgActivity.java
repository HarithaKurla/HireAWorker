package com.example.s528744.hireaworker;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// created by raveendranath eluri
public class ReplyMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_group_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_reply_msg);
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
    public void message(View view){
        EditText msg=(EditText) findViewById(R.id.msgET);
//        TextView ph = (TextView) findViewById(R.id.editText6);
//        String s =ph.getEditableText().toString();
//        msg.setText(s);
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

