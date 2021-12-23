package com.example.marketplace.timeline.fragment



import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.MainActivity
import com.example.marketplace.timeline.adapter.TimeLineDataAdapter
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory
import android.app.SearchManager
import android.content.Context

import android.view.MenuInflater





class TimeLineFragment : Fragment() , TimeLineDataAdapter.OnItemClickListener {
    lateinit var listViewModel: ListViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: TimeLineDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val factory = ListViewModelFactory(Repository())
        listViewModel = ViewModelProvider(requireActivity(), factory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_time_line, container, false)
        recycler_view = view.findViewById(R.id.recycler_view)
        setupRecyclerView()
        listViewModel.getProducts()
        listViewModel.products.observe(viewLifecycleOwner){
            adapter.setData(listViewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun setupRecyclerView(){
        adapter = TimeLineDataAdapter(ArrayList<Product>(), this)
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
        listViewModel.currentPosition = position
        Log.d("xxx","Position: ${listViewModel.currentPosition}")
        findNavController().navigate(R.id.action_timeLineFragment_to_customerDetailFragment)
        Log.d("Adapter", "AdapterPosition: $position")
    }

}


