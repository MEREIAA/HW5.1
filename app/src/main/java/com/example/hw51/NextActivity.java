package com.example.hw51;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class NextActivity extends AppCompatActivity {
    private boolean isHeartPressed = false;
    private boolean isCategoryPressed = false;


    @SuppressLint({"MissingInflatedId", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        TextView resultTextView;
        setContentView(R.layout.activity_next);
        resultTextView = findViewById(R.id.result_Text_View);
        RangeSlider rangeSlider = findViewById(R.id.range_seek_bar);
        ImageView heartImageView = findViewById(R.id.heartImageView);

        heartImageView.setOnClickListener(v -> {
            if (isHeartPressed) {
                heartImageView.setImageResource(R.drawable.heart);
            } else {
                heartImageView.setImageResource(R.drawable.heartpressed);
            }
            isHeartPressed = !isHeartPressed;
        });


        Spinner spinner = findViewById(R.id.dropdown_menu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice_color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        rangeSlider.setValues(0f, 100f);
        double result = getIntent().getDoubleExtra("result", 0);
        resultTextView.setText("Результат: " + result);


        rangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            List<Float> values = slider.getValues();
            System.out.println("Current values: " + values);
        });



        TextView buttonCategory = findViewById(R.id.button_category);
        buttonCategory.setOnClickListener(v -> {
            if (isCategoryPressed) {
                heartImageView.setImageResource(R.drawable.heart);
                buttonCategory.setBackgroundResource(R.drawable.bg_button2);
            } else {
                heartImageView.setImageResource(R.drawable.heartpressed);
                buttonCategory.setBackgroundResource(R.drawable.bg_button3);
            }
            isCategoryPressed = !isCategoryPressed;
        });
        buttonCategory.setVisibility(View.VISIBLE);
    }
}