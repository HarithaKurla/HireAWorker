package com.example.s528744.hireaworker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EmployerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
    }

    public void search(View v) {

        EditText zipcode = (EditText) findViewById(R.id.zipcodeE);
        Spinner s=(Spinner) findViewById(R.id.spinner);

        if (zipcode.getText().toString().length()>0 && !zipcode.getText().toString().matches("\\s+")) {
            Log.d("selected value is:    ", "" + s.getSelectedItem().toString().trim());
            if (!s.getSelectedItem().toString().trim().equals("Select")) {
                if (zipcode.getText().toString().equals("64468") && s.getSelectedItem().toString().trim().equals("Painter")) {
                    Intent i = new Intent(this, SearchForWorker.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),
                            "Please enter valid zipcode", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(getApplicationContext(),
                        "Please select the desired area", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            zipcode.setError("Please enter zipcode");
        }
    }

    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
