package azhar.graduated.addproduct_2b.ui.products.editProducts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.activity.viewModels
import azhar.graduated.addproduct_2b.data.DB.ProductEntity

import azhar.graduated.addproduct_2b.databinding.ActivityAddProductBinding
import azhar.graduated.addproduct_2b.databinding.ActivityAddProductBinding.inflate
import azhar.graduated.addproduct_2b.databinding.ActivityEditProductsBinding
import azhar.graduated.addproduct_2b.ui.products.showProducts.ShowProductsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProductsBinding
    private  val viewModel: EditProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
         updateData()
    }


    fun setData(){
        val product = intent.getSerializableExtra("yourKey") as? ProductEntity
        binding.listItemName.text = Editable.Factory.getInstance().newEditable(product?.name)
        binding.listItemPrice.text=Editable.Factory.getInstance().newEditable(product?.price.toString())
        binding.listItemQuentity.text=Editable.Factory.getInstance().newEditable(product?.quantity.toString())
        binding.listItemTotalPrice.text=Editable.Factory.getInstance().newEditable(product?.totalPrice)
    }

    fun updateData(){
        binding.listItemButtonDelet.setOnClickListener{
  val name =binding.listItemName.text.toString()
            val quentity =binding.listItemQuentity.text.toString()
            val price =binding.listItemPrice.text.toString()
            val totalPrice =binding.listItemTotalPrice.text.toString()
                viewModel.updateProductMethod(name,quentity.toInt(),price, totalPrice )
            startActivity(Intent(this,ShowProductsActivity::class.java))
        }

        }


}