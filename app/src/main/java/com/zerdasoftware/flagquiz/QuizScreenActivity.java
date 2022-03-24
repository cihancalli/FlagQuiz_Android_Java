package com.zerdasoftware.flagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizScreenActivity extends AppCompatActivity {

    private TextView CorrectTextView;
    private TextView WrongTextView;
    private TextView QuestionTextView;

    private ImageView FlagImageView;

    private Button button_A;
    private Button button_B;
    private Button button_C;
    private Button button_D;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);

        CorrectTextView = findViewById(R.id.CorrectTextView);
        WrongTextView = findViewById(R.id.WrongTextView);
        QuestionTextView = findViewById(R.id.QuestionTextView);

        FlagImageView = findViewById(R.id.FlagImageView);

        button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);

        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizScreenActivity.this,ResultScreenActivity.class));
                finish();
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}