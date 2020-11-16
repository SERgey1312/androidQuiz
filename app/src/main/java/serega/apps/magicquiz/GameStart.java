package serega.apps.magicquiz;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameStart extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    ArrayList<Question> allQuestions;
    TextView questionFromDb;
    Button ans1;
    Button ans2;
    Button ans3;
    Button ans4;
    String textBtn;
    int counterTrue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startquiz_final);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String theme = getIntent().getExtras().getString("theme");
        int questionCount = getIntent().getExtras().getInt("level");

        allQuestions = getQuestions(questionCount, dbHelper.getQuestionList(theme));

        questionFromDb = findViewById(R.id.questionFromDb);
        ans1 = findViewById(R.id.a1);
        ans2 = findViewById(R.id.a2);
        ans3 = findViewById(R.id.a3);
        ans4 = findViewById(R.id.a4);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);

        nextQuestion(allQuestions);

    }
    //system btn back
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(GameStart.this, GameThems.class);
        startActivity(intent);
        finish();
    }
    //system btn back (end)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a1:
                textBtn = (String) ans1.getText();
                if(allQuestions.size() >= 1){
                    checkAnswer(allQuestions.get(0), textBtn);
                    allQuestions.remove(0);
                    setPause();
                }
                break;
            case R.id.a2:
                textBtn = (String) ans2.getText();
                if(allQuestions.size() >= 1){
                    checkAnswer(allQuestions.get(0), textBtn);
                    allQuestions.remove(0);
                    setPause();
                }
                v.setClickable(true);
                break;
            case R.id.a3:
                textBtn = (String) ans3.getText();
                if(allQuestions.size() >= 1){
                    checkAnswer(allQuestions.get(0), textBtn);
                    allQuestions.remove(0);
                    setPause();
                }

                break;
            case R.id.a4:
                textBtn = (String) ans4.getText();
                if(allQuestions.size() >= 1){
                    checkAnswer(allQuestions.get(0), textBtn);
                    allQuestions.remove(0);
                    setPause();
                }
                break;
        }
    }


    public ArrayList<Question> getQuestions(int count, ArrayList<Question> list){
        ArrayList<Question> listnew = new ArrayList<>();
        Integer[] listInt = new Integer[15];
        for (int i = 0 ; i < 15; i++){
            listInt[i] = i;
        }
        Collections.shuffle(Arrays.asList(listInt));
        for (int i = 0; i < count; i++){
            listnew.add(list.get(listInt[i]));
        }
        return listnew;
    }

    public void checkAnswer(Question question, String textBtn){
        System.out.println(textBtn + "YOUR ANSWER");
        System.out.println(question.getTrueAns() + "TRUE ANSWER");
        ans1.setClickable(false);
        ans2.setClickable(false);
        ans3.setClickable(false);
        ans4.setClickable(false);
        ans1.setEnabled(false);
        ans2.setEnabled(false);
        ans3.setEnabled(false);
        ans4.setEnabled(false);
        if ((question.getTrueAns()).equals(textBtn)){
            questionFromDb.setText("ВЕРНО!");
            ans1.setBackgroundColor(Color.parseColor(getString(R.string.color_green)));
            ans2.setBackgroundColor(Color.parseColor(getString(R.string.color_green)));
            ans3.setBackgroundColor(Color.parseColor(getString(R.string.color_green)));
            ans4.setBackgroundColor(Color.parseColor(getString(R.string.color_green)));
            counterTrue++;
        } else {
            questionFromDb.setText("ОШИБКА!");
            ans1.setBackgroundColor(Color.parseColor("#FF0000"));
            ans2.setBackgroundColor(Color.parseColor("#FF0000"));
            ans3.setBackgroundColor(Color.parseColor("#FF0000"));
            ans4.setBackgroundColor(Color.parseColor("#FF0000"));
        }

    }

    public void nextQuestion(ArrayList<Question> qList){
        if(qList.size() >=1){
            ans1.setBackgroundColor(Color.parseColor("#2ECCFA"));
            ans2.setBackgroundColor(Color.parseColor("#5858FA"));
            ans3.setBackgroundColor(Color.parseColor("#00FF80"));
            ans4.setBackgroundColor(Color.parseColor("#FE2EF7"));
            ans1.setClickable(true);
            ans2.setClickable(true);
            ans3.setClickable(true);
            ans4.setClickable(true);
            ans1.setEnabled(true);
            ans2.setEnabled(true);
            ans3.setEnabled(true);
            ans4.setEnabled(true);
            questionFromDb.setText(allQuestions.get(0).getQuestion());
            ans1.setText(allQuestions.get(0).getAns1());
            ans2.setText(allQuestions.get(0).getAns2());
            ans3.setText(allQuestions.get(0).getAns3());
            ans4.setText(allQuestions.get(0).getAns4());

        } else {
            Intent intent = new Intent(GameStart.this, GameEnd.class);
            intent.putExtra("result", counterTrue);
            startActivity(intent);
            finish();
        }
    }

    public void setPause(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextQuestion(allQuestions);
            }
        }, 2000);
    }
}
