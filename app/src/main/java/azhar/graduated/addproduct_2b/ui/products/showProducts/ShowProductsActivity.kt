package azhar.graduated.addproduct_2b.ui.products.showProducts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import azhar.graduated.addproduct_2b.R
import azhar.graduated.addproduct_2b.databinding.ActivityShowProductsBinding
import azhar.graduated.addproduct_2b.ui.products.editProducts.EditProductsActivity
import azhar.graduated.addproduct_2b.ui.products.editProducts.EditProductsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ShowProductsActivity : AppCompatActivity() {

    lateinit var binding :ActivityShowProductsBinding
    private  val viewModel: showProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityShowProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

       showData()
    }


    private fun showData() {
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = NewProductAdapter(emptyList(), onDeleteProduct = { viewModel.deleteProduct(it)} ,
             onEditButtonClicked = { product ->
                val intent = Intent(this, EditProductsActivity::class.java)
                intent.putExtra("yourKey", product)
                startActivity(intent)
            })
        recyclerView.adapter = adapter

        viewModel.productsData.observe(this) { newData ->
            adapter.updateList(newData)
        }
    }


}