package com.cis470.lakiel.mypedometer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private final static int WALKINGPEAK = 18;
    private final static int JOGGINGPEAK = 25;
    private final static int RUNNINGPEAK = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void navigateToStepCounterActivity(View v) {
        Intent mIntent = new Intent(this, StepsCounterActivity.class);
        startActivity(mIntent);
    }

    public void navigateToStepHistoryActivity(View v) {
        Intent mIntent = new Intent(this, StepsHistoryActivity.class);
        startActivity(mIntent);
    }

    public void navigateToCustomAlgoActivity(View v) {
        EditText walkingPeak = (EditText) findViewById(R.id.edit_walking);
        EditText joggingPeak = (EditText) findViewById(R.id.edit_jogging);
        EditText runningPeak = (EditText) findViewById(R.id.edit_running);
        Intent mIntent = new Intent(this, CustomAlgoResultsActivity.class);

        int wValue;
        int jValue;
        int rValue;

        if (walkingPeak.getText().toString().isEmpty())
            wValue = WALKINGPEAK;
        else
            wValue = Integer.parseInt(walkingPeak.getText().toString());

        if (joggingPeak.getText().toString().isEmpty())
            jValue = JOGGINGPEAK;
        else
            jValue = Integer.parseInt(joggingPeak.getText().toString());
        if (runningPeak.getText().toString().isEmpty())
            rValue = RUNNINGPEAK;
        else
            rValue = Integer.parseInt(runningPeak.getText().toString());

        mIntent.putExtra("wPeak", wValue);
        mIntent.putExtra("jPeak", jValue);
        mIntent.putExtra("rPeak", rValue);
        startActivity(mIntent);
    }

}

