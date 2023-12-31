package com.example.apiauthexercise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.apiauthexercise.MyApplication
import com.example.apiauthexercise.R
import com.example.apiauthexercise.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var foodViewModel: FoodViewModel

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodViewModel = (requireActivity().application as MyApplication).viewModelFactory.create(FoodViewModel::class.java)

        observeLiveData()

        binding.submitButton.setOnClickListener {
            foodViewModel.getFood()
        }
    }

    fun observeLiveData(){
        foodViewModel.result.observe(viewLifecycleOwner) { foodData ->
            val foodList = foodData?.food
            val countList = foodData?.count

            if (foodList != null){
                binding.textviewFirst.text = foodList.get(0).foodName
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}