package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class BookProfile extends AppCompatActivity {
    TextView tvBookName,tvBookCategory,tvBookAuthor,tvBookPublishedYear,tvBookDescription,tvBookStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_profile);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvBookName=findViewById(R.id.tvBookName);
        tvBookCategory=findViewById(R.id.tvBookCategory);
        tvBookAuthor=findViewById(R.id.tvBookAuthor);
        tvBookPublishedYear=findViewById(R.id.tvBookPublishedYear);
        tvBookDescription=findViewById(R.id.tvBookDescription);
        tvBookStatus=findViewById(R.id.tvBookStatus);

        String BookName=getIntent().getStringExtra("bookName");
        String BookCategory=getIntent().getStringExtra("bookCategory");
        String BookAuthor=getIntent().getStringExtra("bookAuthor");
        String BookPublishedYear=getIntent().getStringExtra("bookPublishedYear");
        String BookDescription=getIntent().getStringExtra("bookDescription");
        String BookStatus=getIntent().getStringExtra("bookStatus");

        tvBookName.setText(BookName);
        tvBookCategory.setText(BookCategory);
        tvBookAuthor.setText(BookAuthor);
        tvBookPublishedYear.setText(BookPublishedYear);
        tvBookDescription.setText(BookDescription);
        tvBookStatus.setText(BookStatus);
    }
}
