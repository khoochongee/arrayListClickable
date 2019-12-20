package com.example.myapplication.libraryFunctions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.dataModel.BookListAdapter;
import com.example.myapplication.BookProfile;
import com.example.myapplication.R;
import com.example.myapplication.dataModel.BookList;
import com.google.common.io.ByteArrayDataInput;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class bookSearch extends AppCompatActivity {
    private ListView listView;
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private ArrayList<BookList> list;
    private BookListAdapter adapter;
    private BookList books;
    private SearchView searchView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_book_search);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        books= new BookList();
        listView =findViewById(R.id.book_list);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("books");
        list=new ArrayList<BookList>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i=0;
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    books=ds.getValue(BookList.class);
                    list.add(books);
                    System.out.println(list.get(i).getName());
                    System.out.println(list.get(i).getId());
                    System.out.println(list.get(i).getStatus());
                    System.out.println(list.get(i).getPublished_year());
                    System.out.println(list.get(i).getCategory());
                    System.out.println(list.get(i).getAuthor());
                    i++;
                }
                initialize();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initialize() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViews();
                setListeners();
            }
        });
    }

    public void findViews(){
        adapter=new BookListAdapter(this,list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        searchView=(SearchView)findViewById(R.id.search_book_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<BookList> results=new ArrayList<>();

                for(BookList x:list) {
                    if(x.getName().toLowerCase().trim().startsWith(newText.toLowerCase().trim())){
                        results.add(x);
                    }else if(x.getName().toLowerCase().trim().contains(newText.toLowerCase().trim())){
                        results.add(x);
                    }
                }

                adapter=new BookListAdapter(bookSearch.this,results);
                listView.setAdapter(adapter);
                return false;
            }
        });

    }
    public void setListeners(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(bookSearch.this, BookProfile.class);
                intent.putExtra("bookId",list.get(position).getId());
                intent.putExtra("bookName",list.get(position).getName());
                intent.putExtra("bookCategory",list.get(position).getCategory());
                intent.putExtra("bookAuthor",list.get(position).getAuthor());
                intent.putExtra("bookPublishedYear",list.get(position).getPublished_year());
                intent.putExtra("bookDescription",list.get(position).getDescription());
                intent.putExtra("bookStatus",list.get(position).getStatus());
                startActivity(intent);
            }
        });
    }

}


