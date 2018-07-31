package com.fisher.andrew.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.activity_login)


        login_button.setOnClickListener {

            performLogin()


        }

        login_back_to_reg.setOnClickListener { finish() }



    }

    private fun performLogin(){
        val email = login_email.text.toString()
        val password = login_password.text.toString()

        if (email.isEmpty() || password.isEmpty()) return

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener


                }
                .addOnFailureListener {
                    Log.d("Main","Failed to create user: ${it.message}")
                }
    }



}