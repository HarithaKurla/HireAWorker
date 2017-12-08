package com.example.s528744.hireaworker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

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
        Backendless.setUrl(Defaults.SERVER_URL);
        Backendless.initApp(getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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
        EditText cost_hr = (EditText) findViewById(R.id.costperhour);
        Spinner cap = (Spinner) findViewById(R.id.spinner);
        RadioGroup radioUserGroup = (RadioGroup) findViewById(R.id.userRadioGroup);
        RadioButton userType;

        // rb3  = (RadioButton)findViewById(R.id.radioWorkr);
        //  rb4  = (RadioButton)findViewById(R.id.radioEmployr);


        //  if(rb3.isChecked()==false && rb4.isChecked()==false)
        //  {
        //      Toast.makeText(getApplicationContext(),"Please select Worker or Employer",Toast.LENGTH_SHORT).show();
        //   }
        radioGroup = (RadioGroup) findViewById(R.id.userRadioGroup);
        // boolean checked = ((RadioButton) view).isChecked();
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            userType = (RadioButton) findViewById(selectedId);
            // Check which radio button was clicked
//
            final String s = userType.getText().toString();

            if (firstName.getText().toString().length()<0) {
                Toast.makeText(getApplicationContext(), "Please enter firstname", Toast.LENGTH_SHORT).show();
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
            if (cap.getSelectedItem().toString() == "Select") {


                Toast.makeText(getApplicationContext(), "Please select capabilities", Toast.LENGTH_SHORT).show();
            } else {
                RegistrationInfo registerUser = new RegistrationInfo();
                registerUser.fname = firstName.getText().toString();
                registerUser.lname = lastName.getText().toString();
                registerUser.email = mail.getText().toString();
                //  int selectedId = radioUserGroup.getCheckedRadioButtonId();

               // userType = (RadioButton) findViewById(selectedId);
              //  Log.d("usertype", "" + userType.getText().toString());
                // String s = userType.getText().toString();
                registerUser.usertype = s;
                registerUser.address = address.getText().toString();
                registerUser.zipcode = Integer.parseInt(zip.getText().toString());
                registerUser.password = password.getText().toString();
                registerUser.phonenumber = phNum.getText().toString();
                registerUser.capability = cap.getSelectedItem().toString();
                registerUser.experience = Integer.parseInt(exp.getText().toString());
                registerUser.cost = Integer.parseInt(cost_hr.getText().toString());

                Backendless.Data.of(RegistrationInfo.class).save(registerUser, new AsyncCallback<RegistrationInfo>() {


                    @Override
                    public void handleResponse(RegistrationInfo response) {
                        Log.d("DB", "Inserted values into table" + response);
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.e("MYAPP", "Server reported an error " + fault.getMessage());
                    }
                });

                Intent it = new Intent(this, LoginActivity.class);
                startActivity(it);
                Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
