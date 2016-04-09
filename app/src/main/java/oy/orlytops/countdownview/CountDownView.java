package oy.orlytops.countdownview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Orlando Yanson Jr on 4/9/2016.
 */
public class CountDownView extends ViewGroup {

    private LayoutInflater layoutInflater;

    public CountDownView(Context context) {
        super(context);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(new CircleCountDown(getContext()));
        addView(new CircleCountDown(getContext()));
    }
}
