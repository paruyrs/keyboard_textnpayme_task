package com.android.mykeyboard.service

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.LayoutInflater
import android.view.View
import com.android.mykeyboard.R
import com.android.mykeyboard.databinding.KeyboardViewBinding
import com.android.mykeyboard.keyboard.MyKeyboardView
import com.android.mykeyboard.utils.QwertyConstants.getCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImeService : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    private lateinit var binding: KeyboardViewBinding
    private lateinit var myKeyboard: MyKeyboardView

    override fun onCreateInputView(): View {
        binding = KeyboardViewBinding.inflate(LayoutInflater.from(this), null, false)

        myKeyboard = binding.keyboardview as MyKeyboardView
        myKeyboard.keyboard = Keyboard(this, R.xml.qwerty_en)
        myKeyboard.isPreviewEnabled = false
        setInputView(binding.root)
        myKeyboard.setOnKeyboardActionListener(this)

        return binding.root
    }

    companion object {
        private const val TAG = "MyIMService"
    }

    override fun onPress(primaryCode: Int) {
    }

    override fun onRelease(primaryCode: Int) {
    }

    //Using coroutines make custom keyboard more responsive and faster by running text committing operations asynchronously without blocking the main UI thread.
    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val inputConnection = currentInputConnection
        val character = getCharacter(primaryCode)
        when {
            inputConnection != null && character != null -> {
                CoroutineScope(Dispatchers.Default).launch {
                    inputConnection.commitText(character.toString(), 1)
                }
            }
        }
    }
    override fun onText(text: CharSequence?) {
    }

    override fun swipeLeft() {
    }

    override fun swipeRight() {
    }

    override fun swipeDown() {
    }

    override fun swipeUp() {
    }
}