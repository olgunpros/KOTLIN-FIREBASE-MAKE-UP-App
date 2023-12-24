package com.olgunbingol.makeupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.olgunbingol.makeupapp.adapter.FeedRecyclerAdapter

private lateinit var auth : FirebaseAuth
private lateinit var db : FirebaseFirestore
private lateinit var postArrayList : ArrayList<Post>
private lateinit var feedAdapter : FeedRecyclerAdapter

class SampuanActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sampuan)
        auth = Firebase.auth
        db = Firebase.firestore
        postArrayList = ArrayList<Post>()
        getData()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        feedAdapter = FeedRecyclerAdapter(postArrayList)
        binding.recyclerView.adapter = feedAdapter


    }
    private fun getData() {
        db.collection("Posts").orderBy("date",
            Query.Direction.DESCENDING).addSnapshotListener { value, error ->
            if(error != null) {
                Toast.makeText(this@SampuanActivity,error.localizedMessage, Toast.LENGTH_LONG).show()

            }
            else {
                if(value!= null) {
                    if(!value.isEmpty) {
                        val documents = value.documents
                        postArrayList.clear()
                        for(document in documents) {
                            val comment = document.get("comment") as String
                            val userEmail = document.get("userEmail") as String
                            val downloadurl = document.get("downloadUrl") as String

                            val post = Post(userEmail,comment,downloadurl)
                            postArrayList.add(post)
                        }
                        feedAdapter.notifyDataSetChanged()
                    }
                }
            }
        }


    }
}