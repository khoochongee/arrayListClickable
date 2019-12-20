package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.dataModel.UserDataManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String username = getIntent().getExtras().getString("username");
        if(username!=null){
            Toast.makeText(HomeActivity.this, "Welcome "+username, Toast.LENGTH_SHORT).show();
        }else{
            username=UserDataManager.getUserData(HomeActivity.this).getUsername();
            Toast.makeText(HomeActivity.this, "Welcome Back "+username, Toast.LENGTH_SHORT).show();
        }

        BottomNavigationView btmNav=findViewById(R.id.btm_nav_view);
        btmNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new elpFragment()).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        UserDataManager.clearUserData(HomeActivity.this);
        finish();
        Intent i=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(i);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment= null;

            switch(menuItem.getItemId()) {
                case R.id.navigation_elp:
                    selectedFragment=new elpFragment();
                    break;
                case R.id.navigation_eNotice:
                    selectedFragment=new eNoticeFragment();
                    break;
                case R.id.navigation_library:
                    selectedFragment=new libraryFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

}
