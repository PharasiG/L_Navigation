package com.example.l_navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.l_navigation.databinding.FragmentFirstBinding
import com.example.l_navigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSecondBinding.bind(view)
        navController = findNavController()
        binding.text2.setOnClickListener {
            navController.navigateUp()
        }

        binding.activity3bt.setOnClickListener {
            val intent = Intent(activity, ViewPagerActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance() = SecondFragment()
    }
}