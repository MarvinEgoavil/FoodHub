package com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentSendEmailBinding


class SendEmailFragment : Fragment() {

    private lateinit var binding:FragmentSendEmailBinding

    private lateinit var btnSendEmail: Button
    private lateinit var verifyFragment: VerifyFragment

    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSendEmailBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSendEmail = binding.btnSendEmail

        verifyFragment= VerifyFragment()

        mainActivity = activity as MainActivity

        btnSendEmail.setOnClickListener {
            mainActivity.openFragment(verifyFragment)
        }


    }
}