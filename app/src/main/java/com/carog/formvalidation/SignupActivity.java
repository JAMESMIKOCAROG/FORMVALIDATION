package com.carog.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText etusername, etpassword, etfullname,etconfirmpassword;
    TextView tvUserName, tvPassword, tvFullName,tvcofirmpass;
    String Username, Password, fullname, confirmpassword;
    int formsuccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        etfullname = findViewById(R.id.etfullname);
        etconfirmpassword = findViewById(R.id.etconfirmpassword);
        tvcofirmpass = findViewById(R.id.tvconfirmpass);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_cancel, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btnSave:
                formsuccess = 4;
                confirmpassword = etconfirmpassword.getText().toString();
                fullname = etfullname.getText().toString();
                Username = etusername.getText().toString();
                Password = etpassword.getText().toString();
                if(Username.equals("")){
                    etusername.setError("this field is required");
                    formsuccess--;
                }
                if(Password.equals("")){
                    etpassword.setError("this field is required");
                    formsuccess--;
                }
                if(fullname.equals("")){
                    etfullname.setError("this field is required");
                }
                if(confirmpassword.equals("")) {
                    etconfirmpassword.setError("this field is required");
                    formsuccess--;
                }
                if(formsuccess == 4){
                    Toast.makeText(this, "Form validated", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}