package com.example.sqlitekashy

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edtname: EditText
    lateinit var edtmail: EditText
    lateinit var  edtid: EditText
    lateinit var btnsave:Button
    lateinit var btnview:Button
    lateinit var btndelete:Button

    lateinit var db:SQLiteDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname = findViewById(R.id.edtname)
        edtmail = findViewById(R.id.edtmail)
        edtid = findViewById(R.id.edtid)
        btnsave = findViewById(R.id.btnsave)
        btnview = findViewById(R.id.btnview)
        btndelete = findViewById(R.id.btndelete)

        //CREATING OUR DATABASE
        db= openOrCreateDatabase("Kashydb", Context.MODE_PRIVATE, null)
        //creating our tables
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")

        btnsave.setOnClickListener {
            var jina_edt = edtname.text.toString().trim()
            var arafa_edt = edtmail.text.toString().trim()
            var kitambulisho_edt = edtid.text.toString().trim()

            //validate your text
            if (jina_edt.isEmpty()|| arafa_edt.isEmpty()|| kitambulisho_edt.isEmpty()){
                Toast.makeText(this,"Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            }else{
                //insert data
                db.execSQL("INSERT INTO users VALUES( '\"+jina_edt+\"', '\"+arafa_edt+\"' , '\"+kitambulisho_edt+\"')")

                Toast.makeText(this, "Data Saved Succesfully", Toast.LENGTH_SHORT).show()
            }
        }

    }
}