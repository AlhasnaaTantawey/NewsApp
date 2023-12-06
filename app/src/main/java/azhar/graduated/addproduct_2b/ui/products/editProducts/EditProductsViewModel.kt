package azhar.graduated.addproduct_2b.ui.products.editProducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProductsViewModel @Inject constructor ( private var repo: ProductRepoInterface) :ViewModel() {

//    private val _updateProduct = MutableLiveData<ProductEntity>()
//
//    val updateProduct: LiveData<ProductEntity> = _updateProduct



    fun updateProductMethod(name: String, quantity: Int, price: String, totalPrice: String){
        viewModelScope.launch {
            repo.updateProduct(name,quantity,price,totalPrice)

        }
    }
}