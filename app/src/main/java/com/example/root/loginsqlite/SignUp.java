package com.example.root.loginsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick (View view){
        if(view.getId() == R.id.Bsignup2)
        {
            EditText name = (EditText) findViewById(R.id.Ename);
            EditText email = (EditText) findViewById(R.id.Eemail);
            EditText user = (EditText) findViewById(R.id.Eusername2);
            EditText pass1 = (EditText) findViewById(R.id.Epass1);
            EditText pass2 = (EditText) findViewById(R.id.Epass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String userstr = user.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if (!pass1str.equals(pass2str))
            {
              Toast pass =  Toast.makeText(SignUp.this,"Password Do not match",Toast.LENGTH_LONG);
              pass.show();
            }else
                {
                    // insert data in db
                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setUname(userstr);
                    c.setPass(pass1str);

                    helper.insertContact(c);
                    Toast.makeText(SignUp.this,"Signed up",Toast.LENGTH_LONG).show();
                }

        }
    }

}
