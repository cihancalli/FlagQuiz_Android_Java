package com.zerdasoftware.flagquiz.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zerdasoftware.flagquiz.Models.Database;
import com.zerdasoftware.flagquiz.Models.FlagDAO;
import com.zerdasoftware.flagquiz.Models.FlagModel;
import com.zerdasoftware.flagquiz.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuizScreenActivity extends AppCompatActivity {

    private TextView CorrectTextView;
    private TextView WrongTextView;
    private TextView QuestionTextView;

    private ImageView FlagImageView;

    private Button button_A;
    private Button button_B;
    private Button button_C;
    private Button button_D;

    private ArrayList<FlagModel> Questions;
    private ArrayList<FlagModel> WrongOptions;
    private FlagModel CorrectQuestion;
    private Database db;
    private int QuestionCount = 0;
    private int CorrectCount = 0;
    private int WrongCount = 0;
    private ArrayList<FlagModel> Options = new ArrayList<>();
    private HashSet<FlagModel> MixOptionsList = new HashSet<>( );


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

        db = new Database(this);
        Questions = new FlagDAO().getRandom5(db);
        loadQuestion();


        button_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorrectControl(button_A);
                QuestionCountControl();
            }
        });

        button_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorrectControl(button_B);
                QuestionCountControl();
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorrectControl(button_C);
                QuestionCountControl();
            }
        });

        button_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CorrectControl(button_D);
                QuestionCountControl();
            }
        });

    }

    public void loadQuestion() {
        QuestionTextView.setText((QuestionCount+1)+". Flag Question");
        CorrectTextView.setText("Correct: "+(CorrectCount));
        WrongTextView.setText("Wrong: "+(WrongCount));

        CorrectQuestion = Questions.get(QuestionCount);
        WrongOptions = new FlagDAO().getRandom3Wrong(db,CorrectQuestion.getFlag_id());

        FlagImageView.setImageResource(getResources().getIdentifier(CorrectQuestion.getFlag_image(),"drawable",getPackageName()));
        MixOptionsList.clear();
        MixOptionsList.add(CorrectQuestion);
        MixOptionsList.add(WrongOptions.get(0));
        MixOptionsList.add(WrongOptions.get(1));
        MixOptionsList.add(WrongOptions.get(2));

        Options.clear();
        for (FlagModel f: MixOptionsList ){
            Options.add(f);
        }
        button_A.setText(Options.get(0).getFlag_name());
        button_B.setText(Options.get(1).getFlag_name());
        button_C.setText(Options.get(2).getFlag_name());
        button_D.setText(Options.get(3).getFlag_name());
    }
    public void CorrectControl (Button button){
        String ButtonText = button.getText().toString();
        String CorrectAnswer = CorrectQuestion.getFlag_name();

        if (ButtonText.equals(CorrectAnswer)){
            CorrectCount ++;
        }else {
            WrongCount ++;
        }
        CorrectTextView.setText("Correct: "+(CorrectCount));
        WrongTextView.setText("Wrong: "+(WrongCount));

    }

    public void QuestionCountControl (){
        QuestionCount ++;
        if (QuestionCount != 5){
            loadQuestion();
        }else {
            Intent intent = new Intent(QuizScreenActivity.this, ResultScreenActivity.class);
            intent.putExtra("CorrectCount",CorrectCount);
            startActivity(intent);
            finish();
        }
    }
}