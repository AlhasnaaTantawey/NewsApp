package azhar.graduated.addproduct_2b.data.DB

import androidx.room.*


@Dao
interface ProductDao {
    //for single product insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(productEntity: ProductEntity): Long

        //getting all data
    @Query("select * from PRODUCT_TABLE")
     fun getAllProducts():List<ProductEntity>


        @Query("DELETE FROM PRODUCT_TABLE WHERE id = :id")
       suspend fun deleteById(id: Long)

    @Query("UPDATE PRODUCT_TABLE SET name = :name, quantity = :quantity, price = :price, totalPrice = :totalPrice")
    suspend fun updateAllProducts(name: String, quantity: Int, price: String, totalPrice: String)

}