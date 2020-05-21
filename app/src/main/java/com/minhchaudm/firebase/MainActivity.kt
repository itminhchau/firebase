package com.minhchaudm.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var database: DatabaseReference

    init {
        database = FirebaseDatabase.getInstance().reference
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        database.child("Ten").setValue("Đào Minh Châu")
//        database.child("TenKhoaHoc").push().setValue("Lập Trình PHP")
        database.child("Ten").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                var ten: String = p0.value.toString()
                txtten.text = ten
            }

        } )
        database.child("TenKhoaHoc").addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                var listKhoaHoc: String = p0.value.toString()
                txtkhoahoc.append(listKhoaHoc + "\n")
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                TODO("Not yet implemented")
            }

        })
    }
}
