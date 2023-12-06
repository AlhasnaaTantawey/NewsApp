package azhar.graduated.signupandlogin.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import azhar.graduated.addproduct_2b.data.DB.ProductDao
import azhar.graduated.addproduct_2b.data.DB.ProductEntity

@Database(entities = [UserEntity::class, ProductEntity::class], version = 4)
abstract class MyDatabase :RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun ProductDao():ProductDao
}