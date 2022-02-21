package com.example.bachelorsproject.app

import android.app.Application
import com.example.bachelorsproject.data.local.room.AppDataBase
import com.example.bachelorsproject.di.recipeInfoModule
import com.example.bachelorsproject.di.recipeModule
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@InternalCoroutinesApi
class App: Application() {

    companion object{
        lateinit var appData: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()

        appData = AppDataBase.getInstance(this)

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(recipeModule, recipeInfoModule))
        }
    }
}