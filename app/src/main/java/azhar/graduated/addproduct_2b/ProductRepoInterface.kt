package azhar.graduated.addproduct_2b



import azhar.graduated.addproduct_2b.data.DB.ProductEntity

interface ProductRepoInterface {

    suspend fun  addProduct(entity:ProductEntity):Long
    suspend fun  getAllProducts():List<ProductEntity>
    suspend fun  deleteById(id :Long)
    suspend fun updateProduct(name: String, quantity: Int, price: String, totalPrice: String)

}