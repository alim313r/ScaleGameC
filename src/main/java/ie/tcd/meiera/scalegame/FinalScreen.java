package ie.tcd.meiera.scalegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        String extras = getIntent().getStringExtra("gamePoints");
        TextView points = findViewById(R.id.points);
        points.setText(extras);
    }

}