package com.example.quizapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.action.FragmentAction
import com.google.firebase.auth.FirebaseAuth

class NewUserActivity : AppCompatActivity(), FragmentAction {

    private lateinit var auth: FirebaseAuth

    override fun onClick(username: String, password: String) {

        if (username.isBlank()) {
            Toast.makeText(
                this, "Please inform email",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if (password.isBlank()) {
            Toast.makeText(
                this, "Please inform password",
                Toast.LENGTH_SHORT
            ).show()
            return
        }


        auth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "User created!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Log.w("NewUserActivity", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this, "Error: User wasn't created!", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        val bundle = Bundle()

        bundle.putString(FormFragment.BUTTON_NAME, "Create")
        val fragment = FormFragment.newInstance(bundle)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment1, fragment)
            .commit()


        auth = FirebaseAuth.getInstance()
    }
}
