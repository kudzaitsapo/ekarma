package com.kudzaitsapo.karmanote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import karmanote.R
import karmanote.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bindingRoot: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingRoot = ActivityMainBinding.inflate(layoutInflater)
        //setTheme(R.style.Theme_EKarma)

        setContentView(bindingRoot.root)


    }
}