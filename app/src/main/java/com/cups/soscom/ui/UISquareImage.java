package com.cups.soscom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ekobudiarto on 7/12/16.
 */
public class UISquareImage extends ImageView {

    public UISquareImage(Context context) {
        super(context);
    }

    public UISquareImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UISquareImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);

    }
}