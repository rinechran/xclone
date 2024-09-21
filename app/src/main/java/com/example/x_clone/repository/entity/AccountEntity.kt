package com.example.x_clone.repository.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class AccountEntity (
    @Id
    var id: Long = 0,
    val email : String,
    val password : String
)