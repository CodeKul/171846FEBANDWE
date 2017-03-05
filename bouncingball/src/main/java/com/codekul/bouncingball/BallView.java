package com.codekul.bouncingball;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        ballMover()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext( integers -> invalidate())
                .doOnError( e -> Log.i("@codekul", e.toString()))
                .doOnComplete( () -> Log.i("@codekul", "Completed"))
                .subscribe();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(ball.x, ball.y, ball.rad, paint);
    }

    public Flowable<Integer[]> ballMover() {
        return Flowable.create(sub -> {
            while(true) {
                if(ball.x < 0) ball.dx = 5;
                if(ball.x >= getWidth()) ball.dx = -5;
                if(ball.y < 0) ball.dy = 5;
                if(ball.y >= getHeight()) ball.dy = -5;

                ball.x += ball.dx;
                ball.y += ball.dy;
                Thread.sleep(10);
                sub.onNext(new Integer[]{ball.x, ball.y});
            }
        }, BackpressureStrategy.BUFFER);
    }
}
