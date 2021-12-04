package com.example.marketplace.fragments



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
import com.example.marketplace.adapter.DataAdapter
import com.example.marketplace.R
import com.example.marketplace.models.Product
import com.example.marketplace.repository.Repository
import com.example.marketplace.viewModel.ListViewModel
import com.example.marketplace.viewModel.ListViewModelFactory


class TimeLineFragment : Fragment() , DataAdapter.OnItemClickListener,  DataAdapter.OnItemLongClickListener {

    private lateinit var viewModel: ListViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = ListViewModelFactory(Repository())
        viewModel = ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_time_line, container, false)
        Log.d("List", "ListFragment - onCreateView")
        recycler_view = layout.findViewById(R.id.recycler_view)
        setupRecyclerView()
        viewModel.products.observe(viewLifecycleOwner){
            adapter.setData(viewModel.products.value as ArrayList<Product>)
            adapter.notifyDataSetChanged()
        }

        return layout
    }

    private fun setupRecyclerView(){
        adapter = DataAdapter(ArrayList<Product>(), this.requireContext(), this, this)
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
        viewModel.currentPosition = position
        findNavController().navigate(R.id.action_timeLineFragment_to_customerDetailFragment)
        Log.d("Adapter", "AdapterPosition: $position")
    }

    override fun onItemLongClick(position: Int) {
        TODO("Not yet implemented")
    }


}