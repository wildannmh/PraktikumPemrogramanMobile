package com.example.praktikumpemob2025.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.praktikumpemob2025.R
import com.example.praktikumpemob2025.databinding.FragmentBookDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BookDetailFragment(
    private val title: String,
    private val author: String,
    private val year: String,
    private val coverId: Int) : BottomSheetDialogFragment() {
    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        constrainer: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailBinding.inflate(inflater, constrainer, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadData() {
        Toast.makeText(context, "$coverId", Toast.LENGTH_SHORT).show()
        binding.textViewTitle.text = title
        binding.textViewAuthor.text = author
        binding.textViewYear.text = year

        if (coverId != 0) {
            val url = "https://covers.openlibrary.org/b/id/$coverId-M.jpg"
            Glide.with(this)
                .load(url)
                .into(binding.imageViewCover)
        } else {
            binding.imageViewCover.setImageResource(
                R.drawable.book_not_found
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }
}