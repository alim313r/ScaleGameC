package ie.tcd.meiera.scalegame;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Exercise extends AppCompatActivity {

    public int rightNote = 0, level, points;
    int[] buttons = {R.id.Button1, R.id.correctButton2, R.id.correctButton1, R.id.button4, R.id.correctButton, R.id.Button3, R.id.Button2, R.id.correctButton3};

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog.Builder hintBuilder;
    private AlertDialog dialog;
    private AlertDialog hintDialog;
    private Button next;
    public Button button;
    private TextView feedback;
    private ImageView popupImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    //correct answer: G
    public void select(View v){
        if  (v.getId() == R.id.correctButton) {
            rightNote = 2;
        } else {
            rightNote = 0;
        }

        for (int i=0; i < buttons.length; i++) {
            button = v.findViewById(buttons[i]);
            //button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundBlue));

            if (v.getId() == buttons[i]) {
                button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundYellow));
            }
        }
    }

    //correct answer: C&A
    public void selectSecond(View v){
        if (v.getId() == R.id.correctButton1 || v.getId() == R.id.correctButton2){
            rightNote++;
        } else {
            rightNote = 0;
        }

        for (int i=0; i < buttons.length; i++) {
            button = v.findViewById(buttons[i]);
            //button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundBlue));

            if (v.getId() == buttons[i]) {
                button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundYellow));
            }
        }
    }

    //correct answer: D&F
    public void selectThird(View v){
        if (v.getId() == R.id.correctButton3){
            rightNote = 2;
        } else {
            rightNote = 0;
        }

        for (int i=0; i < buttons.length; i++) {
            button = v.findViewById(buttons[i]);
            //button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundBlue));

            if (v.getId() == buttons[i]) {
                button.setBackgroundColor(getResources().getColor(R.color.templateBackgroundYellow));
            }
        }
    }


    public void check(View view){
//        for (int i=0; i < buttons.length; i++) {
//            view.findViewById(buttons[i]).setBackgroundColor(getResources().getColor(R.color.templateBackgroundBlue));
//        }
        resultPopup();
    }

    public void hint(View view){
        hintPopup();
    }

    public void hintPopup(){
        hintBuilder = new AlertDialog.Builder(this);
        final View popupWindowHint = getLayoutInflater().inflate(R.layout.hint, null);

        next = (Button) popupWindowHint.findViewById(R.id.buttonNext);

        hintBuilder.setView(popupWindowHint);
        hintDialog = hintBuilder.create();
        dialog.setCancelable(false);
        hintDialog.show();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hintDialog.dismiss();
            }
        });
    }

    public void resultPopup() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popupWindow = getLayoutInflater().inflate(R.layout.popup, null);

        next = (Button) popupWindow.findViewById(R.id.buttonNext);
        feedback = (TextView) popupWindow.findViewById(R.id.feedback);
        popupImage = (ImageView) popupWindow.findViewById(R.id.mark);

        if (rightNote == 2) {
            feedback.setText("correct");
            next.setText("continue");
            popupImage.setImageResource(R.drawable.correctmark);
            level++;
            points += 10;
        } else {
            points -= 2;
        }

        dialogBuilder.setView(popupWindow);
        dialog = dialogBuilder.create();
        dialog.setCancelable(false);
        dialog.show();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level == 0) {
                    setContentView(R.layout.activity_exercise);
                } else if (level == 1) {
                    setContentView(R.layout.activity_exercise2);
                } else if (level == 2) {
                    setContentView(R.layout.activity_exercise3);
                } else if (level == 3) {
                    setContentView(R.layout.activity_exercise4);
                } else if (level == 4) {
                    setContentView(R.layout.activity_exercise5);
                } else if (level == 5) {
                    setContentView(R.layout.activity_exercise6);
                } else {
                    Intent intent = new Intent(Exercise.this, FinalScreen.class);
                    //String gamePoints = points + "Points";
                    intent.putExtra("gamePoints", points);
                    startActivity(intent);
                }
                rightNote = 0;
                dialog.dismiss();
            }
        });
    }
}