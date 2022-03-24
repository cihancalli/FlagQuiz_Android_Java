package com.zerdasoftware.flagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultScreenActivity extends AppCompatActivity {

    private TextView ResultTextView;
    private TextView SuccessTextView;
    private Button TryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        ResultTextView = findViewById(R.id.ResultTextView);
        SuccessTextView = findViewById(R.id.SuccessTextView);

        TryAgainButton = findViewById(R.id.TryAgainButton);

        TryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultScreenActivity.this,QuizScreenActivity.class));
                finish();
            }
        });

    }
}