package com.example.hammertestapp.feature_menu_screen.ui.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hammertestapp.databinding.FragmentMenuBinding
import com.example.hammertestapp.feature_menu_screen.ui.adapters.BannersAdapter
import com.example.hammertestapp.feature_menu_screen.ui.adapters.CategoriesAdapter
import com.example.hammertestapp.feature_menu_screen.ui.adapters.MenuItemsAdapter
import com.example.hammertestapp.feature_menu_screen.view_models.ComponentViewModel
import com.example.hammertestapp.feature_menu_screen.view_models.MenuScreenViewModel
import javax.inject.Inject

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val componentViewModel: ComponentViewModel by viewModels()
    @Inject internal lateinit var viewModelFactory: MenuScreenViewModel.Factory
    @Inject internal lateinit var bannersAdapter: BannersAdapter
    @Inject internal lateinit var categoriesAdapter: CategoriesAdapter
    @Inject internal lateinit var menuItemsAdapter: MenuItemsAdapter
    private val viewModel: MenuScreenViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        componentViewModel.fetchComponent().inject(fragment = this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recycler.adapter = menuItemsAdapter
            recyclerCategories.adapter = categoriesAdapter
            recyclerSales.adapter = bannersAdapter
        }

        viewModel.apply {

            bannersLiveData.observe(viewLifecycleOwner) { container ->
                bannersAdapter.setItems(items = container.banners)
            }

            categoriesLiveData.observe(viewLifecycleOwner) { container ->
                categoriesAdapter.setItems(items = container.categories)
            }

            menuItemsLiveData.observe(viewLifecycleOwner) { container ->
                menuItemsAdapter.setItems(items = container.menuItems)
            }

            fetchDisplayableItems()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}