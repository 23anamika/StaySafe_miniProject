package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.example.login.R
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import android.content.Intent
import com.example.login.HomeActivity
import com.example.login.LoginActivity
class MainActivity : AppCompatActivity() {

    var emailId : EditText?= null
    var password : EditText?= null
    var btnSignUp : Button?= null
    var tvSignIn : TextView?= null
    var mFirebaseAuth : FirebaseAuth?= null
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password= findViewById(R.id.editTextTextPassword);
        btnSignUp = findViewById(R.id.button2);
        tvSignIn = findViewById(R.id.textView);
        btnSignUp!!.setOnClickListener {
            val email = emailId!!.text.toString()
            val pwd = password!!.text.toString()
            if (email.isEmpty()) {
                emailId!!.error = "Please enter email id"
                emailId!!.requestFocus()
            } else if (pwd.isEmpty()) {
                password!!.error = "Please enter your password"
                password!!.requestFocus()
            } else if (email.isEmpty() && pwd.isEmpty()) {
                Toast.makeText(this@MainActivity, "Fields Are Empty!", Toast.LENGTH_SHORT).show()
            } else if (!(email.isEmpty() && pwd.isEmpty())) {
                mFirebaseAuth!!.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(
                    this@MainActivity,
                    OnCompleteListener<AuthResult?> { task ->
                        if (!task.isSuccessful) {
                            Toast.makeText(
                                this@MainActivity,
                                "SignUp Unsuccessful, Please Try Again",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                        }
                    })
            } else {
                Toast.makeText(this@MainActivity, "Error Occurred!", Toast.LENGTH_SHORT).show()
            }
        }
        tvSignIn!!.setOnClickListener {
            val i = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(i)
        }
    }
}

