package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val fragment = StartFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment,fragment)
                .commit()
        }
    }

}
