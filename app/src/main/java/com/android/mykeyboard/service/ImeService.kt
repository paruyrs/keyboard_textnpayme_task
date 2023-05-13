package com.android.mykeyboard.service


import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View
import android.widget.Button
import com.android.mykeyboard.R
import com.android.mykeyboard.utils.QwertyConstants.Companion.characterMap


class ImeService : InputMethodService(),KeyboardView.OnKeyboardActionListener {
    override fun onCreateInputView(): View {

        val myKeyboardView: View = layoutInflater.inflate(R.layout.keyboard_view, null)
        val myKeyboard: KeyboardView = myKeyboardView.findViewById(R.id.keyboardview)
        myKeyboard.keyboard = Keyboard(this, R.xml.qwerty_en)
        myKeyboard.isPreviewEnabled = false
        setInputView(myKeyboardView)
        myKeyboard.setOnKeyboardActionListener(this)
        return myKeyboardView
    }



    companion object {
        private const val TAG = "MyIMService"
    }

    override fun onPress(primaryCode: Int) {

    }

    override fun onRelease(primaryCode: Int) {
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val inputConnection = currentInputConnection
        if (inputConnection != null) {
            val character = characterMap[primaryCode]
            if (character != null) {
                inputConnection.commitText(character.toString(), 1)
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