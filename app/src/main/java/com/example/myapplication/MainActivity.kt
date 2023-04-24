package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.*
import com.example.myapplication.recycler.adapter.adpter
import com.example.myapplication.recycler.model.massenger
import com.example.myapplication.recycler.model.onListclike

class MainActivity : AppCompatActivity(), onListclike {

    lateinit var rec: RecyclerView
    lateinit var btn: Button
    lateinit var edt_msg: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        btn=findViewById(R.id.button2)
        rec=findViewById(R.id.recyclerView)
        edt_msg=findViewById(R.id.editTextText)




        var adpter: adpter = adpter()
        adpter.oncklic = this
        var mylist:ArrayList<massenger> =ArrayList()


        btn.setOnClickListener {
            var ms:massenger = massenger("Ahmed",edt_msg.text.toString(),R.drawable.ic_launcher_background)
            mylist.add(ms)
            adpter.setlist(mylist)
            edt_msg.setText("")
        }


        rec.setAdapter(adpter)


    }

    override fun onClikLicener(mess: massenger) {
        Toast.makeText(this, "ahmed", Toast.LENGTH_LONG).show()
    }
}