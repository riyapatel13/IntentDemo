package com.example.a10016322.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    static final int NUMBER_CODE = 12345;
    static final String CODE = "CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)(findViewById(R.id.button_id));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToOpenApp = new Intent(MainActivity.this, OtherApp.class);
                intentToOpenApp.putExtra("TEST", "This is a test");
                startActivityForResult(intentToOpenApp, NUMBER_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //automatically runs bc we said startActivityForResult
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NUMBER_CODE && resultCode == RESULT_OK) //if the app sending info is NUMBER_CODE, then do something
            Toast.makeText(this, data.getStringExtra(CODE), Toast.LENGTH_SHORT).show();
    }
}
