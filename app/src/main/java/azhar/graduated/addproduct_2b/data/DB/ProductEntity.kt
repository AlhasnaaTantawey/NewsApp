package azhar.graduated.addproduct_2b.data.DB
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "PRODUCT_TABLE")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    var name: String? = "",
    var quantity: Int? = 0,
    var price: String? = "",
    var totalPrice: String? = ""
): Serializable
