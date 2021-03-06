package com.example.marketplace.timeline.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.profile.viewModel.UserInfoViewModel
import com.example.marketplace.profile.viewModel.UserInfoViewModelFactory
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory
import com.example.marketplace.timeline.model.Product


class CustomerDetailFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var profileViewModel: UserInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ListViewModelFactory(Repository())
        val factory1 = UserInfoViewModelFactory(Repository())
        viewModel = ViewModelProvider(requireActivity(), factory).get(ListViewModel::class.java)
        profileViewModel = ViewModelProvider(requireActivity(),factory1).get(UserInfoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customer_detail, container, false)

        val productItem: Product = viewModel.getProduct()

        val seller: TextView = view.findViewById(R.id.sellerTextViewDetail)
        val date: TextView = view.findViewById(R.id.dateTextView)
        val productName: TextView = view.findViewById(R.id.productNameTextViewDetail)
        val description: TextView = view.findViewById(R.id.descriptionTextView)
        val active: TextView = view.findViewById(R.id.activeTextView)
        val price: TextView = view.findViewById(R.id.priceTextViewDetail)
        val unit: TextView = view.findViewById(R.id.unitsTextViewDetail)
        val priceItem: TextView = view.findViewById(R.id.priceItemTextViewDetail)

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

        seller.setOnClickListener {
            profileViewModel.user.value!!.username = productItem.username
            findNavController().navigate(R.id.action_customerDetailFragment_to_otherProfileFragment)

        }

        return view
    }


}