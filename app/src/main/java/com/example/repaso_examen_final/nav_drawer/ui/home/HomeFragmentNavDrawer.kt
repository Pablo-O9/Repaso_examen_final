package com.example.repaso_examen_final.nav_drawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.repaso_examen_final.databinding.FragmentHomeNavDrawerBinding

class HomeFragmentNavDrawer : Fragment() {

    private var _binding: FragmentHomeNavDrawerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModelNavDrawer::class.java)

        _binding = FragmentHomeNavDrawerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHomeNavDrawer
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}