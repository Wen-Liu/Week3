package com.example.wencw_liu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton_0;
    private ImageButton imageButton_1;
    private ImageButton imageButton_2;
    private ImageButton imageButton_3;
    private ImageButton imageButton_4;
    private ImageButton imageButton_5;
    private ImageButton imageButton_6;
    private ImageButton imageButton_7;
    private ImageButton imageButton_8;
    private ImageButton imageButton_9;
    private ImageButton imageButton_changeSign;
    private ImageButton imageButton_divide;
    private ImageButton imageButton_equals;
    private ImageButton imageButton_minus;
    private ImageButton imageButton_percent;
    private ImageButton imageButton_plus;
    private ImageButton imageButton_point;
    private ImageButton imageButton_reset;
    private ImageButton imageButton_times;
    private TextView textView1;
    private TextView textView2;
    private String stringSave = "";
    private ArrayList<String> formula = new ArrayList();
    private double lastNum = 0;
    private double answer = 0;
    private double roundNum = 100000000;
    //private boolean continueOperator = false;
    //private char lastOperate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton_0 = findViewById(R.id.imageButton_0);
        imageButton_1 = findViewById(R.id.imageButton_1);
        imageButton_2 = findViewById(R.id.imageButton_2);
        imageButton_3 = findViewById(R.id.imageButton_3);
        imageButton_4 = findViewById(R.id.imageButton_4);
        imageButton_5 = findViewById(R.id.imageButton_5);
        imageButton_6 = findViewById(R.id.imageButton_6);
        imageButton_7 = findViewById(R.id.imageButton_7);
        imageButton_8 = findViewById(R.id.imageButton_8);
        imageButton_9 = findViewById(R.id.imageButton_9);
        imageButton_changeSign = findViewById(R.id.imageButton_changesign);
        imageButton_divide = findViewById(R.id.imageButton_divide);
        imageButton_equals = findViewById(R.id.imageButton_equals);
        imageButton_minus = findViewById(R.id.imageButton_minus);
        imageButton_percent = findViewById(R.id.imageButton_percent);
        imageButton_plus = findViewById(R.id.imageButton_plus);
        imageButton_point = findViewById(R.id.imageButton_point);
        imageButton_reset = findViewById(R.id.imageButton_reset);
        imageButton_times = findViewById(R.id.imageButton_times);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        imageButton_0.setOnClickListener(listener);
        imageButton_1.setOnClickListener(listener);
        imageButton_2.setOnClickListener(listener);
        imageButton_3.setOnClickListener(listener);
        imageButton_4.setOnClickListener(listener);
        imageButton_5.setOnClickListener(listener);
        imageButton_6.setOnClickListener(listener);
        imageButton_7.setOnClickListener(listener);
        imageButton_8.setOnClickListener(listener);
        imageButton_9.setOnClickListener(listener);
        imageButton_changeSign.setOnClickListener(listener);
        imageButton_divide.setOnClickListener(listener);
        imageButton_equals.setOnClickListener(listener);
        imageButton_minus.setOnClickListener(listener);
        imageButton_percent.setOnClickListener(listener);
        imageButton_plus.setOnClickListener(listener);
        imageButton_point.setOnClickListener(listener);
        imageButton_reset.setOnClickListener(listener);
        imageButton_times.setOnClickListener(listener);


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


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton_plus:
                    if (stringSave.equals("") && formula.size() > 0) {
                        String lastOfFormula = formula.get(formula.size() - 1);
                        switch (lastOfFormula) {
                            case "+":
                                break;
                            case "-":
                                break;
                            case "*":
                                formula.set(formula.size() - 1, "+");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "+");
                                break;
                            case "/":
                                formula.set(formula.size() - 1, "+");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "+");
                                break;
                            default:
                                formula.add("+");
                                textView1.setText(textView1.getText().toString() + "+");
                                break;
                        }
                    } else if (stringSave != "") {
                        formula.add(stringSave);
                        stringSave = "";
                        formula.add("+");
                        textView1.setText(textView1.getText().toString() + "+");
                    }
                    break;


                case R.id.imageButton_minus:
                    if (stringSave.equals("") && formula.size() > 0) {
                        String lastOfFormula = formula.get(formula.size() - 1);
                        switch (lastOfFormula) {
                            case "-":
                                if (formula.get(formula.size() - 2).equals("-")) {
                                    break;
                                } else {
                                    formula.add("-");
                                    textView1.setText(textView1.getText().toString() + "-");
                                    break;
                                }
                            default:
                                formula.add("-");
                                textView1.setText(textView1.getText().toString() + "-");
                                break;
                        }
                    } else if (stringSave != "") {
                        formula.add(stringSave);
                        stringSave = "";
                        formula.add("-");
                        textView1.setText(textView1.getText().toString() + "-");
                    }
                    break;


                case R.id.imageButton_times:
                    if (stringSave.equals("") && formula.size() > 0) {
                        String lastOfFormula = formula.get(formula.size() - 1);
                        switch (lastOfFormula) {
                            case "+":
                                formula.set(formula.size() - 1, "*");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "*");
                                break;
                            case "-":
                                formula.set(formula.size() - 1, "*");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "*");
                                break;
                            case "*":
                                break;
                            case "/":
                                formula.set(formula.size() - 1, "*");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "*");
                                break;
                            default:
                                formula.add("*");
                                textView1.setText(textView1.getText().toString() + "*");
                                break;
                        }
                    } else if (stringSave != "") {
                        formula.add(stringSave);
                        stringSave = "";
                        formula.add("*");
                        textView1.setText(textView1.getText().toString() + "*");
                    }
                    break;


                case R.id.imageButton_divide:
                    if (stringSave.equals("") && formula.size() > 0) {
                        String lastOfFormula = formula.get(formula.size() - 1);
                        switch (lastOfFormula) {
                            case "+":
                                formula.set(formula.size() - 1, "/");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "/");
                                break;
                            case "-":
                                formula.set(formula.size() - 1, "/");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "/");
                                break;
                            case "*":
                                formula.set(formula.size() - 1, "/");
                                textView1.setText(textView1.getText().toString().substring(0, textView1.getText().toString().length() - 1) + "/");
                                break;
                            case "/":
                                break;
                            default:
                                formula.add("/");
                                textView1.setText(textView1.getText().toString() + "/");
                                break;
                        }
                    } else if (stringSave != "") {
                        formula.add(stringSave);
                        stringSave = "";
                        formula.add("/");
                        textView1.setText(textView1.getText().toString() + "/");
                    }
                    break;


                case R.id.imageButton_equals:
                    if (stringSave.length() != 0) {
                        formula.add(stringSave);
                        stringSave = "";
                    }
                    if (formula.size() > 1 && formula.get(formula.size() - 1) != "+"
                            && formula.get(formula.size() - 1) != "-" && formula.get(formula.size() - 1) != "*"
                            && formula.get(formula.size() - 1) != "/") {
                        for (int i = 0; i < formula.size(); i++) {
                            if (formula.get(i).equals("-") &&
                                    (formula.get(i - 1).equals("+") || formula.get(i - 1).equals("-") ||
                                            formula.get(i - 1).equals("*") || formula.get(i - 1).equals("/"))) {
                                lastNum = (-1) * Double.parseDouble(formula.get(i + 1));
                                formula.set(i + 1, String.valueOf(lastNum));
                                formula.remove(i);
                            }
                        }

                        for (int i = 0; i < formula.size(); i++) {
                            switch (formula.get(i)) {
                                case "*":
                                    lastNum = Double.parseDouble(formula.get(i - 1)) * Double.parseDouble(formula.get(i + 1));
                                    formula.set(i - 1, String.valueOf(lastNum));
                                    formula.remove(i);
                                    formula.remove(i);
                                    i--;
                                    break;
                                case "/":
                                    lastNum = Double.parseDouble(formula.get(i - 1)) / Double.parseDouble(formula.get(i + 1));
                                    formula.set(i - 1, String.valueOf(lastNum));
                                    formula.remove(i);
                                    formula.remove(i);
                                    i--;
                                    break;
                                case "%":
                                    lastNum = Double.parseDouble(formula.get(i - 1)) * 0.01;
                                    formula.set(i - 1, String.valueOf(lastNum));
                                    formula.remove(i);
                                    i--;
                                    break;
                            }
                        }

                        for (int i = 0; i < formula.size(); i++) {
                            if (formula.get(i).equals("-")) {
                                lastNum = Double.parseDouble(formula.get(i - 1)) - Double.parseDouble(formula.get(i + 1));
                                formula.set(i - 1, String.valueOf(lastNum));
                                formula.remove(i);
                                formula.remove(i);
                                i--;
                            } else if (formula.get(i).equals("+")) {
                                lastNum = Double.parseDouble(formula.get(i - 1)) + Double.parseDouble(formula.get(i + 1));
                                formula.set(i - 1, String.valueOf(lastNum));
                                formula.remove(i);
                                formula.remove(i);
                                i--;
                            }
                        }
                    }
                    answer = Math.round(roundNum*Double.parseDouble(formula.get(0)))/roundNum;
                    textView2.setText(String.valueOf(answer));
                    break;


                case R.id.imageButton_percent:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("%");
                        stringSave = "%";
                    } else if (stringSave.length() != 0) {
                        formula.add(stringSave);
                        stringSave = "";
                        formula.add("%");
                        textView1.setText(textView1.getText().toString() + "%");
                    }
                    break;

                case R.id.imageButton_changesign:



                case R.id.imageButton_point:
                    if (stringSave.indexOf(".") == -1) {
                        if (stringSave.length() == 0) {
                            textView1.setText(textView1.getText().toString() + "0.");
                            stringSave += "0.";
                        } else {
                            textView1.setText(textView1.getText().toString() + ".");
                            stringSave += ".";
                        }
                    }
                    break;

                case R.id.imageButton_0:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("0");
                        stringSave = "0";
                    } else {
                        textView1.setText(textView1.getText().toString() + "0");
                        stringSave += "0";
                    }
                    break;

                case R.id.imageButton_1:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("1");
                        stringSave = "1";
                    } else {
                        textView1.setText(textView1.getText().toString() + "1");
                        stringSave += "1";
                    }
                    break;

                case R.id.imageButton_2:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("2");
                        stringSave = "2";
                    } else {
                        textView1.setText(textView1.getText().toString() + "2");
                        stringSave += "2";
                    }
                    break;

                case R.id.imageButton_3:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("3");
                        stringSave = "3";
                    } else {
                        textView1.setText(textView1.getText().toString() + "3");
                        stringSave += "3";
                    }
                    break;

                case R.id.imageButton_4:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("4");
                        stringSave = "4";
                    } else {
                        textView1.setText(textView1.getText().toString() + "4");
                        stringSave += "4";
                    }
                    break;

                case R.id.imageButton_5:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("5");
                        stringSave = "5";
                    } else {
                        textView1.setText(textView1.getText().toString() + "5");
                        stringSave += "5";
                    }
                    break;

                case R.id.imageButton_6:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("6");
                        stringSave = "6";
                    } else {
                        textView1.setText(textView1.getText().toString() + "6");
                        stringSave += "6";
                    }
                    break;

                case R.id.imageButton_7:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("7");
                        stringSave = "7";
                    } else {
                        textView1.setText(textView1.getText().toString() + "7");
                        stringSave += "7";
                    }
                    break;

                case R.id.imageButton_8:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText("8");
                        stringSave = "8";
                    } else {
                        textView1.setText(textView1.getText().toString() + "8");
                        stringSave += "8";
                    }
                    break;

                case R.id.imageButton_9:
                    if (textView1.getText().toString().equals("0")) {
                        textView1.setText(stringSave);
                        stringSave = "9";
                    } else {
                        textView1.setText(textView1.getText().toString() + "9");
                        stringSave += "9";
                    }
                    break;

                case R.id.imageButton_reset:
                    textView1.setText("");
                    textView2.setText("");
                    stringSave = "";
                    answer = 0;
                    lastNum = 0;
                    formula.clear();
                    break;

                default:
                    break;
            }
        }
    };

    /*private void operatorCalculate() {
        if (continueOperator) {
            answer = 0;
            switch (lastOperate) {
                case '+':
                    answer = lastNum + Double.parseDouble(stringSave);
                    break;
                case '-':
                    answer = lastNum - Double.parseDouble(stringSave);
                    break;
                case '*':
                    answer = lastNum * Double.parseDouble(stringSave);
                    break;
                case '/':
                    answer = lastNum / Double.parseDouble(stringSave);
                    break;
                case '=':
                    answer = lastNum;
                    break;
                default:
                    answer = Double.parseDouble(stringSave);
                    break;
            }
        } else {
            continueOperator = true;
            answer = Double.parseDouble(stringSave);
        }
        lastNum = Math.round(roundNum * answer) / roundNum;
        stringSave = "0";
        textView2.setText(String.valueOf(lastNum));
    }*/

    private void btnChange(final ImageButton button, final int actionDown, final int actionUp) {
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent Event) {
                if (Event.getAction() == MotionEvent.ACTION_DOWN) {
                    //按下的時候改變圖
                    button.setImageResource(actionDown);
                }
                if (Event.getAction() == MotionEvent.ACTION_UP) {
                    //起來的時候恢復圖
                    button.setImageResource(actionUp);
                }
                return false;
            }
        });
    }
}
