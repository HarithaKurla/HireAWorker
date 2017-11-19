package com.example.s528744.hireaworker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;

public class EmployerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_employer);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
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

//2) EmployerActivity:
//    zipcode-64468
//    Capability- Painter
//    click search

    public void search(View v) {

        EditText zipcode = (EditText) findViewById(R.id.zipcodeE);
        Spinner s=(Spinner) findViewById(R.id.spinner);

        if (zipcode.getText().toString().length()>0 && !zipcode.getText().toString().matches("\\s+")) {
            Log.d("selected value is:    ", "" + s.getSelectedItem().toString().trim());
            if (!s.getSelectedItem().toString().trim().equals("Select")) {

                Intent i = new Intent(this, SearchForWorker.class);
                i.putExtra("zipcode",zipcode.getText().toString().toString());
                i.putExtra("capability",s.getSelectedItem().toString().toString());
                startActivity(i);
//                IDataStore<RegistrationInfo> employersearch = Backendless.Data.of(RegistrationInfo.class);
//                DataQueryBuilder query = DataQueryBuilder.create();
//                String value="Zipcode="+Integer.parseInt(zipcode.getText().toString())+" and Capability='"+s.getSelectedItem().toString()+"'";
//                query.setWhereClause(value);
//                employersearch.find(query, new AsyncCallback<List<RegistrationInfo>>() {
//
//                    @Override
//                    public void handleResponse(List<RegistrationInfo> response) {
//                        Log.d("Printing : ", "Deatils " + response);
//                    }
//
//                    @Override
//                    public void handleFault(BackendlessFault fault) {
//                        Log.e("MYAPP", "Server reported an error " + fault.getMessage());
//                    }
//                });



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
        public void feedback(View v)
        {
            Intent i=new Intent(this,FeedbackActivity.class);
            startActivity(i);
        }
    public void signout(View v){
        Intent i=new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
