package com.zerdasoftware.flagquiz.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zerdasoftware.flagquiz.R;

public class ResultScreenActivity extends AppCompatActivity {

    private TextView ResultTextView;
    private TextView SuccessTextView;
    private Button TryAgainButton;

    private int CorrectCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        ResultTextView = findViewById(R.id.ResultTextView);
        SuccessTextView = findViewById(R.id.SuccessTextView);

        CorrectCount = getIntent().getIntExtra("CorrectCount",0);

        ResultTextView.setText(CorrectCount+" CORRECT - "+(5-CorrectCount)+" WRONG");
        SuccessTextView.setText("% "+(CorrectCount*100/5)+" SUCCESS");

        TryAgainButton = findViewById(R.id.TryAgainButton);

        TryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultScreenActivity.this, QuizScreenActivity.class));
                finish();
            }
        });

    }
}