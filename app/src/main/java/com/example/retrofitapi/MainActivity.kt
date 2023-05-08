package com.example.retrofitapi

import com.example.retrofitapi.model.Result

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.retrofitapi.adapter.QuoteAdapter
import com.example.retrofitapi.api.QuoteApi
import com.example.retrofitapi.helper.QuoteHelper
import com.example.retrofitapi.model.QuotesList
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var recyclerView = findViewById<RecyclerView>(R.id.quoteRecyclerView);

        var quoteApi = QuoteHelper.getInstance().create(QuoteApi::class.java);

        var quote = quoteApi.getQuote(1);


        //asynchronous call request and notify to callback, if error occur enqueue is send request again.
        quote.enqueue(object : Callback<QuotesList> {
            override fun onResponse(call: Call<QuotesList>, response: Response<QuotesList>) {
                var adapter = QuoteAdapter(response.body()!!.results, applicationContext);
                recyclerView.layoutManager = LinearLayoutManager(applicationContext);
                recyclerView.adapter = adapter;
            }

            override fun onFailure(call: Call<QuotesList>, t: Throwable) {
                Toast.makeText(applicationContext, "Problem occur", Toast.LENGTH_LONG).show();
            }

        });


    }
}