package com.example.assignment2studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar


class StudentDetailsActivity : AppCompatActivity() {
    private val editStudentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Constants.RESULT_DELETE || result.resultCode == Constants.RESULT_UPDATE) {
                finish()
            }

}
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
        val checkBoxView: CheckBox = findViewById(R.id.list_row_check_box)
        val editButton: Button = findViewById(R.id.student_edit_button)

        nameTextView.text = intent.getStringExtra("studentName")
        idTextView.text = intent.getStringExtra("studentId")
        phoneTextView.text = intent.getStringExtra("studentPhone")
        addressTextView.text = intent.getStringExtra("studentAddress")
        val isChecked = intent.getBooleanExtra("studentChecked", false)
        checkBoxView.isChecked = isChecked

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java).apply {
                putExtra("studentName", nameTextView.text.toString())
                putExtra("studentId", idTextView.text.toString())
                putExtra("studentPhone", phoneTextView.text.toString())
                putExtra("studentAddress", addressTextView.text.toString())
                putExtra("isChecked", checkBoxView.isChecked)
            }

            editStudentLauncher.launch(intent)
        }

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)

        toolbar.setNavigationOnClickListener {
            finish()
    }
}}