package com.example.assignment2studentsapp.adapter

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2studentsapp.OnItemClickListener
import com.example.assignment2studentsapp.R
import com.example.assignment2studentsapp.StudentDetailsActivity
import com.example.assignment2studentsapp.model.Student

class StudentRecyclerAdapter(
    private val context: Context,
    private val students: MutableList<Student>?
) :
    RecyclerView.Adapter<StudentViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_list_row,
            parent,
            false
        )

        return StudentViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(
            student = students?.get(position),
            position = position
        )


        holder.itemLayout.setOnClickListener {
            val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                putExtra("studentName", students?.get(position)?.name)
                putExtra("studentId", students?.get(position)?.id)
                putExtra("studentPhone", students?.get(position)?.phone)
                putExtra("studentAddress", students?.get(position)?.address)

            }

            if (context is Activity) {
                val options = ActivityOptions.makeCustomAnimation(
                    context,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                context.startActivity(intent, options.toBundle())
            }
        }
    }

    override fun getItemCount(): Int = students?.size ?: 0
}