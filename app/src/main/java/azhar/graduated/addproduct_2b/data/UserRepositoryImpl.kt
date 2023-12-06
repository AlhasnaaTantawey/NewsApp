package azhar.graduated.addproduct_2b.data

import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.signupandlogin.data.DB.UserDao
import azhar.graduated.signupandlogin.data.DB.UserEntity
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao: UserDao
): UserRepoInterface  {

    override suspend fun addUser(entity: UserEntity):Long {
      return  dao.insertUser(entity)
    }



    override suspend fun verifyLoginUser(userName: String, password: String): UserEntity {
        return  dao.readLoginData(userName,password)
    }
    override suspend fun logout() {
        // Implement logout logic, clear user data from the database or perform any other necessary cleanup
       dao.clearUserData()
    }





}