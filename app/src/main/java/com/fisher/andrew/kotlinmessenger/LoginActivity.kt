package com.fisher.andrew.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.activity_login)


        login_button.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()

        }

        login_back_to_reg.setOnClickListener { finish() }



    }





}