package com.example.mvvm

import android.app.Application
import com.example.mvvm.data.viewmodel.factory.ExampleViewModelFactory
import com.example.mvvm.network.ExampleEndpoint
import com.example.mvvm.network.ExampleRepository
import com.example.mvvm.network.RetrofitClient
import com.example.mvvm.storage.perferences.ExamplePreferences
import com.example.mvvm.storage.persistence.ExampleDatabase
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import timber.log.Timber

class MVVMProjectStarterApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMProjectStarterApplication))

        bind<ExampleEndpoint>() with singleton { RetrofitClient.getClient() }
        bind() from singleton { ExamplePreferences(instance()) }
        bind() from singleton { ExampleDatabase(instance()) }
        bind() from singleton { ExampleRepository(instance(), instance(), instance()) }
        bind() from singleton { ExampleViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}