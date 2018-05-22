package com.example.raokui.testcoupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class CouponView extends RelativeLayout {
    public CouponView(Context context) {
        super(context);
        inits();
    }

    public CouponView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inits();
    }

    public CouponView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits();
    }

    private void inits() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(getResources().getColor(R.color.blue));
        setWillNotDraw(false);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {

        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
//        if (mode == )
        int height = 0;
        int width = getMeasuredWidth();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
                height += child.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

            }
        }
        height += l;

        setMeasuredDimension(width, height);

    }

    int l = 25;
    Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int wid = getMeasuredWidth();
        int hei = getMeasuredHeight() - l;

        Path path = new Path();
        path.lineTo(0, hei);
        path.lineTo(l, hei + l);
        path.lineTo(wid - l, hei + l);
        path.lineTo(wid, hei);
        path.lineTo(wid, 0);
        path.close();

        canvas.drawPath(path, mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(R.color.dark));
        path.moveTo(0, 0);
        path.lineTo(0, hei);
        path.lineTo(l, hei + l);
//        int hlineW = wid - l * 2;
//        int hlineH = hei + l;
//        int w1 = l;
//        for (int i = 0; i < 20; i++) {
//            path.lineTo(w1 + hlineW / 40, hlineH);
//            w1 += hlineW / 20;
//
//            path.moveTo(w1, hlineH);
//        }
        path.lineTo(wid - l, hei + l);
//        path.lineTo(wid - l, hei + l);
        path.lineTo(wid, hei);
        path.lineTo(wid, 0);
        path.close();


        int dashLineH2 = getMeasuredHeight();
        int dashLineW2 = getMeasuredWidth() / 3;
        path.moveTo(dashLineW2, 0);
        int h2 = 0;
        for (int i = 0; i < 10; i++) {
            path.lineTo(dashLineW2, h2 + dashLineH2 / 20);
            h2 += dashLineH2 / 10;
            path.moveTo(dashLineW2, h2);
        }
        canvas.drawPath(path, mPaint);
        mPaint.setColor(getResources().getColor(R.color.blue));
        for (int i = 0; i < 40; i++) {
            if (i == 0) {
                continue;
            }
            canvas.drawPoint((wid - l) / 40 * i, hei + l, mPaint);
        }


//        canvas.drawLine(0, 0, 0, hei, mPaint);
//        canvas.drawLine(0, hei, 50, hei + 50, mPaint);
//        canvas.drawLine(50, hei + 50, wid - 50, hei + 50, mPaint);
//        canvas.drawLine(wid - 50, hei + 50, wid, hei, mPaint);
//        canvas.drawLine(wid, hei, wid, 0, mPaint);
//        canvas.drawLine(wid, 0, 0, 0, mPaint);
    }


}
