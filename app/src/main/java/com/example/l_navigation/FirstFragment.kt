package com.example.l_navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.l_navigation.databinding.ActivityMainBinding
import com.example.l_navigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFirstBinding.bind(view)
//        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
        navController = findNavController()
        binding.text1.setOnClickListener {
            navController.navigate(R.id.first_to_second)
            Toast.makeText(activity, "done!", Toast.LENGTH_SHORT).show()
        }

        binding.activity2bt.setOnClickListener {
            val intent = Intent(activity, BottomNavActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}