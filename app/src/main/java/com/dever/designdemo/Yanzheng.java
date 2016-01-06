package com.dever.designdemo;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Android Studio
 * Time: 2016/1/6 15:11
 * Author: wangmeng
 */
public class Yanzheng implements TextWatcher {
    private TextInputLayout textInputLayout;

    public Yanzheng(TextInputLayout textInputLayout) {
        this.textInputLayout = textInputLayout;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(s.toString());
        if(matcher.matches()){
            textInputLayout.setErrorEnabled(false);
        }else{
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError("邮箱不正确");
        }
    }
}
