package com.example.tugasakhirmodulbmaap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class About_Me : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setTitle("About Me")
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId.equals(R.id.akun)){
            val intent = Intent(this@About_Me, About_Me::class.java)
            startActivity(intent)
        }
        else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }
}