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

        val user = AccountEntity(email = "aa", password = "asdas");

        store.boxFor(AccountEntity::class.java)
            .put(user);

        val results = store.boxFor(AccountEntity::class.java)
            .query(AccountEntity_.email.equal("aa"))
            .build()
            .find()

        Log.d("TAG","ASD");



    }


}