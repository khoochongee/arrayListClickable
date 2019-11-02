package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.myapplication.dataModel.Student;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvStudent;
    private ArrayList<Student> arrayListStudents=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStudent=findViewById(R.id.lv_Student);

        arrayListStudents.add(new Student("Khoo Chong Ee","1850144","DWD"));
        arrayListStudents.add(new Student("Tan Kahng Vee","1850328","DIT"));
        arrayListStudents.add(new Student("Tan Guan Hong","1850145","DWD"));
        arrayListStudents.add(new Student("Steve","1850121","DCY"));
        arrayListStudents.add(new Student("Bryant","1850114","DCY"));
        arrayListStudents.add(new Student("Khoo Chong Ee","1850144","DWD"));
        arrayListStudents.add(new Student("Tan Kahng Vee","1850328","DIT"));
        arrayListStudents.add(new Student("Tan Guan Hong","1850145","DWD"));
        arrayListStudents.add(new Student("Steve","1850121","DCY"));
        arrayListStudents.add(new Student("Bryant","1850114","DCY"));
        arrayListStudents.add(new Student("Khoo Chong Ee","1850144","DWD"));
        arrayListStudents.add(new Student("Tan Kahng Vee","1850328","DIT"));
        arrayListStudents.add(new Student("Tan Guan Hong","1850145","DWD"));
        arrayListStudents.add(new Student("Steve","1850121","DCY"));
        arrayListStudents.add(new Student("Bryant","1850114","DCY"));

        StudentAdapter adapter=new StudentAdapter(arrayListStudents,this);
        lvStudent.setAdapter(adapter);
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student =(Student)parent.getAdapter().getItem(position);
                Intent i=new Intent(MainActivity.this,StudentProfileActivity.class);
                i.putExtra("name",student.getStudentName());
                i.putExtra("id",student.getStudentID());
                i.putExtra("course",student.getStudentCourse());
                startActivity(i);
            }
        });

    }
}
