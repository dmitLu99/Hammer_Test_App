package com.example.hammertestapp.feature_menu_screen.ui.adapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.RecyclerView
import com.example.hammertestapp.R
import com.example.hammertestapp.databinding.CategoryItemBinding
import com.example.hammertestapp.feature_menu_screen.ui.models.Category
import javax.inject.Inject

internal class CategoriesAdapter @Inject constructor(
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private val items: MutableList<Category> = mutableListOf()
    private var lastClickedItemPosition: Int = 0

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

    inner class CategoriesViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {

            if (item.isClicked) changeStateToEnabled() else changeStateToDisabled()

            binding.apply {
                container.setOnClickListener {
                    if (!item.isClicked) {

                        items[lastClickedItemPosition].isClicked = false
                        notifyItemChanged(lastClickedItemPosition, null)

                        item.isClicked = true
                        val newPosition = items.indexOf(item)
                        notifyItemChanged(newPosition, null)
                        lastClickedItemPosition = newPosition
                    }
                }
            }

        }

        private fun changeStateToEnabled() {
            binding.apply {
                val typedValue = TypedValue()
                val theme = root.context.theme
                theme.resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)
                name.setTextColor(typedValue.data)
                theme.resolveAttribute(com.google.android.material.R.attr.colorSecondary, typedValue, true)
                container.setCardBackgroundColor(typedValue.data)
            }

        }

        private fun changeStateToDisabled() {
            binding.apply {
                val typedValue = TypedValue()
                val theme = root.context.theme
                theme.resolveAttribute(com.google.android.material.R.attr.colorPrimaryVariant, typedValue, true)
                container.setCardBackgroundColor(typedValue.data)
                theme.resolveAttribute(com.google.android.material.R.attr.colorSecondaryVariant, typedValue, true)
                com.google.android.material.R.attr.color
                name.setTextColor(root.context.getColor(R.color.category_text))
            }
        }
    }
}