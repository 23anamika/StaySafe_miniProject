package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Scream : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scream)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener(View.OnClickListener
        { openMaleScream()
        })
        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(View.OnClickListener { openPoliceSiren() })
        button1.setOnClickListener(View.OnClickListener { openFemaleScream() })
    }

    fun openPoliceSiren() {
        val intent = Intent(this, PoliceSiren::class.java)
        startActivity(intent)
    }

    fun openMaleScream() {
        val intent = Intent(this, MaleScream::class.java)
        startActivity(intent)
    }

    fun openFemaleScream() {
        val intent = Intent(this, FemaleScream::class.java)
        startActivity(intent)
    }
}
