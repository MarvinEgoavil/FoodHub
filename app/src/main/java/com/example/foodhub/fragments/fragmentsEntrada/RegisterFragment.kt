package com.example.foodhub.fragments.fragmentsEntrada

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                mainActivity = activity as MainActivity
                val transaction = parentFragmentManager.beginTransaction()
                transaction.setCustomAnimations(R.anim.slide_down_bueno, R.anim.fragment_close_exit)
                transaction.replace(R.id.fragment_container, loginFragment)
                transaction.disallowAddToBackStack()
                transaction.commit()
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideSoftKeyboard()


    }

    private fun hideSoftKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0)
    }

    companion object {
        var mainActivity: MainActivity = MainActivity()
        var loginFragment: LoginFragment = LoginFragment()
    }
}