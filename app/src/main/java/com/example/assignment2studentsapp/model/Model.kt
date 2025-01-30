package com.example.assignment2studentsapp.model

class Model private  constructor(){

    val students: MutableList<Student> = ArrayList()

    companion object {
        val shared = Model()
    }

    init {
        for (i in 1..10) {
            val student = Student(
                "Student $i",
                "$i",
                "050-0000000",
                "NANANANANA",
                false
            )
            students.add(student)
        }
    }
}