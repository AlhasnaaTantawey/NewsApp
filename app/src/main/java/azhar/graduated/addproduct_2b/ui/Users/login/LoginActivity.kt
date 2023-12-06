package azhar.graduated.addproduct_2b.ui.Users.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import azhar.graduated.addproduct_2b.SharedPreferencesHelper
import azhar.graduated.addproduct_2b.databinding.ActivityLoginBinding
import azhar.graduated.addproduct_2b.ui.products.addProducts.AddProductActivity
import azhar.graduated.addproduct_2b.ui.products.showProducts.ShowProductsActivity
import azhar.graduated.addproduct_2b.ui.Users.signup.CreateAnAccountActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesHelper = SharedPreferencesHelper(applicationContext)
        val savedUsername = sharedPreferencesHelper.getSavedUsername()

        if (savedUsername != null) {
            // User is already logged in, open HomePageActivity
            val intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity if you don't want to go back to it
        }



        onLoginClick()

        onSignupCall()
    }


    private fun onSignupCall() {
        // ... (existing code)

        binding.LoginActivityButtonCreateAccount.setOnClickListener {
            startActivity(Intent(this, CreateAnAccountActivity::class.java))
        }
    }

    private fun setUpViewModel() {

        var name = binding.LoginActivityEditTextUsername.text.toString()
        var pass = binding.LoginActivityEditTextPassword.text.toString()
        viewModel.getUserLoginDataStatus(
            name,
            pass
        )
        sharedPreferencesHelper.saveLoginCredentials(name, pass)
        viewModel.userAndPass.observe(this) {
            if (it != null) {

                startActivity(Intent(this, ShowProductsActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "The user does not exist in the database.", Toast.LENGTH_LONG)
                    .show()

            }


        }
    }



    private fun onLoginClick() {
        binding.LoginActivityButtonLogin.setOnClickListener {
            setUpViewModel()

        }
    }
}