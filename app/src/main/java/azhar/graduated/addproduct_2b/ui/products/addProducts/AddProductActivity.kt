package azhar.graduated.addproduct_2b.ui.products.addProducts

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.addproduct_2b.databinding.ActivityAddProductBinding
import azhar.graduated.addproduct_2b.ui.products.showProducts.ShowProductsActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    private  val viewModel: AddProductViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonAction()
        showDta()
    }

    private fun buttonAction() {
        lateinit var  product:ProductEntity
        binding.AddProductActivityButtonAdd.setOnClickListener{

            product =ProductEntity(
                name = binding.AddProductActivityEdittextProductName.text.toString(),
                quantity = binding.AddProductActivityEdittextProductQuentity.text.toString().toInt(),
                price = binding.AddProductActivityEdittextTotalprice.text.toString(),
                totalPrice = binding.AddProductActivityEdittextTotalprice.text.toString()
            )
            if (product != null) {
                viewModel.insertProductData(product)
                viewModel.insertProduct.observe(this) {
                    Toast.makeText(this, "the product added", Toast.LENGTH_LONG).show()
                }
            }
            else{
                    binding.AddProductActivityTxtviewError.visibility=View.VISIBLE
                }




        }
    }

    private fun showDta(){
        binding.AddProductActivityButtonShow.setOnClickListener{
            startActivity(Intent(this,ShowProductsActivity::class.java))
        }
    }


}