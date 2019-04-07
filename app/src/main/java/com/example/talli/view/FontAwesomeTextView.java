package com.example.talli.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

import com.example.talli.util.FontTypeface;

public class FontAwesomeTextView extends AppCompatTextView {

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
        setTypeface(FontTypeface.get("font_awesome_5_pro_light_300.otf", context));
    }


    public void setImage(String image){
        setText(image);
    }
}
