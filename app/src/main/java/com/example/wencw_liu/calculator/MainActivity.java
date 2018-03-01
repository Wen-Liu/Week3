package com.example.wencw_liu.calculator;

import android.graphics.Color;
import android.graphics.DrawFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton imageButton_0 = findViewById(R.id.imageButton_0);
        ImageButton imageButton_1 = findViewById(R.id.imageButton_1);
        ImageButton imageButton_2 = findViewById(R.id.imageButton_2);
        ImageButton imageButton_3 = findViewById(R.id.imageButton_3);
        ImageButton imageButton_4 = findViewById(R.id.imageButton_4);
        ImageButton imageButton_5 = findViewById(R.id.imageButton_5);
        ImageButton imageButton_6 = findViewById(R.id.imageButton_6);
        ImageButton imageButton_7 = findViewById(R.id.imageButton_7);
        ImageButton imageButton_8 = findViewById(R.id.imageButton_8);
        ImageButton imageButton_9 = findViewById(R.id.imageButton_9);
        ImageButton imageButton_changeSign = findViewById(R.id.imageButton_changesign);
        ImageButton imageButton_divide = findViewById(R.id.imageButton_divide);
        ImageButton imageButton_equals = findViewById(R.id.imageButton_equals);
        ImageButton imageButton_minus = findViewById(R.id.imageButton_minus);
        ImageButton imageButton_percent = findViewById(R.id.imageButton_percent);
        ImageButton imageButton_plus =findViewById(R.id.imageButton_plus);
        ImageButton imageButton_point = findViewById(R.id.imageButton_point);
        ImageButton imageButton_reset = findViewById(R.id.imageButton_reset);
        ImageButton imageButton_times = findViewById(R.id.imageButton_times);

        btnChange(imageButton_0, R.drawable.calculator_0_hover, R.drawable.calculator_0);
        btnChange(imageButton_1, R.drawable.calculator_1_hover, R.drawable.calculator_1);
        btnChange(imageButton_2, R.drawable.calculator_2_hover, R.drawable.calculator_2);
        btnChange(imageButton_3, R.drawable.calculator_3_hover, R.drawable.calculator_3);
        btnChange(imageButton_4, R.drawable.calculator_4_hover, R.drawable.calculator_4);
        btnChange(imageButton_5, R.drawable.calculator_5_hover, R.drawable.calculator_5);
        btnChange(imageButton_6, R.drawable.calculator_6_hover, R.drawable.calculator_6);
        btnChange(imageButton_7, R.drawable.calculator_7_hover, R.drawable.calculator_7);
        btnChange(imageButton_8, R.drawable.calculator_8_hover, R.drawable.calculator_8);
        btnChange(imageButton_9, R.drawable.calculator_9_hover, R.drawable.calculator_9);
        btnChange(imageButton_changeSign, R.drawable.calculator_changesign_hover, R.drawable.calculator_changesign);
        btnChange(imageButton_divide, R.drawable.calculator_divide_hover, R.drawable.calculator_divide);
        btnChange(imageButton_equals, R.drawable.calculator_equals_hover, R.drawable.calculator_equals);
        btnChange(imageButton_minus, R.drawable.calculator_minus_hover, R.drawable.calculator_minus);
        btnChange(imageButton_percent, R.drawable.calculator_percent_hover, R.drawable.calculator_percent);
        btnChange(imageButton_plus, R.drawable.calculator_plus_hover, R.drawable.calculator_plus);
        btnChange(imageButton_point, R.drawable.calculator_point_hover, R.drawable.calculator_point);
        btnChange(imageButton_reset, R.drawable.calculator_reset_hover, R.drawable.calculator_reset);
        btnChange(imageButton_times, R.drawable.calculator_times_hover, R.drawable.calculator_times);

    }


    private void btnChange(final ImageButton button, final int actionDown, final int actionUp) {
            button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                        //按下的時候改變圖
                        button.setImageResource(actionDown);
                    }
                    if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                        //起來的時候恢復圖
                        view.performClick();
                        button.setImageResource(actionUp);
                    }
                    return false;
                }
            });
        }



}
