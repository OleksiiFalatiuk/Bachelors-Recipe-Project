package com.example.bachelorsproject.di

import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.data.RecipeRepositoryImpl
import com.example.bachelorsproject.data.remote.RemoteDataSource
import com.example.bachelorsproject.data.remote.retrofit.RecipeApiService
import com.example.bachelorsproject.data.remote.retrofit.RetrofitDataSource
import com.example.bachelorsproject.provider.NetworkModule
import com.example.bachelorsproject.recipe.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recipeModule = module {



    factory { NetworkModule().api }

    factory<RetrofitDataSource>{ get() }

    single<RemoteDataSource> { RetrofitDataSource(get()) }

    factory { RecipeRepositoryImpl(get()) }

    single<RecipeRepository> { RecipeRepositoryImpl(get()) }

    viewModel { RecipeViewModel(get()) }


}