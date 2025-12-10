package com.example.finalproject_tazkartm3aj.repository.studentScheduleRep

import com.example.finalproject_tazkartm3aj.database.StudentScheduleDatabaseDao
import com.example.finalproject_tazkartm3aj.model.Schedule
import com.example.finalproject_tazkartm3aj.model.StudentScheduleCrossRef
import kotlinx.coroutines.flow.Flow

class OfflineStudentScheduleRepository(
    private val studentScheduleDatabaseDao: StudentScheduleDatabaseDao): StudentScheduleRepository {
    override suspend fun addLecToStudentSchedule(studentId: Int ,scheduleId:Int) = studentScheduleDatabaseDao.addLecToStudentSchedule(
        StudentScheduleCrossRef(StudentId=studentId ,ScheduleId=scheduleId ))

    override suspend fun deleteLecFromStudentSchedule(studentId: Int ,scheduleId:Int) =studentScheduleDatabaseDao.deleteLecFromStudentSchedule(
        StudentScheduleCrossRef(StudentId =studentId , ScheduleId = scheduleId )
    )
    override fun getStudentSchedule(studentId: Int): Flow<List<Schedule>> =studentScheduleDatabaseDao.getStudentSchedule(studentId)


}