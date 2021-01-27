package com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentVerifyBinding


class VerifyFragment : Fragment() {

    private lateinit var binding:FragmentVerifyBinding
    private lateinit var mainActivity: MainActivity
    private lateinit var btnVerificar: Button
    private lateinit var resetPasswordFragment: ResetPasswordFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVerifyBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnVerificar =binding.btnVerificar

        resetPasswordFragment = ResetPasswordFragment()

         mainActivity = activity as MainActivity

        btnVerificar.setOnClickListener {
            mainActivity.openFragment(resetPasswordFragment)
        }


    }
}