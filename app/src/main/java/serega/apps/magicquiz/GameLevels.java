package serega.apps.magicquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startquiz);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button BtnSimple = findViewById(R.id.simple);
        BtnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, GameStart.class);
                    intent.putExtra("theme", getIntent().getExtras().getString("id"));
                    intent.putExtra("level", 5);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        Button BtnMiddle = findViewById(R.id.middle);
        BtnMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, GameStart.class);
                    intent.putExtra("theme", getIntent().getExtras().getString("id"));
                    intent.putExtra("level", 10);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });

        Button BtnHard = findViewById(R.id.hard);
        BtnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, GameStart.class);
                    intent.putExtra("theme", getIntent().getExtras().getString("id"));
                    intent.putExtra("level", 15);
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
        Intent intent = new Intent(GameLevels.this, GameThems.class);
        startActivity(intent);
        finish();
    }
    //system btn back (end)
}