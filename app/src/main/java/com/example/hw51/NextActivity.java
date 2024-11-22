package com.example.hw51;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class NextActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        TextView resultTextView;
        setContentView(R.layout.activity_next);
        resultTextView = findViewById(R.id.text_View);
        RangeSlider rangeSlider = findViewById(R.id.rangeSlider);

        rangeSlider.setValues(0f, 100f);
        double result = getIntent().getDoubleExtra("result", 0);
        resultTextView.setText("Результат: " + result);


        rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            List<Float> values = slider.getValues();
            System.out.println("Current values: " + values);

        });
    }
}
