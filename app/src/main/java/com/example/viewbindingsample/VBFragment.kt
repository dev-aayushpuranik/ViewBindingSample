package com.example.viewbindingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewbindingsample.databinding.FragmentVBBinding

class VBFragment : Fragment() {

    private var _binding: FragmentVBBinding? = null
    private val binding get() = _binding!!
    private var status: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVBBinding.inflate(inflater)

        val view = binding.root
        // Inflate the layout for this fragment

        binding.clickActionBtn.setOnClickListener {
            val text = if(status) "Button Clicked" else ""
            binding.dataTV.text = text

            status = !status

        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}