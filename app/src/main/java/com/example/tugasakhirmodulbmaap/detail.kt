package com.example.tugasakhirmodulbmaap

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class detail: AppCompatActivity() {
    companion object {
        const val EXTRA_judul = "extra_judul"
        const val EXTRA_photo = "extra_photo"
        const val EXTRA_isi = "extra_isi"
        const val EXTRA_tanggal = "extra_tanggal"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val judul:TextView = findViewById(R.id.judul)
        val photo:ImageView = findViewById(R.id.photo)
        val tanggal:TextView = findViewById(R.id.tanggalrilis)
        val isi:TextView = findViewById(R.id.isi)

        judul.text = intent.getStringExtra(EXTRA_judul)
        tanggal.text = intent.getStringExtra(EXTRA_tanggal)
        isi.text = intent.getStringExtra(EXTRA_isi)
        photo.setImageResource(intent.getIntExtra(EXTRA_photo,0))
//        img.setImageResource(photo)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setTitle("Detail Artikel")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId.equals(R.id.akun)){
            val intent = Intent(this@detail, About_Me::class.java)
            startActivity(intent)
        }
        else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }

}