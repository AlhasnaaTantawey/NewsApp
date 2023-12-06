package azhar.graduated.addproduct_2b.ui.Users.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.transition.Visibility
import azhar.graduated.addproduct_2b.databinding.ActivityCreateAnAccountBinding
import azhar.graduated.addproduct_2b.ui.products.addProducts.AddProductActivity
import azhar.graduated.addproduct_2b.ui.Users.login.LoginActivity
import azhar.graduated.signupandlogin.data.DB.UserEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateAnAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAnAccountBinding
    private  val viewModel: CreateAnAccountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAnAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createAnAccount()

    }

    private fun createAnAccount() {
        lateinit var user: UserEntity

        binding.activityMainButtonCreateAnAccount.setOnClickListener {
            user = UserEntity(
                name = binding.CreateAnAccountActivityEdittextName.text.toString(),
                password = binding.CreateAnAccountActivityEdittextPassword.text.toString(),
                email = binding.CreateAnAccountActivityEdittextEmail.text.toString(),
                phone = binding.CreateAnAccountActivityEdittextPhone.text.toString()
            )

            if (user.email!!.isEmpty() && user.name!!.isEmpty() && user.password!!.isEmpty() && user.phone!!.isEmpty()){
                   binding.CreateAnAccountActivityErrormessage.visibility=View.VISIBLE
            }
            else if (user.email!!.isEmpty() && ( user.name!!.isNotEmpty()||user.name!!.isNotBlank()) && user.password!!.isNotEmpty()
                &&( user.phone!!.isNotEmpty()||user.phone!!.isNotBlank())){

            }
            else{
                viewModel.insertUserData(user)
                startActivity(Intent(this, LoginActivity::class.java))
            }

        }

        }
    }



