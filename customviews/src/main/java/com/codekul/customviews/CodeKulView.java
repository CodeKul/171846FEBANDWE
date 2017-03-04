package com.codekul.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

/**
 * Created by aniruddha on 4/3/17.
 */

public class CodeKulView extends EditText {

    private Paint paint;

    public CodeKulView(Context context) {
        super(context);

        // create view using code

        initPaint();
    }

    public CodeKulView(Context context, AttributeSet set) {
        super(context, set);

        // create view using xml
        setGravity(Gravity.TOP | Gravity.LEFT);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawCircle(20, 20, 30, paint);

        paint.setColor(Color.GREEN);
        for (int i = 1; i < 2000; i += 30)
            canvas.drawLine(0, 10 + i, 1000, 10 + i, paint);

        paint.setColor(Color.RED);
        canvas.drawLine(100, 10, 100, 2000, paint);
    }

   /* @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }*/
}
