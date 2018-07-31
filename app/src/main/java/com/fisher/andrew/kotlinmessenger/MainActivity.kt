package com.fisher.andrew.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//TODO TURN ON INSTANT RUN?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//https://firebase.google.com/docs/auth/android/start/

        register_button.setOnClickListener {
            performRegister()


        }

        already_have_account_text_view.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun performRegister(){
        val email = email_edit_text.text.toString()
        val password = password_edit_text.text.toString()

        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Please enter text in email/pw",Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if(!it.isSuccessful) return@addOnCompleteListener

                    Log.d("Main","Created user with uid: ${it.result.user.uid}")

                }
                .addOnFailureListener {
                    Toast.makeText(this,"Failed to create user: ${it.message}",Toast.LENGTH_SHORT).show()
                }
    }
}
