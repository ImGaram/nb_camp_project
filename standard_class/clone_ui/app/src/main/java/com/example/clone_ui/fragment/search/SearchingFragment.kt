package com.example.clone_ui.fragment.search

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.clone_ui.R
import com.example.clone_ui.databinding.FragmentSearchingBinding
import com.example.clone_ui.fragment.SearchFragment

class SearchingFragment : Fragment() {
    private lateinit var binding: FragmentSearchingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchingBinding.inflate(inflater)
        val res = arguments?.getString("category")
        val editText = binding.searchingEditText

        editText.setText(res)
        editText.setKeyboard()

        binding.searchingBackImage.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SearchFragment())
                .commit()
        }

        return binding.root
    }

    private fun EditText.setKeyboard() {
        requestFocus()
        postDelayed({
            // 키보드 열기.
            val inputMethodManager = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }, 30)

        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == IME_ACTION_SEARCH) {
                // 키보드 닫기.
                val inputMethodManager = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                clearFocus()
            }
            true
        }
    }
}