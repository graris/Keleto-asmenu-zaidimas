package com.example.dom.numbersboard;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Dom on 2017.02.26.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);

    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
