package id.ac.umn.capstoneoutline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.umn.capstoneoutline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvLogin.setOnClickListener{
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        binding.buttonSignup.setOnClickListener{
            val name = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if(name.isEmpty()){
                binding.etUsername.error = "Username Required"
                binding.etUsername.requestFocus()
                return@setOnClickListener
            }

            if(email.isEmpty()){
                binding.etEmail.error = "Email Required"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty() || password.length < 8){
                binding.etPassword.error = "Password Required"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            //Fungsi konfirmasi password

            //Validasi register
            //Jika berhasil sign up, masuk ke halaman login


//            startActivity(Intent(this@MainActivity, LoginActivity::class.java))

        }
    }
}