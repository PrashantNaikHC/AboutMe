package com.hyperclock.prashant.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.hyperclock.prashant.aboutme.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myName: MyName = MyName("Prashant Naik")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myNameVar= myName

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

        //below code is redundant due to the databinding implementation
        /*findViewById<Button>(R.id.done).setOnClickListener {
            addNickName(it)
        }*/
    }

    private fun addNickName(view: View) {

        binding.apply {
            //textView.text = binding.editText.text
            myNameVar?.nickname = editText.text.toString()
            invalidateAll()
            textView.visibility = View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
