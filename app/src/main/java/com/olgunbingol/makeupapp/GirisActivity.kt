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
import com.olgunbingol.makeupapp.databinding.ActivityGirisBinding

private lateinit var binding: ActivityGirisBinding
private lateinit var auth : FirebaseAuth

class GirisActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris)
        binding = ActivityGirisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth
    }
    fun signClicked(view: View) {
       val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.isNullOrEmpty() && password.isNullOrEmpty()) {
            Toast.makeText(this@GirisActivity,"Kullanıcı adı veya Parola boş olamaz.",Toast.LENGTH_LONG).show()
        }
        else {
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@GirisActivity,MainActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this@GirisActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }


        }



    }
    fun upsignClicked(view: View) {
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()
        if(email.isNullOrEmpty() && password.isNullOrEmpty()) {
            Toast.makeText(this@GirisActivity,"Kullanıcı adı veya Parola boş olamaz.",Toast.LENGTH_LONG).show()
        }
        else {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                Toast.makeText(this@GirisActivity,"Kullanıcı başarıyla oluşturuldu.",Toast.LENGTH_LONG).show()
                val intent = Intent(this@GirisActivity,MainActivity::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this@GirisActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

    }
}