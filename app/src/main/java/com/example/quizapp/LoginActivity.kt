package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.FormFragment.Companion.BUTTON_NAME
import com.example.quizapp.action.FragmentAction
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), FragmentAction {

    private lateinit var auth: FirebaseAuth

    override fun onClick(username: String, password: String) {
        Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT ).show()

        signIn(username, password)

    }

    private fun signIn(username: String, password: String) {
        //auth.signInWithEmailAndPassword(username, password)
        //    .addOnCompleteListener(this) { task ->
        //        if(task.isSuccessful){
                    val intent = Intent(this, GameActivity::class.java)
                    startActivity(intent)
       //         }else{
        //            Toast.makeText(this, "Authentication failed.",
         //               Toast.LENGTH_SHORT).show()
         //       }
         //   }
    }

    private fun signOut() {
        auth.signOut()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setSupportActionBar(toolbar)

        val bundle = Bundle()
        bundle.putString(BUTTON_NAME, "Logar")
        val fragment = FormFragment.newInstance(bundle)

        supportFragmentManager.
            beginTransaction()
            .add(R.id.fragment1, fragment)
            .commit()

        retrievePassword.setOnClickListener {
            val intent = Intent(this,
                RetrievePasswordActivity::class.java)
            startActivity(intent)
        }

        newUser.setOnClickListener{
            val intent = Intent(this,
                NewUserActivity::class.java)
            startActivity(intent)
        }

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

    }



}
