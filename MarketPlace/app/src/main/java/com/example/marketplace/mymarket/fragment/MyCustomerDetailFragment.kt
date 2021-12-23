package com.example.marketplace.mymarket.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory
import com.example.marketplace.updateProduct.viewModel.UpdateViewModel
import com.example.marketplace.updateProduct.viewModel.UpdateViewModelFactory


class MyCustomerDetailFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var updateViewModel: UpdateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ListViewModelFactory(Repository())
        val factory2 = UpdateViewModelFactory(Repository())
        viewModel = ViewModelProvider(requireActivity(), factory).get(ListViewModel::class.java)
        updateViewModel = ViewModelProvider(requireActivity(),factory2).get(UpdateViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_customer_detail, container, false)

        val productItem: Product = viewModel.getProduct()

        val seller: TextView = view.findViewById(R.id.sellerTextViewMyDetail)
        val date: TextView = view.findViewById(R.id.dateTextViewMy)
        val productName: TextView = view.findViewById(R.id.productNameTextViewMyDetail)
        val description: TextView = view.findViewById(R.id.descriptionTextViewMy)
        val active: TextView = view.findViewById(R.id.activeTextViewMy)
        val price: TextView = view.findViewById(R.id.priceTextViewMyDetail)
        val unit: TextView = view.findViewById(R.id.unitsTextViewMyDetail)
        val priceItem: TextView = view.findViewById(R.id.priceItemTextViewMyDetail)
        val button = view.findViewById<Button>(R.id.button2)

        seller.text = productItem.username
        date.text = productItem.creation_time.toString()
        productName.text = productItem.title
        description.text = productItem.description
        if(productItem.is_active){
            active.text = "Active"
        }
        else{
            active.text = "Inactive"
        }
        price.text = productItem.price_per_unit
        unit.text = productItem.units
        priceItem.text = productItem.price_per_unit

        button.setOnClickListener {
            updateViewModel.product.value!!.product_id = productItem.product_id
            findNavController().navigate(R.id.action_myCustomerDetailFragment_to_updateProductFragment)
        }
        return view
    }


}