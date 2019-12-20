package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.dataModel.Account;
import com.example.myapplication.dataModel.UserData;
import com.example.myapplication.dataModel.UserDataManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private String usernameString,passwordString;
    private EditText edUsername,edPassword;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private FirebaseDatabase database;
    private DatabaseReference ref;
    private Account account=new Account();
    private boolean checkAccount=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edUsername= findViewById(R.id.Username);
        edPassword= findViewById(R.id.Password);

        checkBox=findViewById(R.id.checkBox);
        if(checkLoginStatus()){
            OpenHomeActivity();
        }
    }
    public void Validation(View v) {
        usernameString=edUsername.getText().toString();
        passwordString=edPassword.getText().toString();

        if(usernameString.isEmpty() || passwordString.isEmpty()){
            Toast.makeText(this, "Please fill in the blank", Toast.LENGTH_SHORT).show();
            if(usernameString.isEmpty()) {
                edUsername.setError("Username is required");
            }
            if(passwordString.isEmpty()) {
                edPassword.setError("Password is required");
            }
        }else {
            database=FirebaseDatabase.getInstance();
            ref=database.getReference("account");

            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    for(DataSnapshot ds: dataSnapshot.getChildren()){
                        passwordString=edPassword.getText().toString();
                        account=ds.getValue(Account.class);

                        try {
                            passwordString=SHA256(passwordString);
                            Log.d("password is",passwordString);
                            if(usernameString.equals(account.getUsername())&&passwordString.equals(account.getPassword())){
                                checkAccount=true;
                                break;
                            }

                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }

                    }
                    if(checkAccount){
                        if (checkBox.isChecked()) {
                            UserData userData = new UserData();
                            userData.setLogin(true);
                            userData.setUsername(usernameString);
                            UserDataManager.saveUserData(MainActivity.this, userData);
                        }
                        OpenHomeActivity();
                    }else{
                        Toast.makeText(MainActivity.this, "Account Invalid, Please Try Again", Toast.LENGTH_LONG).show();
                        edPassword.setError("Invalid Account");
                    }

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("Failed...", "Failed to read value.", error.toException());
                }
            });

        }
    }

    private boolean checkLoginStatus(){
        UserData userData=UserDataManager.getUserData(this);
        return userData.isLogin();
    }

    public void OpenHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("username",usernameString);
        startActivity(intent);
        finish();
    }

    public static String SHA256(String text) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(text.getBytes(StandardCharsets.UTF_8));

        BigInteger number = new BigInteger(1, hash);

        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, 'c');
        }
        return hexString.toString();
    }
}
