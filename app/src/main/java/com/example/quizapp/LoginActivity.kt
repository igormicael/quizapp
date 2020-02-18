package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.FormFragment.Companion.BUTTON_NAME
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), FragmentAction {

    override fun onClick(username: String, password: String) {
        Toast.makeText(this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT ).show()
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

    }

}
