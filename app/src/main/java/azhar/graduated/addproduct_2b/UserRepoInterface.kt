package azhar.graduated.addproduct_2b



import azhar.graduated.signupandlogin.data.DB.UserEntity

interface UserRepoInterface {
    suspend fun  addUser(entity: UserEntity):Long
   suspend fun verifyLoginUser(userName: String, password: String):UserEntity

   suspend fun  logout()




}