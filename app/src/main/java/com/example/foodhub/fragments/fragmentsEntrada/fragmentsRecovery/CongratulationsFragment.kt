package com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentCongratulationsBinding
import com.example.foodhub.fragments.fragmentsEntrada.LoginFragment


class CongratulationsFragment : Fragment() {

    private lateinit var binding : FragmentCongratulationsBinding
    private lateinit var loginFragment: LoginFragment
    private lateinit var btnContinuar: Button
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCongratulationsBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnContinuar = binding.btnContinuar
        loginFragment = LoginFragment()
        mainActivity = activity as MainActivity
        btnContinuar.setOnClickListener {
            mainActivity.openFragment(loginFragment)
        }
    }
}