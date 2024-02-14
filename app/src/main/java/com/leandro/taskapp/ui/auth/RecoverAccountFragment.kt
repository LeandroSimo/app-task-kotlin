package com.leandro.taskapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.leandro.taskapp.R
import com.leandro.taskapp.databinding.FragmentRecoverAccountBinding
import com.leandro.taskapp.utils.initToolBar
import com.leandro.taskapp.utils.showBottomSheet


class RecoverAccountFragment : Fragment() {

    private var _binding: FragmentRecoverAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoverAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar(binding.toolbar)

        initListener()
    }

    private fun initListener() {

        binding.btnRecoverAccount.setOnClickListener {
            validateFields()
        }


    }

    private fun validateFields() {
        val email = binding.edtEmail.text.toString().trim()

        if (email.isNotEmpty()) {

            Toast.makeText(requireContext(), "Email enviado com sucesso", Toast.LENGTH_SHORT)
                .show()

        } else {
            showBottomSheet(messageDialog = getString(R.string.email_empty))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}