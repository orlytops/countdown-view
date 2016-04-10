package oy.orlytops.countdownview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Orlando Yanson Jr on 4/9/2016.
 */
public class CircleCountDown extends View {

    private Rect absoluteRect = new Rect();
    private Paint background = new Paint();
    private Paint progress = new Paint();

    private Canvas canvas;
    private float timRemainingInMillis;


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
        this.canvas = canvas;

        getLocalVisibleRect(absoluteRect);

        background.setAntiAlias(true);
        background.setStyle(Paint.Style.STROKE);
        background.setStrokeWidth(60);
        background.setStrokeCap(Paint.Cap.ROUND);
        background.setColor(getResources().getColor(R.color.fore_ground));

        progress.setAntiAlias(true);
        progress.setStyle(Paint.Style.STROKE);
        progress.setStrokeWidth(30);
        progress.setStrokeCap(Paint.Cap.ROUND);
        progress.setColor(getResources().getColor(R.color.seconds));

        // draw background line
        canvas.drawArc(new RectF(absoluteRect.left + 50, absoluteRect.top + 50,
                absoluteRect.right - 50, absoluteRect.bottom - 50), 0, 360, false, background);

        int timeInSeconds = (int) timRemainingInMillis / 1000;
        int timeConsumed = 60 - timeInSeconds;
        int angle = (6 * timeConsumed);


        canvas.drawArc(new RectF(absoluteRect.left + 50, absoluteRect.top + 50,
                absoluteRect.right - 50, absoluteRect.bottom - 50), 270, angle, false, progress);

        Paint paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(100);
        paintText.setFakeBoldText(true);

        canvas.drawText(timeInSeconds + "", absoluteRect.centerX() - 40, absoluteRect.centerY() + 40, paintText);
    }


    public void setTimeRemainingInMillis(float timRemainingInMillis) {
        this.timRemainingInMillis = timRemainingInMillis;
        this.invalidate();
    }

}
