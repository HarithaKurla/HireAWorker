package com.example.s528744.hireaworker;
//created & modified by Aswini Vadlamudi
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_group_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_forgot_password);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

//
//    6) ForgotPassword
//    Enter new password and confirm password(both should be same) and click update password

    public void recoverPassword(View v) {
        EditText newpassword = (EditText) findViewById(R.id.newPassword);
        EditText confirmpassword = (EditText) findViewById(R.id.confirmPassword);
        if (newpassword.getText().toString().length() > 0 && !newpassword.getText().toString().matches("\\s+")) {
            if (confirmpassword.getText().toString().length() > 0 && !confirmpassword.getText().toString().matches("\\s+")) {
                if (newpassword.getText().toString().equals(confirmpassword.getText().toString())) {

                    Toast.makeText(getApplicationContext(),
                            "Password has been updated. Login back", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(this, LoginActivity.class);
                    startActivity(it);
                } else {
                    confirmpassword.setError("Both new password and confirm password should match. Please re-enter");
                   // Toast.makeText(getApplicationContext(),
                       //     "Both new password and confirm password should match. Please re-enter", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                confirmpassword.setError("Please enter confirm password");
            }
        }else {
            newpassword.setError("Please enter new password");
            //Toast.makeText(getApplicationContext(),
                  //  "Please enter the email address", Toast.LENGTH_SHORT).show();

        }
    }
}
