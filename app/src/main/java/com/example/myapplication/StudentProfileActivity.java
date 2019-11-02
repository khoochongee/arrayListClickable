package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentProfileActivity extends AppCompatActivity {
    private String selfIntro="Hi my Name is [name]. \nMy Student ID is [studentID] \nI am a [course] student";
    private String studentName,studentID,studentCourse;
    private TextView tvSelfIntro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        studentName=getIntent().getStringExtra("name");
        studentID=getIntent().getStringExtra("id");
        studentCourse=getIntent().getStringExtra("course");
        replaceData();

        tvSelfIntro=findViewById(R.id.studentSelfIntro);
        tvSelfIntro.setText(selfIntro);
    }

    private void replaceData(){
        selfIntro = selfIntro.replace("[name]",studentName);
        selfIntro = selfIntro.replace("[studentID]",studentID);
        selfIntro = selfIntro.replace("[course]",studentCourse);
    }
}
