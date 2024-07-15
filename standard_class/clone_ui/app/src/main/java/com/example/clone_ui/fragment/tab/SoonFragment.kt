package com.example.clone_ui.fragment.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clone_ui.databinding.FragmentSoonBinding

class SoonFragment : Fragment() {
   private lateinit var binding: FragmentSoonBinding

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSoonBinding.inflate(inflater)
        return binding.root
    }
}