package azhar.graduated.signupandlogin.di

import azhar.graduated.addproduct_2b.ProductRepoInterface
import azhar.graduated.addproduct_2b.UserRepoInterface
import azhar.graduated.addproduct_2b.data.DB.ProductDao
import azhar.graduated.addproduct_2b.data.DB.ProductEntity
import azhar.graduated.addproduct_2b.data.ProductRepositoryImpl
import azhar.graduated.addproduct_2b.data.UserRepositoryImpl
import azhar.graduated.signupandlogin.data.DB.UserDao
import azhar.graduated.signupandlogin.data.DB.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object Module {
    @Provides
    fun provideUserDao(db: MyDatabase) = db.userDao()

    @Provides
    fun provideuserRepo(dao: UserDao):UserRepoInterface= UserRepositoryImpl(dao)


    @Provides
    fun provideProductDao(db:MyDatabase ) = db.ProductDao()

    @Provides
    fun provideProductRepo(dao: ProductDao): ProductRepoInterface = ProductRepositoryImpl(dao)



}