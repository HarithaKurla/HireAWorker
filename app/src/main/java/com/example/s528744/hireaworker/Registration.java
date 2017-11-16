package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;

//created by raveendranath eluri

public class Registration extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioGroup radioGroup2;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_registration);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

//      5)Registration
//    Enter all the details and click on submit

    public void register(View v) {
        EditText firstName = (EditText) findViewById(R.id.Fname);
        EditText lastName = (EditText) findViewById(R.id.Lname);
        EditText mail = (EditText) findViewById(R.id.editText1);
        EditText address = (EditText) findViewById(R.id.editText5);
        EditText zip = (EditText) findViewById(R.id.editText4);
        EditText phNum = (EditText) findViewById(R.id.editText3);
        EditText password = (EditText) findViewById(R.id.editText7);
        EditText exp = (EditText) findViewById(R.id.editText6);
        Spinner cap = (Spinner) findViewById(R.id.spinner);
//        radioGroup = (RadioGroup) findViewById(R.id.empwork);
//        RadioButton radioButton = (RadioButton) findViewById(R.id.radioEmployr);
//        radioGroup2 = (RadioGroup) findViewById(R.id.gender);
//        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioFemale);
        rb3  = (RadioButton)findViewById(R.id.radioWorkr);
        rb4  = (RadioButton)findViewById(R.id.radioEmployr);


        if(rb3.isChecked()==false && rb4.isChecked()==false)
        {
            Toast.makeText(getApplicationContext(),"Please select Worker or Employer",Toast.LENGTH_SHORT).show();
        }


        if (firstName.getText().toString().trim().equals("")) {
            firstName.setError("Name is required!");
        }

        if (lastName.getText().toString().trim().equals("")) {
            lastName.setError("Name is required!");
        }
        if (mail.getText().toString().trim().equals("")) {
            mail.setError("Email is required!");
        }
        if (address.getText().toString().trim().equals("")) {
            address.setError("Address is required!");
        }
        if (zip.getText().toString().trim().equals("")) {
            zip.setError("Zip is required!");
        }
        if (phNum.getText().toString().trim().equals("")) {
            phNum.setError("Phone number is required!");
        }
        if (password.getText().toString().trim().equals("")) {
            password.setError("Password is required!");
        }
        if (exp.getText().toString().trim().equals("")) {
            exp.setError("Experience is required!");
        }
        if (!cap.isSelected()) {


            Toast.makeText(getApplicationContext(), "Please select capabilities", Toast.LENGTH_SHORT).show();
        }




        else {
            Intent it = new Intent(this, LoginActivity.class);
            startActivity(it);
        }
    }

}
