package com.example.a10016322.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OtherApp extends AppCompatActivity {

    Button button1;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_app);

        button1 = (Button)(findViewById(R.id.button1_id));
        editText = (EditText)(findViewById(R.id.editText_id));

        Toast.makeText(this, getIntent().getStringExtra("TEST"),Toast.LENGTH_SHORT).show();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(MainActivity.CODE, s);
                setResult(RESULT_OK, sendInfoBack);
                finish();
            }
        });
    }
}
