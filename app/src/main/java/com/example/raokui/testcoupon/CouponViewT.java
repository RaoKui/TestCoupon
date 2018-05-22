package com.example.raokui.testcoupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CouponViewT extends RelativeLayout {

    private TextView tv4;

    public CouponViewT(Context context) {
        super(context);
        inits(context);
    }


    public CouponViewT(Context context, AttributeSet attrs) {
        super(context, attrs);
        inits(context);
    }

    public CouponViewT(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits(context);
    }

    private Paint mPaint;

    private void inits(Context context) {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(getResources().getColor(R.color.blue));
        setWillNotDraw(false);

        View view = LayoutInflater.from(context).inflate(R.layout.coupon_view, this);
        tv4 = view.findViewById(R.id.tv4);
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEx) {
                    tv4.setVisibility(GONE);
                } else {
                    tv4.setVisibility(VISIBLE);
                }
                isEx = !isEx;
                invalidate();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
                height += params.topMargin + child.getMeasuredHeight() + params.bottomMargin;
            }
        }
        if (!isEx) {
            tempHeight = height;
        }
        setMeasuredDimension(width, height);
    }

    private int tempHeight = 0;

    private int l = 25;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.blue));

        Path path = new Path();
        path.moveTo(l, 0);
        path.lineTo(0, l);
        path.lineTo(0, height);
        path.lineTo(width, height);
        path.lineTo(width, l);
        path.lineTo(width - l, 0);
        canvas.drawPath(path, mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(getResources().getColor(R.color.dark));
        path.moveTo(l, 0);
        path.lineTo(0, l);
        path.lineTo(0, height);
        path.lineTo(width, height);
        path.lineTo(width, l);
        path.lineTo(width - l, 0);
        canvas.drawPath(path, mPaint);

        if (isEx) {
            for (int i = 0; i < 40; i++) {
                if (i == 0) {
                    continue;
                }
                mPaint.setColor(getResources().getColor(R.color.dark));
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawPoint(width / 40 * i, tempHeight, mPaint);
            }

////            Rect rect = new Rect();
////            rect.set(0, height, width, height + 100);
//            canvas.drawRect(rect, mPaint);
        }
    }

    private boolean isEx = false;
    private String des = "详细说面";

    public void setEx(boolean ex) {
        isEx = ex;
        invalidate();
    }

    public boolean isEx() {
        return isEx;
    }

    public void setDes(String des) {
        this.des = des;
        invalidate();
    }
}
