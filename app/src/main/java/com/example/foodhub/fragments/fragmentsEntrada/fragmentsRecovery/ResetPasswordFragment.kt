package com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment() {

 private lateinit var binding:FragmentResetPasswordBinding
 private lateinit var congratulationsFragment: CongratulationsFragment
 private lateinit var btnResetPass:Button


 private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnResetPass=binding.btnResetPass
        congratulationsFragment= CongratulationsFragment()

        mainActivity = activity as MainActivity

        btnResetPass.setOnClickListener {
            mainActivity.openFragment(congratulationsFragment)
        }

    }
}