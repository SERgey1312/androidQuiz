package serega.apps.magicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameEnd  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_layout);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView resalt = findViewById(R.id.result);
        resalt.setText(getIntent().getExtras().getInt("result") + " / " + getIntent().getExtras().getInt("level"));

        Button BtnToStart = findViewById(R.id.toStart);
        BtnToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameEnd.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });

        Button BtnStatistic = findViewById(R.id.statistic);
        BtnStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameEnd.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
    }
    //system btn back
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(GameEnd.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    //system btn back (end)
}
