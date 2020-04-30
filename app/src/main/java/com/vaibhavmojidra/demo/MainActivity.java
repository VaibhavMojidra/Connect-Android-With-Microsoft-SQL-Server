package com.vaibhavmojidra.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnSignUp;
    EditText ebb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignUp=findViewById(R.id.Btn);
        ebb=findViewById(R.id.Eb);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DoItInBackground(MainActivity.this,ebb.getText().toString().trim()).execute();
            }
        });
    }
}
