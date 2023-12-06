package azhar.graduated.addproduct_2b.ui.Users.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import azhar.graduated.addproduct_2b.SharedPreferencesHelper
import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
@HiltViewModel
class LoginViewModel@Inject constructor (
    private var userRepository: UserRepoInterface, private val sharedPreferencesHelper: SharedPreferencesHelper
): ViewModel() {

    private val _GetUserLoginDataStatus = MutableLiveData<UserEntity>()
    val userAndPass: LiveData<UserEntity> = _GetUserLoginDataStatus


    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    // Logout function
    fun logout() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepository.logout()
            }
        }
    }


//login function
    fun getUserLoginDataStatus(usename:String,password:String) {
        viewModelScope.launch (Dispatchers.IO){
            val data = userRepository.verifyLoginUser(usename,password)
            _GetUserLoginDataStatus.postValue(data)
            // If the login is successful, save credentials
            if (data != null) {
                sharedPreferencesHelper.saveLoginCredentials(usename, password)
            }
        } }


}