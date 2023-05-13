package com.android.mykeyboard.keyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class MyKeyboardView extends KeyboardView {
    private Context mContext;
    private Keyboard mKeyBoard;
    public MyKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public MyKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }


}
