package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RetrievePasswordActivity : AppCompatActivity(), FragmentAction {

    override fun onClick(username: String, password: String) {
        finish()
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
    }
}
