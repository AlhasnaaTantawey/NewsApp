package azhar.graduated.signupandlogin.data.DB

import androidx.room.*
@Dao
interface UserDao {
    //for single user insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userEntity: UserEntity): Long


    //checking user exist or not in our db
    @Query("SELECT * FROM USER_TABLE WHERE name LIKE :userName AND password LIKE :password")
    fun readLoginData(userName: String, password: String):UserEntity

    @Query("DELETE FROM user_table")
    suspend fun clearUserData()
}


