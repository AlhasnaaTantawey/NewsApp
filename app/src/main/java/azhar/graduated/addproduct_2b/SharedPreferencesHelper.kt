package azhar.graduated.addproduct_2b

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class SharedPreferencesHelper @Inject constructor(@ApplicationContext private val context: Context) {
    private val PREF_NAME = "MyPrefs"
    private val KEY_USERNAME = "username"
    private val KEY_PASSWORD = "password"

    fun saveLoginCredentials(username: String, password: String) {
        val editor = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit()
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    fun getSavedUsername(): String? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_USERNAME, null)
    }

    fun getSavedPassword(): String? {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getString(KEY_PASSWORD, null)
    }
}
