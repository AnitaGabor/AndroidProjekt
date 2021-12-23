package com.example.marketplace.mymarket.fragment



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.MyApplication
import com.example.marketplace.R
import com.example.marketplace.mymarket.adapter.MyMarketDataAdapter
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory


class MyMarketFragment : Fragment() , MyMarketDataAdapter.OnItemClickListener{
    lateinit var myMarketViewModel: ListViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: MyMarketDataAdapter
    private var myProducts: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ListViewModelFactory(Repository())
        myMarketViewModel = ViewModelProvider(requireActivity(), factory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_my_market, container, false)
        recycler_view = view.findViewById(R.id.recycler_view2)
        setupRecyclerView()
        myMarketViewModel.getProducts()
        myMarketViewModel.products.observe(viewLifecycleOwner){
            myProducts = myMarketViewModel.products.value!!.filter{
                it.username.equals(MyApplication.username)
            } as ArrayList<Product>
            adapter.setData(myProducts)
            adapter.notifyDataSetChanged()
        }

        val button = view.findViewById<View>(R.id.addButton)

        button.setOnClickListener {
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.addProductFragment)
        }
        return view
    }

    private fun setupRecyclerView(){
        adapter = MyMarketDataAdapter(ArrayList<Product>(), this, myMarketViewModel)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val product = myProducts[position]
        myMarketViewModel.currentPosition = myMarketViewModel.products.value!!.indexOf(product)
        findNavController().navigate(R.id.action_myMarketFragment_to_myCustomerDetailFragment)
        Log.d("Adapter", "AdapterPosition: $position")
    }


}

