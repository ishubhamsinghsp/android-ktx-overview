package com.ishubhamsingh.ktxdummy

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.ishubhamsingh.ktxdummy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    private val viewModelKtx by viewModels<MainActivityViewModel>()  //viewmodel ktx

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainActivityViewModel()

        binding.tvDummy.text = viewModelKtx.getText()

        // Adding a Text watcher
        binding.etDummy.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                handleText(p0)
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

        })

        // Using KTX
        binding.etDummy.doOnTextChanged { text, start, before, count -> handleText(text) }

        addFragmentKTX()
        textKtx()
    }

    private fun addFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_frame, DummyFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
        fragmentTransaction.commit()
    }

    private fun addFragmentKTX() {
        supportFragmentManager.commit {
            addToBackStack(null)
            setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim)
            replace(R.id.fragment_frame, DummyFragment())
        }
    }

    private fun textKtx() {
        val uri = Uri.parse("https://google.com")
        val uriKtx = "https://google.com".toUri() // Similarly for other data types
    }

    private fun handleText(text: CharSequence?) {
        // Do something
    }
}