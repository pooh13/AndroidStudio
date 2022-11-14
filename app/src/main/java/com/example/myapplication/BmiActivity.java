package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class BmiActivity extends AppCompatActivity {

    private Button btn_count, btn_bmi_back;
    private EditText input_height, input_weight;
    private TextView text_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        setTitle("BMI");

        input_height = (EditText) findViewById(R.id.input_height);
        input_weight = (EditText) findViewById(R.id.input_weight);
        btn_count = (Button) findViewById(R.id.btn_count);
        text_show = (TextView) findViewById(R.id.text_show);

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input_height.getText().length()!=0||input_weight.getText().length()!=0) {
                    float height = Float.parseFloat(input_height.getText().toString());
                    float weight = Float.parseFloat(input_weight.getText().toString());
                    float bmi = weight / ((height / 100) * (height / 100));
                    NumberFormat numberFormat = NumberFormat.getNumberInstance();
                    numberFormat.setMaximumFractionDigits(2);
                    text_show.setText("BMI：" + numberFormat.format(bmi));
                    if (bmi < 18.5) {
                        text_show.setText(text_show.getText() + "\n太瘦");
                    } else if (bmi >= 24) {
                        text_show.setText(text_show.getText() + "\n太胖拉");
                    } else if (bmi < 24 && bmi >= 18.5) {
                        text_show.setText(text_show.getText() + "\n完美體態");
                    }
                }else{
                    Toast.makeText(BmiActivity.this,"請輸入身高/體重",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_bmi_back = (Button) findViewById(R.id.btn_bmi_back);
        btn_bmi_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(BmiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}