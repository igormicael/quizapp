package com.example.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class RetrievePasswordActivity : AppCompatActivity(), FragmentAction {

    private lateinit var auth: FirebaseAuth

    override fun onClick(username: String, password: String) {

        auth.sendPasswordResetEmail(username)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "E-mail enviado!", Toast.LENGTH_SHORT ).show()
                    finish()
                }else{
                    Toast.makeText(this, "Não foi possivel redefinir senha!", Toast.LENGTH_SHORT ).show()
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieve_password)


        val bundle = Bundle()
        bundle.putBoolean (FormFragment.SHOW_PASSWORD, false)

        bundle.putString(FormFragment.BUTTON_NAME, "Recuperar senha")
        val fragment = FormFragment.newInstance(bundle)

        supportFragmentManager.
            beginTransaction()
            .add(R.id.fragment1, fragment)
            .commit()

        auth = FirebaseAuth.getInstance()
    }
}
