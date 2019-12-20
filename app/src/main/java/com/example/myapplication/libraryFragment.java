package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.libraryFunctions.about_us;
import com.example.myapplication.libraryFunctions.bookSearch;
import com.example.myapplication.libraryFunctions.regulations;
import com.example.myapplication.libraryFunctions.user_guides;


public class libraryFragment extends Fragment {
    private CardView cvBookSearch,cvUserGuides,cvRegulations,cvAboutUs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_library,container,false);

        cvBookSearch=v.findViewById(R.id.book_search);
        cvUserGuides=v.findViewById(R.id.user_guides);
        cvRegulations=v.findViewById(R.id.regulations);
        cvAboutUs=v.findViewById(R.id.about_us);

        cvBookSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),bookSearch.class);
                startActivity(i);
            }
        });
        cvUserGuides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),user_guides.class);
                startActivity(i);
            }
        });
        cvRegulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),regulations.class);
                startActivity(i);
            }
        });
        cvAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),about_us.class);
                startActivity(i);
            }
        });

        return v;
    }

}

