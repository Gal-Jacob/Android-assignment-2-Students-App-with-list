package com.example.assignment2studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_add_student)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saveButton: Button = findViewById(R.id.add_student_save_button)
        val cancelButton: Button = findViewById(R.id.add_student_cancel_button)
        val studentNameEditText: EditText = findViewById(R.id.student_name_edit_text)
        val studentIdEditText: EditText = findViewById(R.id.student_id_edit_text)
        val studentPhoneEditText: EditText = findViewById(R.id.student_phone_edit_text)
        val studentAddressEditText: EditText = findViewById(R.id.student_address_edit_text)
        val checkBox: CheckBox = findViewById(R.id.list_row_check_box)

        saveButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        cancelButton.setOnClickListener {
            //close the activity
            finish()
        }
    }
}