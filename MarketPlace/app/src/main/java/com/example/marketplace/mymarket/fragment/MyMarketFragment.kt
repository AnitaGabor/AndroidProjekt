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
import com.example.marketplace.R
import com.example.marketplace.mymarket.adapter.MyMarketDataAdapter
import com.example.marketplace.mymarket.viewModel.MyMarketViewModel
import com.example.marketplace.mymarket.viewModel.MyMarketViewModelFactory
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product



class MyMarketFragment : Fragment() , MyMarketDataAdapter.OnItemClickListener, MyMarketDataAdapter.OnItemLongClickListener {
    lateinit var myMarketViewModel: MyMarketViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: MyMarketDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = MyMarketViewModelFactory(Repository())
        myMarketViewModel = ViewModelProvider(this, factory).get(MyMarketViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_my_market, container, false)
        recycler_view = view.findViewById(R.id.recycler_view2)
        setupRecyclerView()
        myMarketViewModel.products.observe(viewLifecycleOwner){
            adapter.setData(myMarketViewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }

        val button = view.findViewById<View>(R.id.addButton)

        button.setOnClickListener {
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.addProductFragment)
        }
        return view
    }

    private fun setupRecyclerView(){
        adapter = MyMarketDataAdapter(ArrayList<Product>(), this, this)
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
        myMarketViewModel.currentPosition = position
        findNavController().navigate(R.id.action_myMarketFragment_to_customerDetailFragment)
        Log.d("Adapter", "AdapterPosition: $position")
    }

    override fun onItemLongClick(position: Int) {
//        TODO("Not yet implemented")
    }

}

