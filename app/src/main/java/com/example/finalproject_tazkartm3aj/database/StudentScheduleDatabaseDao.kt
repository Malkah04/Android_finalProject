package com.example.finalproject_tazkartm3aj.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.finalproject_tazkartm3aj.model.Schedule
import com.example.finalproject_tazkartm3aj.model.StudentScheduleCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentScheduleDatabaseDao {
    @Insert
    suspend fun addLecToStudentSchedule(crossRef: StudentScheduleCrossRef)

    @Delete
    suspend fun deleteLecFromStudentSchedule(crossRef: StudentScheduleCrossRef)


    @Transaction
    @Query("""
        select 
            S.*
        from 
            Schedule S
        inner join
            studentScheduleCrossRef as SS 
        on 
            S._id = SS.schedule_id
        where
            SS.student_id = :studentId
        
    """)
    fun getStudentSchedule(studentId:Int) : Flow<List<Schedule>>


}