package com.example.assignment2studentsapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nameTextView: TextView = findViewById(R.id.student_name_text_view)
        val idTextView: TextView = findViewById(R.id.student_id_text_view)
        val phoneTextView: TextView = findViewById(R.id.student_phone_text_view)
        val addressTextView: TextView = findViewById(R.id.student_address_text_view)

        nameTextView.text = intent.getStringExtra("StudentName")
        idTextView.text = intent.getStringExtra("StudentName")
        phoneTextView.text = intent.getStringExtra("StudentName")
        addressTextView.text = intent.getStringExtra("StudentName")
    }
}