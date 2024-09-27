package com.example.x_clone.repository

import android.content.Context
import android.util.Log
import com.example.x_clone.repository.entity.AccountEntity
import com.example.x_clone.repository.entity.AccountEntity_
import com.example.x_clone.repository.entity.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var store: BoxStore
        private set

    fun init(context: Context) {
        store = MyObjectBox
            .builder()
            .androidContext(context)
            .build()
    }
    fun getCurrentAccount(): AccountEntity? {
        val results = store.boxFor(AccountEntity::class.java)
            .query()
            .build()
            .find()
        return if (results.isNotEmpty()) results[0] else null
    }
    fun saveAccountOverride(email : String , password : String){
        val accountBox = store.boxFor(AccountEntity::class.java)
        accountBox.removeAll();
        val newAccount = AccountEntity(
            email = email,
            password = password
        )
        accountBox.put(newAccount)
    }


}