package com.example.finalproject_tazkartm3aj.repository.studentScheduleRep

import com.example.finalproject_tazkartm3aj.model.Schedule
import com.example.finalproject_tazkartm3aj.model.StudentScheduleCrossRef
import kotlinx.coroutines.flow.Flow

interface StudentScheduleRepository {
    suspend fun addLecToStudentSchedule(studentId: Int ,scheduleId:Int)

    suspend fun deleteLecFromStudentSchedule(studentId: Int ,scheduleId:Int)

    fun getStudentSchedule(studentId:Int) : Flow<List<Schedule>>
}