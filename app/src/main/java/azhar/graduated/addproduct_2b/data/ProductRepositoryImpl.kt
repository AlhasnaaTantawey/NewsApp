package azhar.graduated.addproduct_2b.data

import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductDao
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao
): ProductRepoInterface {

    override suspend fun addProduct(entity: ProductEntity): Long {
        return  dao.insertProduct(entity)
    }

    override suspend fun getAllProducts(): List<ProductEntity> {
        return  dao.getAllProducts()
    }

    override suspend fun deleteById(id: Long) {
        return dao.deleteById(id)
    }

    override suspend fun updateProduct(
        name: String,
        quantity: Int,
        price: String,
        totalPrice: String
    ) {
        return dao.updateAllProducts(name,quantity,price,totalPrice)
    }


}