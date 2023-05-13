package com.android.mykeyboard.utils

import android.util.SparseArray

object QwertyConstants {

    //Array can be used instead of a map to improve performance as the mapping is one-to-one and integer-based.
    private val CHARACTER_MAP = SparseArray<Char>().apply {
        for (i in 0..25) {
            put(i + 97, (i + 97).toChar())
        }
    }

    // Returns the character mapped to the given key code, or null if the key code is outside the range of a to z.
    fun getCharacter(code: Int): Char? {
        return CHARACTER_MAP.get(code)
    }
}