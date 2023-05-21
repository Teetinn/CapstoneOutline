package id.ac.umn.capstoneoutline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import id.ac.umn.capstoneoutline.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonLogin.setOnClickListener{
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if(email.isEmpty()){
                binding.etEmail.error = "Email Required"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            } else
            {
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Enter a valid email", Toast.LENGTH_LONG).show()
                }
            }

            if(password.isEmpty() || password.length < 8){
                binding.etPassword.error = "Password Required"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }


            //kalau sukses login, masuk ke halaman home dgn intent dibawah
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))

        }
    }
}