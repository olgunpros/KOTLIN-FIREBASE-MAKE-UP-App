package com.olgunbingol.makeupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.olgunbingol.makeupapp.databinding.ActivityAnamenuBinding
import com.olgunbingol.makeupapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var auth : FirebaseAuth
class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
    }
    fun sampuanClicked(view: View) {
        val intent = Intent(this@MainActivity,SampuanActivity::class.java)
        startActivity(intent)

    }
    fun dusjeliClicked(view: View) {
        val intent = Intent(this@MainActivity,DusjeliActivity::class.java)
        startActivity(intent)

    }
    fun nemlendiriciClicked(view: View) {
        val intent = Intent(this@MainActivity,NemlendiriciActivity::class.java)
        startActivity(intent)

    }
    fun signinClicked(view: View) {
        if(auth.currentUser != null ) {
            Toast.makeText(this@MainActivity,"Zaten giriş yapılmış.",Toast.LENGTH_SHORT).show()
        }
        else {
            val intent = Intent(this@MainActivity, GirisActivity::class.java)
            startActivity(intent)
        }
    }
    fun kremClicked(view: View) {
        val intent = Intent(this@MainActivity,SackremiActivity::class.java)
        startActivity(intent)

    }
    fun temizleyiciClicked(view: View) {
        val intent = Intent(this@MainActivity,TemizleyicilerActivity::class.java)
        startActivity(intent)

    }
    fun ekleClicked(view: View) {
        if (auth.currentUser == null) {
            Toast.makeText(this@MainActivity, "Önce giriş yapmalısın.", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this@MainActivity, EkleActivity::class.java)
            startActivity(intent)
        }
    }




}