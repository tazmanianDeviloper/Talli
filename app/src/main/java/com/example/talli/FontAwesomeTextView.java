package com.example.talli;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;


public class FontAwesomeTextView extends android.support.v7.widget.AppCompatTextView {

    private Context context;

    public FontAwesomeTextView(Context context) {
        super(context);
        this.context = context;
        createView();
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        createView();
    }

    private void createView(){
        setGravity(Gravity.CENTER);
        Typeface tf = Typeface.createFromAsset
                (getContext().getAssets(), "fonts/font_awesome_5_pro_light_300.otf");
        setTypeface (tf);
    }
}