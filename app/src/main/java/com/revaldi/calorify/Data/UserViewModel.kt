package com.revaldi.calorify.Data

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.revaldi.calorify.Navigation.Screen
import com.revaldi.calorify.Network.ApiResponse
import com.revaldi.calorify.Network.RetrofitClient
import com.revaldi.calorify.Screen.BotNav
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel : ViewModel() {
    val username = mutableStateOf("")
    val nation = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    val birthday = mutableStateOf("")
    val gender = mutableStateOf("")
    val height = mutableStateOf("")
    val weight = mutableStateOf("")
    val activity = mutableStateOf("")
    val apiStatus = mutableStateOf("")
    val age = mutableStateOf("")

    fun registerNow(email: String, password: String, confirmPassword: String, navController: NavController){
        val newUser= NewUser(
            email = email,
            password = password,
            confirmPassword = confirmPassword
        )
        RetrofitClient.api.registerUser(newUser).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(navController.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(Screen.UsernamePersonalization.route)
                } else {
                    Toast.makeText(navController.context, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                    Log.e("Register", "Error: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Toast.makeText(navController.context, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                Log.e("Register", "Error: ${t.message}")
            }
        })
    }
    fun loginNow(email: String, password: String, navController: NavController){
        val LoginUser= LoginUser(
            email = email,
            password = password,
        )
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.loginUser(LoginUser)
                Log.e("Login", response.message)
                if (response.code == 200) {
                    Log.e("Login", response.message)
                    navController.navigate(BotNav.Homepage.route)
                } else {
                    Log.e("Login", response.message)
                }
            } catch (e: Exception) {
                apiStatus.value = e.message.toString()
                Toast.makeText(navController.context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun addUserData(navController: NavController) {
        val userData = UserData(
            username = username.value,
            nation = nation.value,
            birthday = birthday.value,
            age = age.value.toInt(),
            gender = gender.value,
            height = height.value.toInt(),
            weight = weight.value.toInt(),
            activitylevel = activity.value
        )
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.addUserData(userData)
                if (response.code == 200){
                    Log.e("User : ", response.message)
                    navController.navigate(Screen.Greeting.route)
                } else {
                    Log.e("User : ", response.message)
                }
            } catch (e: Exception) {
                apiStatus.value = e.message.toString()
            }
        }
    }
}