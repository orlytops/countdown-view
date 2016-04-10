package oy.orlytops.countdownview;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private CircleCountDown circleCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        startTimer();
    }

    private void initView() {
        circleCountDown = (CircleCountDown) findViewById(R.id.circle_countDown);
    }

    private void startTimer() {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                circleCountDown.setTimeRemainingInMillis(millisUntilFinished);
            }

            public void onFinish() {

            }

        }.start();

    }
}
