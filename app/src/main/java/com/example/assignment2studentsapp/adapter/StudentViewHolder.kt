package com.example.assignment2studentsapp.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2studentsapp.OnItemClickListener
import com.example.assignment2studentsapp.R
import com.example.assignment2studentsapp.model.Student

class StudentViewHolder(
    itemView: View,
    listener: OnItemClickListener?
) : RecyclerView.ViewHolder(itemView){
    private var nameTextView: TextView? = null
    private var idTextView: TextView? = null
    private var studentCheckBox: CheckBox? = null
    private var student: Student? = null

    val itemLayout: View = itemView.findViewById(R.id.itemLayout)

    init {
        nameTextView = itemView.findViewById(R.id.list_row_student_name)
        idTextView = itemView.findViewById(R.id.list_row_student_id)
        studentCheckBox = itemView.findViewById(R.id.checkbox)

        studentCheckBox?.apply {
            setOnClickListener {
                (tag as? Int)?.let { tag ->
                    student?.isChecked = (it as? CheckBox)?.isChecked ?: false
                }
            }
        }

        itemView.setOnClickListener {
            listener?.onItemClick(adapterPosition, student)
        }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student
        nameTextView?.text = student?.name
        idTextView?.text = student?.id
        studentCheckBox?.apply {
            isChecked = student?.isChecked ?: false
            tag = position
        }
    }
}