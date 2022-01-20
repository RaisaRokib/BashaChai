package com.example.bashachai;

/*import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    /*EditText etmail,etpass,etname,etconpass,etphn;
    ImageButton btnlogin;*/
    /*TextInputLayout regName,regUsername,regEmail,regPhoneNo,regPassword;
    ImageButton regBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        regName=findViewById(R.id.name);
        regUsername=findViewById(R.id.username);
        regEmail=findViewById(R.id.email);
        regPhoneNo=findViewById(R.id.phone);
        regPassword=findViewById(R.id.password);
        regBtn=findViewById(R.id.lg);}

        private Boolean validateName() {
            String val = regName.getEditText().getText().toString();
            if (val.isEmpty()) {
                regName.setError("Full Name required");
                return false;
            } else {
                regName.setError(null);
                return true;
            }
        }
        private Boolean validateUserName() {
            String val = regUsername.getEditText().getText().toString();
            String noWhitespace = "\\A\\w{4,20}\\z";
            if (val.isEmpty()) {
                regUsername.setError("UserName required");
                return false;
            } else if (val.length() >= 15) {
                regUsername.setError("UserName too long");
                return false;
            } else if (!val.matches(noWhitespace)) {
                regUsername.setError("Spaces are not allowed");
                return false;
            } else {
                regUsername.setError(null);
                regUsername.setErrorEnabled(false);
                return true;
            }
        }
        private Boolean validateEmail() {
            String val = regEmail.getEditText().getText().toString();
            String emailPattern="[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (val.isEmpty()) {
                regEmail.setError("Email required");
                return false;

            }
            else if(val.matches(emailPattern)){
                regEmail.setError("Invalid Email Address");
                return false;
            }
            else  {
                regEmail.setError(null);
                regUsername.setErrorEnabled(false);
                return true;
            }
        }
        private Boolean validatePhoneNo() {
            String val = regPhoneNo.getEditText().getText().toString();
            if (val.isEmpty()) {
                regPhoneNo.setError("Phone number required");
                return false;
            } else {
                regPhoneNo.setError(null);
                return true;
            }
        }
        private Boolean validatePassword() {
            String val = regPassword.getEditText().getText().toString();
            String passwordVal="^"+
                    "(?=.*[a-zA-Z])"+ //any letter
                    "(?=.[@#$%^&+=])"+ //atleast 1 special character
                    "(?=\\S+$)"+ //no white spaces
                    "$";
            if (val.isEmpty()) {
                regPassword.setError("Password required");
                return false;
            } else if(val.matches(passwordVal)) {
                regPassword.setError("Password is too weak");
                return false;
            }
            else {
                regPassword.setError(null);
                regPassword.setErrorEnabled(false);
                return true;
            }
        }
                public void regBtn(View view) {
                    rootNode=FirebaseDatabase.getInstance();
                    reference=rootNode.getReference("users");
                    if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUserName())
                    {
                        return;
                    }
                    String name=regName.getEditText().getText().toString();
                    String username=regUsername.getEditText().getText().toString();
                    String email=regEmail.getEditText().getText().toString();
                    String phoneNo=regPhoneNo.getEditText().getText().toString();
                    String password=regPassword.getEditText().getText().toString();
                    UserHelperClass helperClass=new UserHelperClass(name,username,email,phoneNo,password);
                    reference.child(phoneNo).setValue(helperClass);

                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();

                }







    }*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    ImageButton regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);
        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_Email);
        regPhoneNo = findViewById(R.id.reg_PhoneNo);
        regPassword = findViewById(R.id.reg_Password);
        regBtn = (ImageButton) findViewById(R.id.reg_btn);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                registerUser(view);
            }
        });
    }

    private Boolean validateName() {
        String val = regName.getEditText().getText().toString();

        if (val.isEmpty()) {
            regName.setError("Fullname required");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (val.isEmpty()) {
            regUsername.setError("Username required");
            return false;
        } else if (val.length() >= 15) {
            regUsername.setError("Username is too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("Spaces are not valid");
            return false;
        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Email required");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = regPhoneNo.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPhoneNo.setError("Phone number required");
            return false;
        } else {
            regPhoneNo.setError(null);
            regPhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            regPassword.setError("Password required");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Password is too weak");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }


    public void registerUser(View view) {
        if (!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()) {
            return;
        }
        //get all the values
        String name = regName.getEditText().getText().toString();
        String username = regUsername.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
}
