package azhar.graduated.addproduct_2b.ui.products.addProducts

import android.app.Application
import androidx.lifecycle.*
import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.signupandlogin.data.DB.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private var repoInterface: ProductRepoInterface
) : ViewModel( ){
    private val _insertProduct = MutableLiveData<Long>()

    val insertProduct: LiveData<Long> = _insertProduct

    fun insertProductData(product:ProductEntity) {
        viewModelScope.launch {
            val data = repoInterface.addProduct(product)
            _insertProduct.postValue(data)
        }
    }




}