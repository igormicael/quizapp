package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewUserActivity : AppCompatActivity(), FragmentAction {

    override fun onClick(username: String, password: String) {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user)

        val bundle = Bundle()

        bundle.putString(FormFragment.BUTTON_NAME, "Criar")
        val fragment = FormFragment.newInstance(bundle)

        supportFragmentManager.
            beginTransaction()
            .add(R.id.fragment1, fragment)
            .commit()
    }
}
