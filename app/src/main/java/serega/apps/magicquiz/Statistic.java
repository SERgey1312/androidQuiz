package serega.apps.magicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Statistic extends AppCompatActivity {

    TextView forRec1;
    DBHelper dbHelper;
    ArrayList<Record> allRec;
    Record someRec;
    String recStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic_layout);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        forRec1 = findViewById(R.id.forRecords1);
        dbHelper = new DBHelper(this);
        allRec = dbHelper.getRecordList("hard");
        if(allRec.size() == 0){
            someRec = new Record("SAMOPIS", "nature", "hard", 100);
        } else {
            someRec = allRec.get(0);
        }
        recStr = someRec.getUsername() + " - " + someRec.getCountTrueAnswers()+ " - " + someRec.getCategory();
        forRec1.setText(recStr);
    }

    //system btn back
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Statistic.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    //system btn back (end)
}
