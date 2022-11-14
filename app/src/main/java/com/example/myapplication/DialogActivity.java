package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends AppCompatActivity {

    private Button btn_dialog_back, btn_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        setTitle("DIALOG");

        btn_dialog_back = (Button) findViewById(R.id.btn_dialog_back);
        btn_dialog_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(DialogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_alert = (Button) findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DialogActivity.this);
                dialog.setMessage("Alert").setTitle("AlertDialog").setIcon(android.R.drawable.presence_away)
                        .show();
            }
        });
    }
}