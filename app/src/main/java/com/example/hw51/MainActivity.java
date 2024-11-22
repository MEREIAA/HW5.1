package com.example.hw51;

import static com.example.hw51.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.example.hw51.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Double first, second, result;
    private String currentOperation;
    private Boolean isOperationOnClick;
    private Button hiddenButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        textView = findViewById(id.text_View);
        hiddenButton = findViewById(R.id.btn_hidden);
        hiddenButton.setVisibility(View.GONE);
        currentOperation = "";
    }

    public void onNumberClick(View view) {
        String textButton = ((MaterialButton) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = null;
            second = null;
            result = null;
            currentOperation = "";
        } else if (textButton.equals(".")) {
            if (!textView.getText().toString().contains(".")) {
                if (textView.getText().toString().equals("0") || isOperationOnClick) {
                    textView.setText("0.");
                } else {
                    textView.append(".");
                }
            }
        } else if (textView.getText().toString().equals("0") || isOperationOnClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationOnClick = false;
        hiddenButton.setVisibility(View.GONE);
    }

    @SuppressLint("SetTextI18n")
    public void onOperationClick(View view) {
        isOperationOnClick = true;
        if (view.getId() == R.id.btn_plus) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "-";
        } else if (view.getId() == R.id.btn_multiply) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "*";
        } else if (view.getId() == R.id.btn_divide) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "/";
        } else if (view.getId() == R.id.btn_equal) {
            second = Double.valueOf(textView.getText().toString());
            if (currentOperation.equals("+")) {
                result = first + second;
            } else if (currentOperation.equals("-")) {
                result = first - second;
            } else if (currentOperation.equals("*")) {
                result = first * second;
            } else if (currentOperation.equals("/")) {
                result = first / second;
            } else if (currentOperation.equals("%")) {
                result = first / 100;
            }
            if (result % 1 == 0) {
                textView.setText(String.valueOf(result.intValue()));
            } else textView.setText(result.toString());
            hiddenButton.setVisibility(View.VISIBLE);
            first = null;
            second = null;
            currentOperation = "";

        } else if (view.getId() == R.id.btn_percent) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = "%";
        } else if (view.getId() == R.id.btn_plus_minus) {
            Snackbar.make(view, "ЧТО ОН ДОЛЖЕН ДЕЛАТЬ ? ", Snackbar.LENGTH_LONG).show();
        }
    }

    public void onHiddenButtonClick(View view) {
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}