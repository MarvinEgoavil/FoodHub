package com.example.foodhub.fragments.fragmentsEntrada

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.foodhub.R
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentLoginBinding
import com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery.SendEmailFragment


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private lateinit var tvRegistrarse:TextView
    private lateinit var tvOlvidaste:TextView
    private lateinit var mainActivity: MainActivity

    private lateinit var registerFragment: RegisterFragment

    private lateinit var sendEmailFragment:SendEmailFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideSoftKeyboard()

        tvRegistrarse= binding.TvRegistrar
        tvOlvidaste=binding.TvOlvidaste

        mainActivity  = activity as MainActivity
        registerFragment = RegisterFragment()
        sendEmailFragment= SendEmailFragment()

        tvRegistrarse.setOnClickListener {
            mainActivity.openFragment(registerFragment)

        }

        tvOlvidaste.setOnClickListener {
            mainActivity.openFragment(sendEmailFragment)
        }
    }



    private fun hideSoftKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
    }



}