package com.example.s528744.hireaworker;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// created by raveendranath eluri
public class ReplyMsgActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_reply_msg);

        sendBtn = (Button) findViewById(R.id.msgBTN);
        txtphoneNo = (EditText) findViewById(R.id.numET);
        Intent i=new Intent(this,ReplyMsgActivity.class);
        String num=getIntent().getStringExtra("phnumber");
        txtphoneNo.setText(num);
        txtMessage = (EditText) findViewById(R.id.msgET);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String phNum=txtphoneNo.getText().toString();
                String msg= txtMessage.getText().toString().trim();
                if(msg.length()>0){
                    sendSMSMessage(phNum, msg);

                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Please type message", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    protected void sendSMSMessage(String number,String msg) {
        phoneNo = txtphoneNo.getText().toString();
        message = txtMessage.getText().toString();




            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }


    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {

        String msg= txtMessage.getText().toString();
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {


                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNo, null, message, null, null);
                        Toast.makeText(getApplicationContext(), "SMS sent.",
                                Toast.LENGTH_LONG).show();
                        final Intent i = new Intent(getApplicationContext(), EmployerActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                        return;
                    }

            }
        }

    }
}
