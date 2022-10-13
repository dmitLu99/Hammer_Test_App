package com.example.hammertestapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hammertestapp.databinding.FragmentHomeBinding
import com.example.hammertestapp.databinding.SimpleItemBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val simpleAdapter = SimpleAdapter()

        with(binding) {
            recycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = simpleAdapter
            }
            recyclerCategories.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                adapter = simpleAdapter
            }
            recyclerSales.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                adapter = simpleAdapter
            }
        }

        homeViewModel.items.observe(viewLifecycleOwner) { items ->
            simpleAdapter.setItems(items = items)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    private val items: MutableList<SimpleItem> = mutableListOf()

    fun setItems(items: List<SimpleItem>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(
            binding = SimpleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    override fun getItemCount(): Int = items.size

    class SimpleViewHolder(private val binding: SimpleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SimpleItem) {
            binding.apply {
                text.text = item.text
            }
        }
    }
}