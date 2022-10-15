package com.example.hammertestapp.feature_menu_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hammertestapp.R
import com.example.hammertestapp.databinding.MenuItemBinding
import com.example.hammertestapp.feature_menu_screen.di.annotations.Menu
import com.example.hammertestapp.feature_menu_screen.ui.models.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MenuItemsAdapter @Inject constructor(
    @Menu private val requestOptions: RequestOptions
) : RecyclerView.Adapter<MenuItemsAdapter.MenuItemViewHolder>() {

    private val items: MutableList<MenuItem> = mutableListOf()

    fun setItems(items: List<MenuItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(
            binding = MenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class MenuItemViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuItem) {


            CoroutineScope(Dispatchers.Main).launch {
                Glide.with(binding.root.context)
                    .load(item.imageUrl)
                    .thumbnail(
                        Glide.with(binding.root.context)
                            .load(item.imageUrl)
                            .apply(requestOptions)
                    )
                    .apply(requestOptions)
                    .into(binding.image)
            }

            binding.apply {
                title.text = item.title
                description.text = item.description
                price.text = item.price.toString()
            }
        }
    }
}