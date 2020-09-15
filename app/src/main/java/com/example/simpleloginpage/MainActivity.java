package com.example.simpleloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username, password;
    private static TextView attempts;
    private static Button login;
    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickLoginButton();
    }

    public void onClickLoginButton(){
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.Password);
        attempts = (TextView)findViewById(R.id.attempts);
        login = (Button)findViewById(R.id.login);

        attempts.setText(Integer.toString(attempt_counter));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user") && password.getText().toString().equals("pass")){
                    Toast.makeText(MainActivity.this,"UserName and Password is corract",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                }
                else {
                    attempt_counter--;
                    attempts.setText(Integer.toString(attempt_counter));
                    Toast.makeText(MainActivity.this,"UserName and Password is Not corract",Toast.LENGTH_LONG).show();
                    if (attempt_counter == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });
    }
}