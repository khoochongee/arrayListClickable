package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.myapplication.dataModel.LibraryFunction;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLibraryFunction;
    private ArrayList<LibraryFunction> arrayListFunctions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLibraryFunction=findViewById(R.id.lv_Student);

        arrayListFunctions.add(new LibraryFunction("BookSearch"));
        arrayListFunctions.add(new LibraryFunction("Online Public Access Catalogue(OPAC)"));
        arrayListFunctions.add(new LibraryFunction("User Guides"));
        arrayListFunctions.add(new LibraryFunction("Services"));
        arrayListFunctions.add(new LibraryFunction("Library Regulations"));
        arrayListFunctions.add(new LibraryFunction("About Us"));

        LibraryFunctionAdapter adapter=new LibraryFunctionAdapter(arrayListFunctions,this);
        lvLibraryFunction.setAdapter(adapter);
        lvLibraryFunction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LibraryFunction libraryFunction =(LibraryFunction)parent.getAdapter().getItem(position);
                Intent i=new Intent(MainActivity.this,Function1.class);
                i.putExtra("name",libraryFunction.getLibraryFunction());
                startActivity(i);
            }
        });

    }
}
