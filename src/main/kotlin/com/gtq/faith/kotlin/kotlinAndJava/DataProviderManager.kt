package com.gtq.faith.kotlin.kotlinAndJava

object DataProviderManager {
    val providers = mutableListOf<String>()

    fun registerDataProvider(provider: String) {
    }

    val allDataProviders: Collection<String>
        get() = providers
}