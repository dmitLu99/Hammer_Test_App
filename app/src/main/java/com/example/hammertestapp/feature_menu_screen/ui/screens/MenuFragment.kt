package com.example.hammertestapp.feature_menu_screen.ui.screens

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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
    private val componentViewModel: ComponentViewModel by viewModels {
        ViewModelProvider.AndroidViewModelFactory(
            application = this.context?.applicationContext as Application
        )
    }
    @Inject internal lateinit var viewModelFactory: dagger.Lazy<MenuScreenViewModel.Factory>
    @Inject internal lateinit var bannersAdapter: dagger.Lazy<BannersAdapter>
    @Inject internal lateinit var categoriesAdapter: dagger.Lazy<CategoriesAdapter>
    @Inject internal lateinit var menuItemsAdapter: dagger.Lazy<MenuItemsAdapter>
    private val viewModel: MenuScreenViewModel by viewModels { viewModelFactory.get() }

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
            recycler.adapter = menuItemsAdapter.get()
            recyclerCategories.adapter = categoriesAdapter.get()
            recyclerSales.adapter = bannersAdapter.get()
        }

        viewModel.apply {

            bannersLiveData.observe(viewLifecycleOwner) { container ->
                bannersAdapter.get().setItems(items = container.banners)
                binding.progressBar.visibility = View.GONE
            }

            categoriesLiveData.observe(viewLifecycleOwner) { container ->
                categoriesAdapter.get().setItems(items = container.categories)
            }

            menuItemsLiveData.observe(viewLifecycleOwner) { container ->
                menuItemsAdapter.get().setItems(items = container.menuItems)
                binding.progressBar.visibility = View.GONE
            }

            errorStatusLiveData.observe(viewLifecycleOwner) { isError ->
                if (isError) {
                    binding.apply {
                        progressBar.visibility = View.GONE
                        error.visibility = View.VISIBLE
                    }
                }
            }
            fetchDisplayableItems()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}