package com.example.tugasakhirmodulbmaap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvartikel: RecyclerView
        private val list= ArrayList<artikel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvartikel=findViewById(R.id.rv_listartikel)
        rvartikel.setHasFixedSize(true)
        list.addAll(getlistartikel())
        rvartikel.layoutManager = LinearLayoutManager(this)
        val adapter = adapter(list)
        rvartikel.adapter= adapter

        adapter.setOnItemClickCallback(object : adapter.OnItemClickCallback {
            override fun onItemClicked(data: artikel) {
                showSelectedartikel(data)
            }
        })

        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setTitle("List Artikel")
        }
    }

    private fun getlistartikel(): ArrayList<artikel> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataisi = resources.getStringArray(R.array.isi)
        val datatanggalrilis = resources.getStringArray(R.array.tanggalrilis)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listartikel = ArrayList<artikel>()
        for (i in dataName.indices) {
            val hero = artikel(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1),datatanggalrilis[i],dataisi[i])
            listartikel.add(hero)
        }
        return listartikel

    }
    private fun showSelectedartikel(artikel: artikel) {
//        Toast.makeText(this, "Kamu memilih " + artikel.nama, Toast.LENGTH_SHORT).show()
        val intent = Intent(this@MainActivity,detail::class.java)
        intent.putExtra(detail.EXTRA_judul, artikel.nama)
        intent.putExtra(detail.EXTRA_photo, artikel.photo)
        intent.putExtra(detail.EXTRA_isi, artikel.isi)
        intent.putExtra(detail.EXTRA_tanggal, artikel.tanggalRilis)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId.equals(R.id.akun)){
            val intent = Intent(this@MainActivity, About_Me::class.java)
            startActivity(intent)
        }
        else{
            return super.onOptionsItemSelected(item)
        }
        return true
    }
}