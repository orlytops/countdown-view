package oy.orlytops.countdownview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Orlando Yanson Jr on 4/9/2016.
 */
public class CircleCountDown extends View {

    private Rect absoluteRect = new Rect();

    private LayoutInflater layoutInflater;

    public CircleCountDown(Context context) {
        super(context);
    }

    public CircleCountDown(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleCountDown(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        getLocalVisibleRect(absoluteRect);

        Paint paintBackground = new Paint();
        paintBackground.setAntiAlias(true);
        paintBackground.setStyle(Paint.Style.STROKE);
        paintBackground.setStrokeWidth(60);
        paintBackground.setStrokeCap(Paint.Cap.ROUND);
        paintBackground.setColor(Color.BLUE);

        Paint mPaintProgress = new Paint();
        mPaintProgress.setAntiAlias(true);
        mPaintProgress.setStyle(Paint.Style.STROKE);
        mPaintProgress.setStrokeWidth(30);
        mPaintProgress.setStrokeCap(Paint.Cap.ROUND);
        mPaintProgress.setColor(Color.WHITE);

        // draw background line
        canvas.drawArc(new RectF(absoluteRect.left + 50, absoluteRect.top + 50, absoluteRect.right - 50, absoluteRect.bottom - 50), 0, 360, false, paintBackground);
        // draw progress line
        canvas.drawArc(new RectF(absoluteRect.left + 30, absoluteRect.top + 30, absoluteRect.right - 30, absoluteRect.bottom - 30), 270, 180, false, mPaintProgress);

    }

    private Path drawCurve(Canvas canvas, Paint paint, PointF mPointa, PointF mPointb) {

        Path myPath = new Path();
        myPath.moveTo(63 * absoluteRect.width() / 64, absoluteRect.height() / 10);
        myPath.quadTo(mPointa.x, mPointa.y, mPointb.x, mPointb.y);
        return myPath;
    }
}
