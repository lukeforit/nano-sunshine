package com.green.rabbit.sunshine.app.common;

import android.content.Context;
import android.support.v7.preference.EditTextPreference;
import android.util.AttributeSet;

/**
 * Created by Łukasz on 03.01.2018.
 */

public class CustomEditTextPreference extends EditTextPreference {
    public CustomEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomEditTextPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomEditTextPreference(Context context) {
        super(context);
    }

    @Override
    public CharSequence getSummary() {
        return prepareSummary(getText());
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        //TODO make use of %s
        setSummary(prepareSummary(text));
    }

    private CharSequence prepareSummary(String text) {
        CharSequence summary = super.getSummary();
        return summary != null ? String.format(summary.toString(), text) : text;
    }
}
