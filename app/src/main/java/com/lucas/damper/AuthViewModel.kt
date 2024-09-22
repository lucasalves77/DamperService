package com.lucas.damper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    private val _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> = _authState

    init {
        checkAuthStatus()
    }

    private fun updateAuthState(state: AuthState) {
        _authState.value = state
    }

    fun checkAuthStatus() {
        val currentUser = auth.currentUser
        updateAuthState(
            if (currentUser != null) AuthState.Authenticated
            else AuthState.Unauthenticated
        )
    }

    fun login(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            updateAuthState(AuthState.Error("Email and password cannot be empty"))
            return
        }

        updateAuthState(AuthState.Loading)
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateAuthState(AuthState.Authenticated)
                } else {
                    val errorMessage = task.exception?.message ?: "Login failed"
                    updateAuthState(AuthState.Error(errorMessage))
                }
            }
    }

    fun signup(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            updateAuthState(AuthState.Error("Email and password cannot be empty"))
            return
        }

        updateAuthState(AuthState.Loading)
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    updateAuthState(AuthState.Authenticated)
                } else {
                    val errorMessage = task.exception?.message ?: "Signup failed"
                    updateAuthState(AuthState.Error(errorMessage))
                }
            }
    }

    fun signout() {
        auth.signOut()
        _authState.value = AuthState.Unauthenticated
    }

    // Novo método para enviar e-mail de redefinição de senha
    fun sendPasswordResetEmail(email: String) {
        _authState.value = AuthState.Loading
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _authState.value = AuthState.PasswordResetEmailSent
                } else {
                    _authState.value = AuthState.Error(task.exception?.message ?: "Unknown error")
                }
            }
    }


}

sealed class AuthState {
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    object PasswordResetEmailSent : AuthState() // Novo estado para reset de senha
    data class Error(val message: String) : AuthState()
}

