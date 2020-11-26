package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var btnLogout: Button? = null
    var mFirebaseAuth: FirebaseAuth? = null

lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView:NavigationView

    private val mAuthStateListener: AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout=findViewById(R.id.drawer_layout)
        navView= findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener(this)





        val toggle=ActionBarDrawerToggle(
                this, drawerLayout, toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)


        btnLogout = findViewById(R.id.logout)
       val btnscream = findViewById<Button>(R.id.button)
        val btnLocation = findViewById<Button>(R.id.button3)
        btnLocation!!.setOnClickListener(
                {
                    openLocation()
                }
        )
        val btnFakeCall = findViewById<Button>(R.id.button4)
        btnFakeCall!!.setOnClickListener(
                {
                    openFakeCall()
                }
        )
        val btnSetting = findViewById<Button>(R.id.button14)
        btnSetting!!.setOnClickListener(
                {
                    openSetting()
                }
        )
        val btnAbout = findViewById<Button>(R.id.button15)
        btnAbout!!.setOnClickListener(
                {
                    openAbout()
                }
        )
        val btnsiren = findViewById<Button>(R.id.button5)
        btnLogout!!.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intToMain = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(intToMain)
        }

        btnsiren.setOnClickListener(
                {
                    openSiren()
                }
        )

        btnscream.setOnClickListener(
                {
                    openScream()
                }
        )
    }
    fun openSetting(){
        val intent = Intent(this, Settings::class.java)
        startActivity(intent)
    }
    fun openAbout(){
        val intent = Intent(this, AboutUs::class.java)
        startActivity(intent)
    }
    fun openScream()
    {
        val intent = Intent(this, Scream::class.java)
        startActivity(intent)
    }
    fun openSiren(){
        val intent = Intent(this, PoliceSiren::class.java)
        startActivity(intent)
    }

    fun openLocation(){
        val intent = Intent(this, Location::class.java)
        startActivity(intent)
    }
    fun openFakeCall()
    {
        val intent = Intent(this, FakeCall::class.java)
        startActivity(intent)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        TODO("Not yet implemented")


        when(item.itemId)
        {
            R.id.nav_profile -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_about -> {
                val intent = Intent(this, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_messages -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.settings -> {
                val intent = Intent(this, Settings::class.java)
                startActivity(intent)

            }

            R.id.logout -> {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }


        }
        drawerLayout.closeDrawer(GravityCompat
                .START)
        return true
    }
}






