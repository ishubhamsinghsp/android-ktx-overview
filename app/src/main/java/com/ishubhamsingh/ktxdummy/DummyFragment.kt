package com.ishubhamsingh.ktxdummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ishubhamsingh.ktxdummy.databinding.FragmentDummyBinding
import kotlinx.coroutines.launch

/**
 * Created by Shubham Singh on 1/2/21.
 */
class DummyFragment: Fragment() {

    private var _binding: FragmentDummyBinding? = null
    private val binding get() = _binding

    private val viewModelKTX by activityViewModels<MainActivityViewModel>() // Getting activity's viewModel instance

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDummyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Scope is attached to lifecycle of the fragment
        viewLifecycleOwner.lifecycleScope.launch {
            // Do some async task
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}