package com.example.cp_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cp_mobile.R

class Home : Fragment() {

    private var nome: String? = null
    private var email: String? = null
    private var telefone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nome = it.getString(ARG_NOME)
            email = it.getString(ARG_EMAIL)
            telefone = it.getString(ARG_TELEFONE)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val textViewNome = view.findViewById<TextView>(R.id.editTextNome)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewTelefone = view.findViewById<TextView>(R.id.textViewTelefone)

        textViewNome?.text = "Nome: ${nome}me"
        textViewEmail?.text = "Email: $email"
        textViewTelefone?.text = "Telefone: $telefone"

        return view
    }

    companion object {
        private const val ARG_NOME = "nome"
        private const val ARG_EMAIL = "email"
        private const val ARG_TELEFONE = "telefone"

        @JvmStatic
        fun newInstance(nome: String, email: String, telefone: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_NOME, nome)
                    putString(ARG_EMAIL, email)
                    putString(ARG_TELEFONE, telefone)
                }
            }
    }
}