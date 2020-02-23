package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.quizapp.action.FragmentAction
import com.google.firebase.auth.FirebaseAuth

class NewUserActivity : AppCompatActivity(), FragmentAction {

    private lateinit var auth: FirebaseAuth

    override fun onClick(username: String, password: String) {

        auth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(this) { task ->
                if( task.isSuccessful){
                    Toast.makeText(this, "Usuário criado com sucesso!", Toast.LENGTH_SHORT ).show()
                    finish()
                }else{
                    Log.w("NewUserActivity", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(this, "Não foi possível criar usuário. Contactar suporte", Toast.LENGTH_SHORT ).show()
                }
            }
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


        auth = FirebaseAuth.getInstance()
    }
}
