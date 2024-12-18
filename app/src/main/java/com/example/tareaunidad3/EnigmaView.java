package com.example.tareaunidad3;

import android.widget.EditText;
import android.widget.TextView;

public class EnigmaView {
    private EditText editText;
    private TextView textView;

    public EnigmaView(int editTextTextInt, int textViewInt) {
        this.editText = editText.findViewById(editTextTextInt);
        this.textView = textView.findViewById(textViewInt);
    }

    public EditText getEditText() {
        return editText;
    }

    public TextView getTextView() {
        return textView;
    }
}
