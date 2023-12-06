package azhar.graduated.addproduct_2b.ui.products.showProducts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class showProductsViewModel @Inject constructor (private val repo :ProductRepoInterface) :ViewModel( ) {


    private val _productsData = MutableLiveData<List<ProductEntity>>()
    val productsData: LiveData<List<ProductEntity>> = _productsData


//    private val _Productdeleted = MutableLiveData<List<ProductEntity>>()
//    val Productdeleted : LiveData<List<ProductEntity>> = _Productdeleted

    init {
    getItemsLiveData()
}

    fun getItemsLiveData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val productDataList = repo.getAllProducts()
                _productsData.postValue(productDataList)
                Log.d("showProductsViewModel", "LiveData updated: $productDataList")
            } catch (e: Exception) {
                Log.e("showProductsViewModel", "Error updating LiveData", e)
            }
        }
    }


    fun deleteProduct(id: Long)  {

        viewModelScope.launch {
           repo.deleteById(id)
            getItemsLiveData()
        }

}
}