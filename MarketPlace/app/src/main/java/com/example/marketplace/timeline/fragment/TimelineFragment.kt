package com.example.marketplace.timeline.fragment



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marketplace.timeline.adapter.TimeLineDataAdapter
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import com.example.marketplace.timeline.viewModel.ListViewModel
import com.example.marketplace.timeline.viewModel.ListViewModelFactory


class TimeLineFragment : Fragment() , TimeLineDataAdapter.OnItemClickListener, TimeLineDataAdapter.OnItemLongClickListener {
    lateinit var listViewModel: ListViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: TimeLineDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ListViewModelFactory(Repository())
        listViewModel = ViewModelProvider(this, factory).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_time_line, container, false)
        recycler_view = view.findViewById(R.id.recycler_view)
        setupRecyclerView()
        listViewModel.products.observe(viewLifecycleOwner){
            adapter.setData(listViewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }
        return view
    }

    private fun setupRecyclerView(){
        adapter = TimeLineDataAdapter(ArrayList<Product>(), this, this)
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
        findNavController().navigate(R.id.action_timeLineFragment_to_customerDetailFragment)
        Log.d("Adapter", "AdapterPosition: $position")
    }

    override fun onItemLongClick(position: Int) {
//        TODO("Not yet implemented")
    }

}

