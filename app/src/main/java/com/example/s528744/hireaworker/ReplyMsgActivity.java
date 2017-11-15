package com.example.s528744.hireaworker;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// created by raveendranath eluri
public class ReplyMsgActivity extends AppCompatActivity {
    SmsManager smsManager = SmsManager.getDefault();
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
        EditText phNum=(EditText) findViewById(R.id.numET);
        String phoneNo = phNum.getText().toString();
        String message = msg.getText().toString();


//        TextView ph = (TextView) findViewById(R.id.editText6);
//        String s =ph.getEditableText().toString();
//        msg.setText(s);
        if(msg.getText().toString().length()<=0||msg.getText().toString().matches("\\s+")) {

            msg.setError("type your message");
        }
        else{

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, message, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

                String SENT_SMS_ACTION = "SENT_SMS_ACTION";
                String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION"; // create the sentIntent parameter
                Intent sentIntent = new Intent (SENT_SMS_ACTION);
//                Pending Intentsent = PendingIntent.getBroadcast (getApplicationContext (), 0, sentIntent, 0); // create the delivery Intent parameter
                Intent deliveryIntent = new Intent (DELIVERED_SMS_ACTION);
//                Pending Intentdeliver = PendingIntent.getBroadcast (getApplicationContext (), 0,deliveryIntent,0); // Register the Broadcast Receivers
                registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context _context, Intent _intent) {
                        switch (getResultCode()) {
                            case Activity.RESULT_OK:
                                Log.d("Log","success");
                                break;
                            case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                Log.d("Log","fail");
                                break;
                            case SmsManager.RESULT_ERROR_RADIO_OFF:
                                Log.d("Log","error");
                                break;
                            case SmsManager.RESULT_ERROR_NULL_PDU:
                                Log.d("Log","null");
                                break; } } },
                        new IntentFilter(SENT_SMS_ACTION));
                PendingIntent sentPI = PendingIntent.getBroadcast(getApplicationContext(),0,sentIntent,0);
//                registerReceiver(new BroadcastReceiver() {

//                    @Override public void onReceive(Context _context, Intent _intent) {
//                        [Activity.RESULT_OK, ] } },
//                        new IntentFilter(DELIVERED_SMS_ACTION)); // Send the message
//                smsManager.sendTextMessage(phoneNo, null, message, sentPI, deliverPI);
//
////                Intent sentIntent = new Intent(SENT_SMS_ACTION);
//
//                short destinationPort = 80;
//                byte[] data =new Byte[];
//                smsManager.sendDataMessage(phoneNo, null, destinationPort, data, sentPI, null);



            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"SMS failed, please try again.", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }



//            String sendTo ="9231821234";
//            String myMessage = "my message";
//            smsManager.sendTextMessage(sendTo, null, myMessage, null, null);


//            Toast.makeText(this, "Message has been sent", Toast.LENGTH_SHORT).show();
//            Intent intent=new Intent(this,WorkerHome.class);
//            startActivity(intent);
        }

    }
}

