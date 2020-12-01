package com.eminesa.udacityproject1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.eminesa.udacityproject1.R
import com.eminesa.udacityproject1.databinding.FragmentLoginBinding
import com.eminesa.udacityproject1.helper.CacheHelper
import com.eminesa.udacityproject1.util.MailValidation

class LoginFragment : Fragment() {

    private var cacheHelper: CacheHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )

        cacheHelper = CacheHelper(requireContext())
        val cacheEmail = cacheHelper?.fetchUserName()
        val cachePassword = cacheHelper?.fetchUserPassword()

        binding.loginButton.setOnClickListener { v: View ->

            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (cacheEmail != null && cachePassword != null){
                when {
                    email != cacheEmail -> {
                        Toast.makeText(requireContext(), getString(R.string.email_not_match), Toast.LENGTH_SHORT)
                            .show()
                    }
                    password != cachePassword ->{
                        Toast.makeText(requireContext(), getString(R.string.password_not_match), Toast.LENGTH_SHORT)
                            .show()
                    }

                    email == cacheEmail && password == cachePassword ->{
                        view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
                    }

                }
            }
             else{
                Toast.makeText(requireContext(), getString(R.string.need_to_sign_up), Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.registerButton.setOnClickListener { v: View ->
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            when {
                email.isEmpty() -> {
                    Toast.makeText(requireContext(), getString(R.string.email_required), Toast.LENGTH_SHORT)
                        .show()
                }
                !MailValidation.EMAIL_ADDRESS_PATTERN.matcher(email).matches() -> {
                    Toast.makeText(requireContext(), getString(R.string.email_is_invalid), Toast.LENGTH_SHORT)
                        .show()
                }
                password.isEmpty() || password.length < 3 -> {
                    Toast.makeText(requireContext(), getString(R.string.password_required), Toast.LENGTH_SHORT)
                        .show()
                }

                email.isNotBlank() && MailValidation.EMAIL_ADDRESS_PATTERN.matcher(email)
                    .matches() && password.isNotBlank() -> {
                    cacheHelper?.saveUserName(email)
                    cacheHelper?.saveUserPassword(password)
                    view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
                }
            }
        }

        return binding.root
    }

  /**
   * change navigation destination
   *  private fun LoginFragment.changeDestination() {
        val finalHost = NavHostFragment.create(R.navigation.second_navigation_graph)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.myNavHostFragment, finalHost)
            ?.setPrimaryNavigationFragment(finalHost) // equivalent to app:defaultNavHost="true"
            ?.commit()
    }  */
}
