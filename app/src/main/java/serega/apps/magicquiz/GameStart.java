package serega.apps.magicquiz;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameStart extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    ArrayList<Question> allQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startquiz_final);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView questionFromDb = findViewById(R.id.questionFromDb);

        Button ans1 = findViewById(R.id.a1);
        Button ans2 = findViewById(R.id.a2);
        Button ans3 = findViewById(R.id.a3);
        Button ans4 = findViewById(R.id.a4);

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String theme = getIntent().getExtras().getString("theme");
        int questionCount = getIntent().getExtras().getInt("level");

        allQuestions = getQuestions(questionCount, dbHelper.getQuestionList(theme));
        questionFromDb.setText(allQuestions.get(0).getQuestion());
            ans1.setText(allQuestions.get(0).getAns1());
            ans2.setText(allQuestions.get(0).getAns2());
            ans3.setText(allQuestions.get(0).getAns3());
            ans4.setText(allQuestions.get(0).getAns4());

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

    }


    public ArrayList<Question> getQuestions(int count, ArrayList<Question> list){
        ArrayList<Question> listnew = new ArrayList<>();
        for (int i = 0; i < count; i++){
            listnew.add(list.get(i));
        }
        return listnew;
    }
}
