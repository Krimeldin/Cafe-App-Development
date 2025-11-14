package com.example.cafeapp_karim.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    var isLoading by mutableStateOf(false)
    var isLoggedIn by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        isLoading = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    isLoggedIn = true
                    onResult(true)
                } else {
                    errorMessage = task.exception?.message ?: "Login failed"
                    onResult(false)
                }
            }
    }

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        isLoading = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    isLoggedIn = true
                    onResult(true)
                } else {
                    errorMessage = task.exception?.message ?: "Registration failed"
                    onResult(false)
                }
            }
    }

    fun logout() {
        auth.signOut()
        isLoggedIn = false
    }
}
