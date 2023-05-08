package com.example.retrofitapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapi.R
import com.example.retrofitapi.model.Result

class QuoteAdapter(var list: List<Result>, var context: Context) :
    RecyclerView.Adapter<QuoteAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var quote = view.findViewById<TextView>(R.id.quote);
        var author = view.findViewById<TextView>(R.id.author);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_quote_layout, parent, false);3
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item=list[position];
        holder.quote.text=item.content;
        holder.author.text=item.author;
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    fun setData(data:ArrayList<com.example.retrofitapi.model.Result>){
        list=data;
        notifyDataSetChanged();
    }
}