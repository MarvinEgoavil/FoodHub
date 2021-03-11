package com.example.foodhub.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodhub.R
import com.example.foodhub.databinding.RowMenuBinding
import com.example.foodhub.models.Product
import java.util.function.Predicate
import java.util.stream.Collectors

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var listTemp: MutableList<Product> = ArrayList()
    private var listOriginal: MutableList<Product> = ArrayList()
    private lateinit var mContext: Context

    constructor(context: Context) : this() {
        mContext = context
    }

    constructor(context: Context, dataList: List<Product>) : this() {
        mContext = context
        listTemp = dataList as MutableList<Product>
        listOriginal.addAll(listTemp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: RowMenuBinding = RowMenuBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding, mContext)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTemp.get(position))
    }

    override fun getItemCount(): Int {
        if (listTemp != null && listTemp.size > 0)
            return listTemp.size
        else
            return 0
    }

    fun filter(newText: String) {
        if (newText.length <= 0) {
            listTemp.clear()
            listTemp.addAll(listOriginal)
        } else {
            listTemp.clear()
            val collect: MutableList<Product> = listOriginal.stream()
                .filter(Predicate<Product> { i: Product ->
                    i.name.toString().toLowerCase().contains(newText)
                })
                .collect(Collectors.toList<Any>()) as MutableList<Product>
            listTemp.addAll(collect)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: RowMenuBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            val placeholder: Drawable = context.getResources().getDrawable(R.mipmap.ic_launcher)
            Glide.with(context)
                .load(item.thumbnail)
                .placeholder(placeholder)
                .error(placeholder)
                .centerCrop()
                .into(binding.image)

            binding.txtNameProduct.setText(item.name)
            binding.txtProductDescription.setText(item.description)
            binding.txtProductPrice.setText("€/ " + item.price)
        }
    }
}