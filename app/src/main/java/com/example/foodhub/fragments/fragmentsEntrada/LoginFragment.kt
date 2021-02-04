package com.example.foodhub.fragments.fragmentsEntrada

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.example.foodhub.R
import com.example.foodhub.activities.HomeActivity
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentLoginBinding
import com.example.foodhub.fragments.fragmentsEntrada.fragmentsRecovery.SendEmailFragment


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private lateinit var tvRegistrarse: TextView
    private lateinit var tvOlvidaste: TextView
    private lateinit var mainActivity: MainActivity

    private lateinit var registerFragment: RegisterFragment

    private lateinit var sendEmailFragment: SendEmailFragment

    private lateinit var btnLogin: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hideSoftKeyboard()

        tvRegistrarse = binding.TvRegistrar
        tvOlvidaste = binding.TvOlvidaste
        btnLogin = binding.btnLogin

        mainActivity = activity as MainActivity
        registerFragment = RegisterFragment()
        sendEmailFragment = SendEmailFragment()


        tvRegistrarse.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.setCustomAnimations(R.anim.slide_up_bueno,R.anim.slide_out_down)
            transaction.replace(R.id.fragment_container, registerFragment)
            transaction.disallowAddToBackStack()
            transaction.commit()

        }

        tvOlvidaste.setOnClickListener {
            mainActivity.openFragment(sendEmailFragment)
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this.context, HomeActivity::class.java)
            startActivity(intent)
            Animatoo.animateSlideLeft(this.context)

        }

    }


    private fun hideSoftKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().getWindowToken(), 0)
    }


}