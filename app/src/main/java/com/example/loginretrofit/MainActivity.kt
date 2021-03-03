package com.example.loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    //var btn = findViewById<Button>(R.id.btn_login)
    //var pass = findViewById<EditText>(R.id.ed_password)
    //var em = findViewById<EditText>(R.id.ed_email)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initAction()
    }

    fun initAction() {
        btn_login.setOnClickListener {
            login()
        }
    }

    fun login(){

        val request = UserRequest()
        request.email = ed_email.text.toString().trim()
        request.password = ed_password.text.toString().trim()

        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                Log.e("Email", user!!.email)
                Log.e("Password", user!!.password)
            }

        })
    }
}