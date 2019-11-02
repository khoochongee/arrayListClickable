package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Function1 extends AppCompatActivity {
    private String selfIntro="Here is [name]";
    private String functionName;
    private TextView tvFunctionIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_profile);

        functionName=getIntent().getStringExtra("name");
        replaceData();

        tvFunctionIntro=findViewById(R.id.functionIntro);
        tvFunctionIntro.setText(selfIntro);
    }

    private void replaceData(){
        selfIntro = selfIntro.replace("[name]",functionName);
    }
}
