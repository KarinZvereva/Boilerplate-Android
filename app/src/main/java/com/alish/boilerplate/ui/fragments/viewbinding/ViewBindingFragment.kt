package com.alish.boilerplate.ui.fragments.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentViewBindingBinding

class ViewBindingFragment : Fragment() {

    private var _binding: FragmentViewBindingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ViewBindingPropertyDelegateFragment : Fragment(R.layout.fragment_view_binding) {

    private val bindingWithoutReflection by viewBinding(FragmentViewBindingBinding::bind)
}