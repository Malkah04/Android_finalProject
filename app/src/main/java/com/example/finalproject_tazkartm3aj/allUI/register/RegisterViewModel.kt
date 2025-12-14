package com.example.finalproject_tazkartm3aj.allUI.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject_tazkartm3aj.repository.studentRep.StudentRepository
import kotlinx.coroutines.launch

class RegisterViewModel (
    private val repository: StudentRepository
) : ViewModel() {

    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var phone by mutableStateOf("")
    var year by mutableStateOf("")
    var errorMessage by mutableStateOf<String?>(null)

    var registrationSuccess by mutableStateOf(false)
    fun register(onSuccess: () -> Unit) {
        errorMessage = when {
            name.isBlank() -> "Name required" //empty
            email.isBlank() -> "Email required"
            !email.contains("@") -> "Invalid email address "
            password.length < 6 -> "Password must be 6+ chars"
            phone.isBlank() -> "Phone required"
            year.isBlank() -> "Year required"
            else -> null
        }
            if (errorMessage != null) return

        viewModelScope.launch {
            val success = repository.register(name, email, phone, password, year)
            if (success) {
                registrationSuccess = true
                onSuccess()
            } else {
                errorMessage = "Email already exists"
            }
        }
    }
}