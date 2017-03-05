package com.codekul.viewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRotate).setOnClickListener(v -> animate(R.anim.rotate));
        findViewById(R.id.btnZoom).setOnClickListener(v -> animate(R.anim.zoom));
        findViewById(R.id.btnMixed).setOnClickListener(v -> animate(R.anim.mixed));
    }

    private void animate(int res) {
        Animation animation = AnimationUtils.loadAnimation(this, res);
        findViewById(R.id.imageView).startAnimation(animation);
    }
}
