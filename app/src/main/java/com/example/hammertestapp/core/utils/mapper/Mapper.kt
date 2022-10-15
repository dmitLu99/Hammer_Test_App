package com.example.hammertestapp.core.utils.mapper

interface Mapper<in F, out T> {

    suspend fun map(from: F): T
}