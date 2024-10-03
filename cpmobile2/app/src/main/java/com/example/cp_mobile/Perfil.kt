package com.example.cp_mobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Perfil : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_perfil2, container, false)

        val textViewNome = view.findViewById<TextView>(R.id.textViewNome)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewTelefone = view.findViewById<TextView>(R.id.textViewTelefone)

        textViewNome?.text = "Nome: $nome"
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
            Perfil().apply {
                arguments = Bundle().apply {
                    putString(ARG_NOME, nome)
                    putString(ARG_EMAIL, email)
                    putString(ARG_TELEFONE, telefone)
                }
            }
    }
}