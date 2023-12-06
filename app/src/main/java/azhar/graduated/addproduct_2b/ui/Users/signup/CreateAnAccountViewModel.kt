package azhar.graduated.addproduct_2b.ui.Users.signup

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azhar.graduated.addproduct_2b.SharedPreferencesHelper
import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.signupandlogin.data.DB.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateAnAccountViewModel @Inject constructor(
    private var repoInterface: UserRepoInterface
): ViewModel() {


    private val _insertUsersDataStatus = MutableLiveData<Long>()
    val insertUsersDataStatus: LiveData<Long> = _insertUsersDataStatus

    fun insertUserData(user: UserEntity) {
        viewModelScope.launch {
            val data = repoInterface.addUser(user)
            _insertUsersDataStatus.postValue(data)

        }
    }

}