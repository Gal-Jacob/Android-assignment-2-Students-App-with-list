package com.example.assignment2studentsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2studentsapp.adapter.StudentRecyclerAdapter
import com.example.assignment2studentsapp.model.Model
import com.example.assignment2studentsapp.model.Student

interface OnItemClickListener {
    fun onItemClick(position: Int, student: Student?)
}

class MainActivity : AppCompatActivity() {
    var students: MutableList<Student>? = null
    private lateinit var adapter: StudentRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
        val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentRecyclerAdapter(this, students)
        adapter.listener = object : OnItemClickListener {
            override fun onItemClick(position: Int, student: Student?) {
                Log.d("TAG", "$%$%$%$%$%$%$%$%")
            }
        }
        recyclerView.adapter = adapter

        val addStudentButton: Button = findViewById(R.id.add_student_button)
        addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
