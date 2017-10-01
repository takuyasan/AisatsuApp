package jp.techacademy.takuya.hatakeyama2.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void onClick(View view) {
        getGreetingOnTime();
    }

    private void getGreetingOnTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                if (hourOfDay >= 2 && hourOfDay <= 9 && minute < 60) {
                    mTextView.setText(R.string.GoodMorning);
                } else if (hourOfDay >= 10 && hourOfDay <= 17 && minute < 60) {
                    mTextView.setText(R.string.GoodAfternoon);
                } else {
                    mTextView.setText(R.string.GoodEvening);
                }
            }
        }, 0, 0, true);

        timePickerDialog.show();
    }
}
