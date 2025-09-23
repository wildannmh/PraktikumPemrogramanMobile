package com.example.praktikumpemob2025

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.praktikumpemob2025.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHalaman2Binding

    private val latitude = "-7.429427"

    private val longitude = "109.338082"

    private val gMapsUrl = "http://maps.google.com/maps?q=loc:"

    private val packageMaps = "com.google.android.apps.maps"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutLocation.let {
            it.imgIcon.setImageResource(R.drawable.ic_location)
            it.tvLayout.setText(R.string.alamat)
        }

        binding.layoutEmail.let {
            it.imgIcon.setImageResource(R.drawable.ic_email)
            it.tvLayout.setText(R.string.email)
        }

        binding.layoutIg.let {
            it.imgIcon.setImageResource(R.drawable.ic_himpunan)
            it.tvLayout.setText(R.string.ig_himpunan)
        }

        binding.layoutPhone.let {
            it.imgIcon.setImageResource(R.drawable.ic_phone)
            it.tvLayout.setText(R.string.telepon)
        }
    }

    private fun initListener() {
        binding.layoutLocation.root.setOnClickListener {
            val gMapsIntentUrl = "$gMapsUrl$latitude,$longitude".toUri()
            val mapIntent = Intent( Intent.ACTION_VIEW, gMapsIntentUrl)
            startActivity( mapIntent.setPackage(packageMaps))
        }

        binding.layoutIg.root.setOnClickListener {
            val intent = Intent( Intent.ACTION_VIEW)
            intent.data = getString( R.string.ig_himpunan).toUri()
            startActivity(intent)
        }

        binding.layoutEmail.root.setOnClickListener {
            val intent = Intent( Intent.ACTION_SENDTO).apply {
                data = "mailto:${getString(R.string.email)}".toUri()
            }
            startActivity(intent)
        }

        binding.layoutPhone.root.setOnClickListener {
            val intent = Intent( Intent.ACTION_DIAL).apply {
                data = "tel:${getString(R.string.telepon)}".toUri()
            }
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}