package com.example.marketplace.addproduct.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.addproduct.viewModel.AddViewModel
import com.example.marketplace.addproduct.viewModel.AddViewModelFactory
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory
import kotlinx.coroutines.launch


class AddProductFragment : Fragment() {
    private lateinit var addViewModel: AddViewModel
    private lateinit var listViewModel: ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = AddViewModelFactory(Repository())
        val factory2 = ListViewModelFactory(Repository())
        addViewModel = ViewModelProvider(this, factory).get(AddViewModel::class.java)
        listViewModel = ViewModelProvider(this, factory2).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_product, container, false)
        val title = view.findViewById<EditText>(R.id.titleTextViewAdd)
        val price = view.findViewById<EditText>(R.id.priceTextViewAdd)
        val amount = view.findViewById<EditText>(R.id.amountTextViewAdd)
        val description = view.findViewById<EditText>(R.id.descriptionTextViewAdd)
        val isActive = view.findViewById<Switch>(R.id.switch3)

        val button = view.findViewById<Button>(R.id.addProductButton)

        button.setOnClickListener {
            addViewModel.product.value.let {
                if (it != null) {
                    it.title = title.text.toString()
                }
                if (it != null) {
                    it.price_per_unit = price.text.toString()
                }
                if(it!=null){
                    it.units = amount.text.toString()
                }
                if(it!=null){
                    it.description = description.text.toString()
                }
                if(it!=null){
                    it.is_active = isActive.isChecked
                }
            }
            addViewModel.addProduct()
            listViewModel.getProducts()
            findNavController().navigate(R.id.action_addProductFragment_to_myMarketFragment)

        }


        return view
    }
}