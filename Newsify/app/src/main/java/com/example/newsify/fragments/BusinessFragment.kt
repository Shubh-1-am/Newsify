package com.example.newsify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.newsify.adapters.NewsPagingCustomAdapter
import com.example.newsify.adapters.OnAdapterClickListener
import com.example.newsify.databinding.FragmentBusinessBinding
import com.example.newsify.retrofit.response.Article
import com.example.newsify.viewModels.MainActivityViewModel

class BusinessFragment : Fragment() , OnAdapterClickListener{

    private var _binding: FragmentBusinessBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var adapter: NewsPagingCustomAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBusinessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        adapter = NewsPagingCustomAdapter(this)
        viewModel.getBusinessNews().observe(viewLifecycleOwner) { pagingData ->
            adapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }
    }

    override fun onAdapterClick(article: Article) {
        TODO("Not yet implemented")
    }

}