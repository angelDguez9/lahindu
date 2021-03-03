package com.example.loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Optional.empty

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
            if(ed_email.getText().toString().isEmpty() || ed_password.getText().toString().isEmpty()) {
                Toast.makeText(this, "No puede haber campos vacios ", Toast.LENGTH_SHORT).show();
            } else {
                getOneUser()
                //getusers()
                //login()
            }
        }
    }

    private fun getOneUser() {

        Toast.makeText(this@MainActivity,"Entro al metodo get",Toast.LENGTH_LONG).show()
        val getUsers: UserApi = Retro().getRetroClientInstance().create(UserApi::class.java)
        val result: Call<List<datausers>> = getUsers.Allusers()
        Toast.makeText(this@MainActivity,"Result "+result,Toast.LENGTH_LONG).show()
        result.enqueue(object : Callback<List<datausers>> {
            override fun onFailure(Call: Call<List<datausers>>, t: Throwable){
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                call: Call<List<datausers>>,
                response: Response<List<datausers>>
            ) {
                val user = response.body()
                Log.e("Error","information")
                Toast.makeText(this@MainActivity,"Metodoget",Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun getusers() {
        Toast.makeText(this@MainActivity,"Entro al metodo get",Toast.LENGTH_LONG).show()
        val getUsers: UserApi = Retro().getRetroClientInstance().create(UserApi::class.java)
        val result: Call<List<datausers>> = getUsers.Allusers()
        Toast.makeText(this@MainActivity,"Result "+result,Toast.LENGTH_LONG).show()
        result.enqueue(object : Callback<List<datausers>> {
            override fun onFailure(Call: Call<List<datausers>>, t: Throwable){
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
            }
            override fun onResponse(
                call: Call<List<datausers>>,
                response: Response<List<datausers>>
            ) {
                val user = response.body()
                Log.e("Error","information")
                Toast.makeText(this@MainActivity,"Metodoget",Toast.LENGTH_LONG).show()
            }

        })
    }

    fun login(){


        val request = UserRequest()
        request.email = ed_email.text.toString().trim()
        request.password = ed_password.text.toString().trim()
        Toast.makeText(this, "Mensaje 1", Toast.LENGTH_SHORT).show()
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
        retro.login(request).enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("Error", t.message)
                Toast.makeText(this@MainActivity,"Error en el get",Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
              //  Log.e("Email", user!!.email)
              //  Log.e("Password", user!!.password)

                Toast.makeText(this@MainActivity,"Usuario" + ed_email +" ingresado",Toast.LENGTH_LONG).show()
            }




        })
    }
}