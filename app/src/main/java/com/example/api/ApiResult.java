package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ApiResult extends AppCompatActivity {


    TextView textViewResultApi,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_result);

        textViewResultApi = findViewById(R.id.textViewResultApi);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        txt5 = findViewById(R.id.textView5);
        txt6 = findViewById(R.id.textView6);
        txt7 = findViewById(R.id.textView7);
        txt8 = findViewById(R.id.textView8);
        txt9 = findViewById(R.id.textView9);

    }
}