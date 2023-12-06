package azhar.graduated.addproduct_2b.data.DB

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS PRODUCT_TABLE (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, quantity INTEGER, price TEXT, totalPrice TEXT)")
    }
}
