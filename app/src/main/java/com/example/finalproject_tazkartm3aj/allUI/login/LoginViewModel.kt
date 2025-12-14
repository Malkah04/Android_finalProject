package com.example.finalproject_tazkartm3aj.allUI.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject_tazkartm3aj.repository.studentRep.StudentRepository
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: StudentRepository
) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf<String?>(null)

    fun login(
        onEmailNotFound: () -> Unit,
        onLoginSuccess: () -> Unit
    ) {
        errorMessage = when {
            email.isBlank() -> "Email is required"
            !email.contains("@") -> "Invalid email address "
            password.isBlank() -> "Password is required"
            else -> null
        }
        if (errorMessage != null) return

        viewModelScope.launch {
            val student = repository.getStudentByEmail(email)

            when {
                student == null -> {
                    onEmailNotFound()
                }

                student.password != password -> {
                    errorMessage = "Wrong password"
                }

                else -> {
                    onLoginSuccess()
                }
            }
        }
    }
}