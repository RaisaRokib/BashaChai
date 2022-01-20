package com.example.bashachai;

/*import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button callsSignup,login_btn;
    ImageView image;
    TextView logotext,sloganText;
    TextInputLayout username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
    }
    private Boolean validateUserName() {
        String val = username.getEditText().getText().toString();
        if (val.isEmpty()) {
            username.setError("UserName required");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        if (val.isEmpty()) {
            password.setError("Password required");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


        public void regBtn(View view) {
            Intent intent = new Intent(getApplicationContext(), Signup.class);
            startActivity(intent);
            finish();
        }
        public void loginUser(View view){
            if (!validateUserName() | !validatePassword()) {
                return;
            }
            else{
                isUser();
            }
        }
        private void isUser()

        {
            String userEnteredUsername= username.getEditText().getText().toString().trim();
            String userEnteredPassword= password.getEditText().getText().toString().trim();
            DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
            Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String passwordFromDB=dataSnapshot.child(userEnteredPassword).child("password").getValue(String.class);
                        Toast.makeText(getApplicationContext(),"WELCOME TO BashaChai", Toast.LENGTH_SHORT).show();
                        if(passwordFromDB.equals("258369")) {
                            Toast.makeText(getApplicationContext(),"WELCOME ", Toast.LENGTH_SHORT).show();
                            username.setError(null);
                            username.setErrorEnabled(false);

                            String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                            String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                            String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                            String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("username", usernameFromDB);
                            intent.putExtra("email", emailFromDB);
                            intent.putExtra("phoneNo", phoneNoFromDB);
                            intent.putExtra("password", passwordFromDB);

                            startActivity(intent);
                        }
                        else{
                            password.setError("Wrong Password");
                            password.requestFocus();
                        }
                    }
                    else{
                        username.setError("No such user exist");
                        username.requestFocus();

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }*/

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private Button signUpButton;
    private Button login;
    TextInputLayout username,password;
    ImageButton login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        //regEmail=findViewById(R.id.reg_Email);
        //regPhoneNo=findViewById(R.id.reg_PhoneNo);
        //regPassword=findViewById(R.id.reg_Password);

        signUpButton=(Button) findViewById(R.id.signup_screen);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });

        login_btn=findViewById(R.id.lg);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(view);
            }
        });
    }
    private Boolean validateUsername(){
        String val=username.getEditText().getText().toString();
        if(val.isEmpty()){
            username.setError("Username required");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val=password.getEditText().getText().toString();
        if(val.isEmpty()){
            password.setError("Password required");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    public void loginUser(View view){
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    public void isUser() {

        String userEnteredUsername=username.getEditText().getText().toString().trim();
        String userEnteredPassword=password.getEditText().getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUser=reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    username.setError(null);
                    username.setErrorEnabled(false);
                    String passwordFromDB=dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userEnteredPassword)){
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String nameFromDB=dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB=dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB=dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB=dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);

                        Intent intent=new Intent(getApplicationContext(),Menu.class);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("phoneNo",phoneNoFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);
                    }
                    else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }

                }
                else{
                    username.setError("No such User Exist");
                    username.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void openSignup(){
        Intent intent=new Intent(this,Signup.class);
        startActivity(intent);
    }

}
