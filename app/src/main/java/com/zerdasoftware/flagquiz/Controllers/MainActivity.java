package com.zerdasoftware.flagquiz.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zerdasoftware.flagquiz.Models.DatabaseCopyHelper;
import com.zerdasoftware.flagquiz.R;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button StartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseCopy();

        StartButton = findViewById(R.id.StartButton);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizScreenActivity.class));
                //finish();
            }
        });
    }

    public  void databaseCopy() {
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);

        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}