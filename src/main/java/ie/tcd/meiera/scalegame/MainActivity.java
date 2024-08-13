package ie.tcd.meiera.scalegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivityExercise(View v ) {
        Intent intent = new Intent(this, Exercise.class);
        startActivity(intent);
    }

    public void playScale(View view){
        MediaPlayer cScale = MediaPlayer.create(this, R.raw.dscale);
        cScale.start();
    }
}