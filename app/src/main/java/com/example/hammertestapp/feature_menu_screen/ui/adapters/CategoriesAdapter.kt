package com.example.hammertestapp.feature_menu_screen.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammertestapp.databinding.CategoryItemBinding
import com.example.hammertestapp.feature_menu_screen.ui.models.Category
import javax.inject.Inject

internal class CategoriesAdapter @Inject constructor(
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private val items: MutableList<Category> = mutableListOf()
    private val clickedItem: Int = 0

    fun setItems(items: List<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            binding = CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int = items.size

    private fun changeClickedItem(newItemPos: Int) {

    }

    class CategoriesViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {

            binding.apply {
                name.text = item.name
                container.setOnClickListener {  }

            }
        }

        fun changeStateToEnabled(position: Int) {


        }

        fun changeStateToDisabled() {}
    }
}