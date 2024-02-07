package com.leandro.taskapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.leandro.taskapp.R
import com.leandro.taskapp.databinding.FragmentRegisterBinding
import com.leandro.taskapp.utils.initToolBar


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolBar(binding.toolbar)
        initListener()
    }

    private fun initListener() {

        binding.btnRegister.setOnClickListener {
            validateFields()

        }


    }

    private fun validateFields() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()


        if (email.isNotEmpty()) {

            if (password.isNotEmpty()) {
                Toast.makeText(requireContext(), "Cadastro realizado com sucesso", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Preencha o campo com uma  senha", Toast.LENGTH_SHORT)
                    .show()
            }

        } else {
            Toast.makeText(requireContext(), "Preencha com um email válido", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}