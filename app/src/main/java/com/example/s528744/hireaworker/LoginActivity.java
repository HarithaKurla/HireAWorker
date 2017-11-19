package com.example.s528744.hireaworker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.IDataStore;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    /**
     * Id to identity READ_CONTACTS permission request.
     */
//  private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
//    private static final String[] DUMMY_CREDENTIALS = new String[]{
//            "foo@example.com:hello", "bar@example.com:world"
//    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
   // private UserLoginTask mAuthTask = null;

    // UI references.
//    private AutoCompleteTextView mEmailView;
//    private EditText mPasswordView;
//    private View mProgressView;
//    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.worker1);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_login);
        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( getApplicationContext(), Defaults.APPLICATION_ID, Defaults.API_KEY );
    }



//      1)LoginActivity:
//    select Employer
//    Email-john.miller@gmail.com
//    password-qwerty
//    click login

//       7)LoginActivity
//    select Worker
//    Email-john.miller@gmail.com
//    password-qwerty
//    click login

       public void onSubmit(View view) {


           radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);
           // boolean checked = ((RadioButton) view).isChecked();
           int selectedId = radioSexGroup.getCheckedRadioButtonId();
           if (selectedId != -1) {
               radioSexButton = (RadioButton) findViewById(selectedId);
               // Check which radio button was clicked
//
               final String s = radioSexButton.getText().toString();
               final EditText email = (EditText) findViewById(R.id.email);
               final String emailID = email.getText().toString();
               final EditText password = (EditText) findViewById(R.id.password);
               final String passcode = password.getText().toString();

               if (emailID.length() > 0 && !emailID.matches("\\s+")) {

                   if (passcode.length() > 0 && !passcode.matches("\\s+")) {

//                       if (email.getText().toString().equals("john.miller@gmail.com") && password.getText().toString().equals("qwerty")) {

                       IDataStore<RegistrationInfo> userStorage = Backendless.Data.of(RegistrationInfo.class);
                       DataQueryBuilder query = DataQueryBuilder.create();
                       String value="email='"+emailID+"' and usertype='"+s+"'";
                       query.setWhereClause(value);
                       userStorage.find(query, new AsyncCallback<List<RegistrationInfo>>() {

                           @Override
                           public void handleResponse(List<RegistrationInfo> response) {
                               Log.d("Printing : ", "user Details: " + response);

                               String test = response.toString();
                               Log.d("Printing : ", "user test: " + test);


                                   switch (s) {

                                       case "Employer":
                                           if ((test.contains(emailID) && test.contains(passcode)) &&(test.contains(s)) ){
                                               Intent i = new Intent(getApplicationContext(), EmployerActivity.class);
                                               startActivity(i);
                                           }
                                           else
                                           {
                                               Toast.makeText(getApplicationContext(), "Please enter valid credentails", Toast.LENGTH_SHORT).show();
                                           }

                                           break;
                                       case "Worker":
                                           if ((test.contains(emailID) && test.contains(passcode)) &&(test.contains(s)) ){
                                               Intent i1 = new Intent(getApplicationContext(), WorkerHome.class);
                                               startActivity(i1);

                                           }
                                           else
                                           {
                                               Toast.makeText(getApplicationContext(), "Please enter valid credentails", Toast.LENGTH_SHORT).show();
                                           }
                                           break;


                                   }



                           }

                           @Override
                           public void handleFault(BackendlessFault fault) {
                               Log.e("MYAPP", "Server reported an error " + fault.getMessage());
                           }
                       });

                   }
                   else {
                       password.setError("Please enter password");
                       //Toast.makeText(LoginActivity.this,
                       // "Please enter password", Toast.LENGTH_SHORT).show();
                   }


//                            else {
//                           Toast.makeText(LoginActivity.this,
//                                   "Please enter valid credentials", Toast.LENGTH_SHORT).show();
//                       }
               }

            else {
                   email.setError("Please enter email address");
                   // Toast.makeText(LoginActivity.this,
                   // "Please enter email address", Toast.LENGTH_SHORT).show();
               }}
            else {
               //radioSexButton.setError("Please select either Employer or Worker");
               Toast.makeText(LoginActivity.this,
                       "Please select either Employer or Worker", Toast.LENGTH_SHORT).show();
           }

       }


    public void NewuserAction(View v){
        Intent it = new Intent(this,Registration.class);
        startActivity(it);
    }



//    public void onSubmit(View view){
//
//        // Is the button now checked?
//
//    }
//    private boolean isEmailValid(String email) {
//        //TODO: Replace this with your own logic
//        return email.contains("@");
//    }
//
//    private boolean isPasswordValid(String password) {
//        //TODO: Replace this with your own logic
//        return password.length() > 4;
//    }
//
//    /**
//     * Shows the progress UI and hides the login form.
//     */
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//    private void showProgress(final boolean show) {
//        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
//        // for very easy animations. If available, use these APIs to fade-in
//        // the progress spinner.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
//    }
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
//        return new CursorLoader(this,
//                // Retrieve data rows for the device user's 'profile' contact.
//                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
//                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,
//
//                // Select only email addresses.
//                ContactsContract.Contacts.Data.MIMETYPE +
//                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
//                .CONTENT_ITEM_TYPE},
//
//                // Show primary email addresses first. Note that there won't be
//                // a primary email address if the user hasn't specified one.
//                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
//        List<String> emails = new ArrayList<>();
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            emails.add(cursor.getString(ProfileQuery.ADDRESS));
//            cursor.moveToNext();
//        }
//
//        addEmailsToAutoComplete(emails);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> cursorLoader) {
//
//    }


//    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
//        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
//        ArrayAdapter<String> adapter =
//                new ArrayAdapter<>(LoginActivity.this,
//                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);
//
//        mEmailView.setAdapter(adapter);
//    }
//
//
//    private interface ProfileQuery {
//        String[] PROJECTION = {
//                ContactsContract.CommonDataKinds.Email.ADDRESS,
//                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
//        };
//
//        int ADDRESS = 0;
//        int IS_PRIMARY = 1;
//    }
//
//    /**
//     * Represents an asynchronous login/registration task used to authenticate
//     * the user.
//     */
//    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

//        private final String mEmail;
//        private final String mPassword;
//
//        UserLoginTask(String email, String password) {
//            mEmail = email;
//            mPassword = password;
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... params) {
//            // TODO: attempt authentication against a network service.
//
//            try {
//                // Simulate network access.
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                return false;
//            }
//
//            for (String credential : DUMMY_CREDENTIALS) {
//                String[] pieces = credential.split(":");
//                if (pieces[0].equals(mEmail)) {
//                    // Account exists, return true if the password matches.
//                    return pieces[1].equals(mPassword);
//                }
//            }
//
//            // TODO: register the new account here.
//            return true;
//        }

//        @Override
//        protected void onPostExecute(final Boolean success) {
//            mAuthTask = null;
//            showProgress(false);
//
//            if (success) {
//                finish();
//            } else {
//                mPasswordView.setError(getString(R.string.error_incorrect_password));
//                mPasswordView.requestFocus();
//            }
//        }
//
//        @Override
//        protected void onCancelled() {
//            mAuthTask = null;
//            showProgress(false);
//        }
//    }
}

