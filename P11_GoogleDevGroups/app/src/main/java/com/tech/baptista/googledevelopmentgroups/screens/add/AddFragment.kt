package com.tech.baptista.googledevelopmentgroups.screens.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tech.baptista.googledevelopmentgroups.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private val viewModel: AddViewModel by lazy {
        ViewModelProvider(this).get(AddViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(inflater)

        return binding.root
    }
}