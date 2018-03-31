package com.example.root.loginsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view){

        if (view.getId() == R.id.Blogin)
        {

            EditText a = (EditText) findViewById(R.id.Eusername);
            String user = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.Epassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(user);

            if (pass.equals(password))
            {
                Intent intent = new Intent(MainActivity.this , Display.class);
                intent.putExtra("",user);
                startActivity(intent);
            }else
                {
                    Toast.makeText(MainActivity.this,"Password worng",Toast.LENGTH_LONG).show();
                }


        }
        if (view.getId() == R.id.Bsign1)
        {
            Intent intent = new Intent(MainActivity.this , SignUp.class);

            startActivity(intent);
        }

    }

}
