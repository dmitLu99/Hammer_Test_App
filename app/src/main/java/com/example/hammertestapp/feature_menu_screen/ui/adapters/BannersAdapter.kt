package com.example.hammertestapp.feature_menu_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.hammertestapp.R
import com.example.hammertestapp.databinding.BannerItemBinding
import com.example.hammertestapp.feature_menu_screen.ui.models.Banner
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class BannersAdapter @Inject constructor() :
    RecyclerView.Adapter<BannersAdapter.BannerViewHolder>() {

    private val items: MutableList<Banner> = mutableListOf()

    fun setItems(items: List<Banner>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            binding = BannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int = items.size

    class BannerViewHolder(private val binding: BannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Banner) {

            val requestOption = RequestOptions()
                .error(R.drawable.ic_error_outline_24)
                .placeholder(R.drawable.ic_outline_download_24)
                .diskCacheStrategy(DiskCacheStrategy.NONE)

            CoroutineScope(Dispatchers.Main).launch {
                Glide.with(binding.root.context)
                    .load(item.imageUrl)
                    .thumbnail(Glide.with(binding.root.context)
                        .load(item.imageUrl)
                        .apply(requestOption))
                    .into(binding.image)
            }
        }
    }
}