package com.example.hammertestapp.feature_menu_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hammertestapp.databinding.BannerItemBinding
import com.example.hammertestapp.feature_menu_screen.di.annotations.Banner
import com.example.hammertestapp.feature_menu_screen.ui.models.Banner as BannerModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class BannersAdapter @Inject constructor(
    @Banner private val requestOptions: RequestOptions
) : RecyclerView.Adapter<BannersAdapter.BannerViewHolder>() {

    private val items: MutableList<BannerModel> = mutableListOf()

    fun setItems(items: List<BannerModel>) {
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

    inner class BannerViewHolder(private val binding: BannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BannerModel) {

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
        }
    }
}