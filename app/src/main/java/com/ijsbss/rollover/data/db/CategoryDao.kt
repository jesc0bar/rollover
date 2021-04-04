package com.ijsbss.rollover.data.db

import com.ijsbss.rollover.data.entities.Category
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories ORDER BY view_order")
    fun getCategories():LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: Category)

    @Query("DELETE FROM categories")
    suspend fun deleteAll()

}