package com.example.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
class LoginActivity : AppCompatActivity() {
    var emailId: EditText? = null
    var password: EditText? = null
    var btnSignIn: Button? = null
    var tvSignUp: TextView? = null
    var mFirebaseAuth: FirebaseAuth? = null
    private var mAuthStateListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextTextEmailAddress);
        password= findViewById(R.id.editTextTextPassword);
        btnSignIn = findViewById(R.id.button2);
        tvSignUp = findViewById(R.id.textView);
        mAuthStateListener = AuthStateListener {
            val mFirebaseUser = mFirebaseAuth!!.currentUser
            if (mFirebaseUser != null) {
                Toast.makeText(this@LoginActivity, "You are logged in", Toast.LENGTH_SHORT).show()
                val i = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this@LoginActivity, "Please Login", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignIn!!.setOnClickListener {
            val email = emailId!!.text.toString()
            val pwd = password!!.text.toString()
            if (email.isEmpty()) {
                emailId!!.error = "Please enter email id"
                emailId!!.requestFocus()
            } else if (pwd.isEmpty()) {
                password!!.error = "Please enter your password"
                password!!.requestFocus()
            } else if (email.isEmpty() && pwd.isEmpty()) {
                Toast.makeText(this@LoginActivity, "Fields Are Empty!", Toast.LENGTH_SHORT).show()
            } else if (!(email.isEmpty() && pwd.isEmpty())) {
                mFirebaseAuth!!.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(
                    this@LoginActivity,
                    OnCompleteListener<AuthResult?> { task ->
                        if (!task.isSuccessful) {
                            Toast.makeText(
                                this@LoginActivity,
                                "Login Error, Please Login Again",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val intToHome = Intent(this@LoginActivity, HomeActivity::class.java)
                            startActivity(intToHome)
                        }
                    })
            } else {
                Toast.makeText(this@LoginActivity, "Error Occurred!", Toast.LENGTH_SHORT).show()
            }
    }
        tvSignUp!!.setOnClickListener {
            val intSignUp = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intSignUp)
        }
    }

     override fun onStart() {
        super.onStart()
        mFirebaseAuth!!.addAuthStateListener(mAuthStateListener!!)
    }
}