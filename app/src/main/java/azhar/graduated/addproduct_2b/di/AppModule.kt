package azhar.graduated.addproduct_2b.di

import android.content.Context
import androidx.room.Room
import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.addproduct_2b.data.DB.MIGRATION_1_2
import azhar.graduated.addproduct_2b.data.UserRepositoryImpl
import azhar.graduated.signupandlogin.data.DB.MyDatabase
import azhar.graduated.signupandlogin.data.DB.UserDao
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(app,
       MyDatabase::class.java,
        "myDatabase") .addMigrations(MIGRATION_1_2)
        .build()


}


