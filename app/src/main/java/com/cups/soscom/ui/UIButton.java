package com.cups.soscom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.cups.soscom.R;

/**
 * Created by ekobudiarto on 6/2/17.
 */

public class UIButton extends Button {

    Context mContext;

    public UIButton(Context context) {
        super(context);
        mContext = context;
        setFont();
    }

    public UIButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setDefault(attrs);
    }

    private void setDefault(AttributeSet attributeSet)
    {
        TypedArray arrayFont = mContext.obtainStyledAttributes(attributeSet, R.styleable.UIFontStyle);
        String fontType = (arrayFont.getString(R.styleable.UIFontStyle_fontType) == null) ? "Regular" :
                arrayFont.getString(R.styleable.UIFontStyle_fontType);
        if(fontType.equalsIgnoreCase("bold"))
        {
            setBold();
        }
        else if(fontType.equalsIgnoreCase("light"))
        {
            setLight();
        }
        else if(fontType.equalsIgnoreCase("italic"))
        {
            setItalic();
        }
        else if(fontType.equalsIgnoreCase("medium"))
        {
            setMedium();
        }
        else if(fontType.equalsIgnoreCase("semibold"))
        {
            setSemibold();
        }
        else
        {
            setRegular();
        }
    }
    private void setFont()
    {
        setRegular();
    }

    public void setRegular()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Regular.ttf");
        setTypeface(tf);
    }

    public void setBold()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Bold.ttf");
        setTypeface(tf);
    }

    public void setItalic()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Italic.ttf");
        setTypeface(tf);
    }

    public void setLight()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Light.ttf");
        setTypeface(tf);
    }

    public void setMedium()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Medium.ttf");
        setTypeface(tf);
    }

    public void setSemibold()
    {
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "fonts/Lato-Semibold.ttf");
        setTypeface(tf);
    }
}
