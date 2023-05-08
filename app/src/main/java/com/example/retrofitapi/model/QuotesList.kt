package com.example.retrofitapi.model

data class QuotesList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: ArrayList<Result>,
    val totalCount: Int,
    val totalPages: Int
)