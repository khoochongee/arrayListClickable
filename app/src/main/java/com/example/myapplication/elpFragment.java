package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.dataModel.UserData;
import com.example.myapplication.dataModel.UserDataManager;

import org.w3c.dom.Text;

public class elpFragment extends Fragment {
    private CalendarView calendarv;
    private TextView tvUsername;
    private String username;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    private TextView subSubject1,subSubject2,subSubject3,subSubject4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_elp,container,false);
        calendarv = v.findViewById(R.id.calendarView2);

        tvUsername=v.findViewById(R.id.Username);

        username = getActivity().getIntent().getExtras().getString("username");
        if(username==null){
            username=UserDataManager.getUserData(getContext()).getUsername();
        }
        tvUsername.setText(username);

        linearLayout1=v.findViewById(R.id.subject1);
        linearLayout2=v.findViewById(R.id.subject2);
        linearLayout3=v.findViewById(R.id.subject3);
        linearLayout4=v.findViewById(R.id.subject4);
        subSubject1=v.findViewById(R.id.subSubject1);
        subSubject2=v.findViewById(R.id.subSubject2);
        subSubject3=v.findViewById(R.id.subSubject3);
        subSubject4=v.findViewById(R.id.subSubject4);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject1.class);
                startActivity(i);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject2.class);
                startActivity(i);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject3.class);
                startActivity(i);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject4.class);
                startActivity(i);
            }
        });

        subSubject1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject1.class);
                startActivity(i);
            }
        });
        subSubject2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject2.class);
                startActivity(i);
            }
        });
        subSubject3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject3.class);
                startActivity(i);
            }
        });
        subSubject4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Subject4.class);
                startActivity(i);
            }
        });

        calendarv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth+"/"+(month+1)+"/"+year;
            }
        });
        return v;
    }
}
