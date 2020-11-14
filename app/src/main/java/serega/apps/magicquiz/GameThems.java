package serega.apps.magicquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class GameThems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thems);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Button BtnNature = findViewById(R.id.nature);
        BtnNature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameThems.this, GameLevels.class);
                    intent.putExtra("id", "nature");
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        final  Button BtnTechnology = findViewById(R.id.technology);
        BtnTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameThems.this, GameLevels.class);
                    intent.putExtra("id", "technology");
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        final  Button BtnLiterature = findViewById(R.id.literature);
        BtnLiterature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameThems.this, GameLevels.class);
                    intent.putExtra("id", "literature");
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        final Button BtnHistory = findViewById(R.id.history);
        BtnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameThems.this, GameLevels.class);
                    intent.putExtra("id", "history");
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
            }
        });
        final Button BtnMath = findViewById(R.id.mathematics);
        BtnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameThems.this, GameLevels.class);
                    intent.putExtra("id", "mathematics");
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
        Intent intent = new Intent(GameThems.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    //system btn back (end)
}
