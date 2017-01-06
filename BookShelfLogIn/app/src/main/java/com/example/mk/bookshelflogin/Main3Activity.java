package com.example.mk.bookshelflogin;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    EditText nm, age, eml, pwd, cpwd;
    Button signup;

    String n, a, em, p, cp;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nm = (EditText)findViewById(R.id.nm);
        age = (EditText)findViewById(R.id.age);
        eml = (EditText)findViewById(R.id.eml);
        pwd = (EditText)findViewById(R.id.pwd);
        cpwd = (EditText)findViewById(R.id.cpwd);

        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);

        db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age VARCHAR, email VARCHAR, pwd VARCHAR);");
    }

    @Override
    public void onClick(View v) {
        n = nm.getText().toString().trim();
        a = age.getText().toString().trim();
        em = eml.getText().toString().trim();
        p = pwd.getText().toString().trim();
        cp = cpwd.getText().toString().trim();

        if (n.equals("")||a.equals("")||em.equals("")||p.equals("")||cp.equals("")) {
            Toast.makeText(this, "Make sure to Enter all fields !!", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            db=openOrCreateDatabase("emp", Context.MODE_PRIVATE,null);
            db.execSQL("INSERT INTO users VALUES('"+n+"','"+a+"','"+em+"','"+p+"');");
            Toast.makeText(this, "Sign Up Success !!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Log In to Continue", Toast.LENGTH_SHORT).show();
            Intent i1 = new Intent(this, MainActivity.class);
            startActivity(i1);
        }
    }
}
