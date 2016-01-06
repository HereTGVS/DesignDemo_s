package com.dever.designdemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        textInput = (TextInputLayout) findViewById(R.id.text_input);
        textInput.getEditText().addTextChangedListener(new Yanzheng(textInput));
    }
}
