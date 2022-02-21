package com.example.bachelorsproject.data.local.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.*
import androidx.room.Room
import com.example.bachelorsproject.data.local.room.dao.RecipeInfoDao
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized



@Database(
    entities = [RecipeInfoDbEntity::class],
    version = 1,
    exportSchema = true,
    autoMigrations = []
)

abstract class AppDataBase: RoomDatabase() {
    abstract fun getRecipeInfoDao(): RecipeInfoDao

    @InternalCoroutinesApi
    companion object {
        private var instance: AppDataBase? = null
        private const val DATABASE_NAME = "Recipes.db"


        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDataBase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return instance!!
        }
    }
}