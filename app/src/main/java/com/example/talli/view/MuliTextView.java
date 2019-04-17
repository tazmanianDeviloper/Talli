package com.example.talli.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;

import com.example.talli.util.FontTypeface;

public class MuliTextView extends AppCompatTextView {

    private Context context;

    public MuliTextView(Context context) {
        super(context);
        this.context = context;
        createView();
    }

    public MuliTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        createView();
    }

    private void createView(){
        setGravity(Gravity.CENTER);
        setTypeface(FontTypeface.get("muli_light.ttf", context));
    }


    public void setImage(String image){
        setText(image);
    }
}
