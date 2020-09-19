package com.example.lab2broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtInput;
    Button btnCheck;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput = findViewById(R.id.edtInput);
        btnCheck = findViewById(R.id.btnCheck);

        broadcastReceiver = new MyBroadcastReceiver();
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyBroadcastReceiver.class);
                intent.putExtra("data", edtInput.getText().toString());
                intent.setAction("fpoly.android.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });
    }
}