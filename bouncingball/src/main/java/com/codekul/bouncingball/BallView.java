package com.codekul.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;

/**
 * Created by aniruddha on 5/3/17.
 */

public class BallView extends TextView {

    private Paint paint;

    private class Ball {
        int x = 5, y = 5;
        int rad = 40;
        int dx = 5, dy = 5 ;
    }

    private Ball ball;

    public BallView(Context context) {
        super(context);

        ball = new Ball();
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ball.x, ball.y, ball.rad, paint);
    }
}
