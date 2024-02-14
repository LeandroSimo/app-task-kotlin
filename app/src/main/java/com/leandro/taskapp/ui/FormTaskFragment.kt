package com.leandro.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.leandro.taskapp.R
import com.leandro.taskapp.databinding.FragmentFormTaskBinding
import com.leandro.taskapp.utils.initToolBar
import com.leandro.taskapp.utils.showBottomSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar(binding.toolbar)

        initListener()
    }

    private fun initListener() {

        binding.btnSaveTask.setOnClickListener {
            validateFields()

        }

    }

    private fun validateFields() {
        val email = binding.edtTask.text.toString().trim()


        if (email.isNotEmpty()) {

            Toast.makeText(requireContext(), "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show()

        } else {
            showBottomSheet(messageDialog = getString(R.string.description_empty_form_task_fragment))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}