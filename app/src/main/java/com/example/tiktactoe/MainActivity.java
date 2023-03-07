package com.example.tiktactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt_restart;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView player1,player2;
    int p1_score=0;
    int p2_score = 0;
    int player=1;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing buttons
        init();
        player1.setText("Player X: 0");
        player2.setText("Player O: 0");
        bt_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count%2==0) {
                    player = player==1?2:1;
                }
                clear();
                player1.setText("Player X: 0");
                player2.setText("Player O: 0");

                p1_score=0;
                p2_score=0;
            }
        });
    }

    private void init(){
        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);
        bt4 = findViewById(R.id.bt_4);
        bt5 = findViewById(R.id.bt_5);
        bt6 = findViewById(R.id.bt_6);
        bt7 = findViewById(R.id.bt_7);
        bt8 = findViewById(R.id.bt_8);
        bt9 = findViewById(R.id.bt_9);
        player1 = findViewById(R.id.player_1);
        player2 = findViewById(R.id.player_2);
        bt_restart = findViewById(R.id.btn_restart);
    }

    public void check(View v){

        Button currButton = (Button) v;
        if (currButton.getText().toString()=="") {
            count++;

            if (player == 1) {
                currButton.setText("X");
                player = 2;
            } else {
                currButton.setText("O");
                player = 1;
            }
            String b = currButton.getText().toString();
            if (count > 4) {
                b1 = bt1.getText().toString();
                b2 = bt2.getText().toString();
                b3 = bt3.getText().toString();
                b4 = bt4.getText().toString();
                b5 = bt5.getText().toString();
                b6 = bt6.getText().toString();
                b7 = bt7.getText().toString();
                b8 = bt8.getText().toString();
                b9 = bt9.getText().toString();

                //Condition
                if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b4.equals("") && b4.equals(b5) && b5.equals(b6)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b7.equals("") && b7.equals(b8) && b8.equals(b9)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b1.equals("") && b4.equals(b1) && b1.equals(b7)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b2.equals("") && b2.equals(b5) && b5.equals(b8)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b3.equals("") && b3.equals(b6) && b9.equals(b6)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b1.equals("") && b1.equals(b5) && b5.equals(b9)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                } else if (!b3.equals("") && b3.equals(b5) && b5.equals(b7)) {
                    Toast.makeText(this, "Winner is : " + b, Toast.LENGTH_SHORT).show();
                    clear();
                    update();
                }
                if (count>=9) {
                    clear();
                    player = player==1?2:1;
                }

            }
        }
    }

    public void update(){
        if (player==1){
            p1_score++;
        }else{
            p2_score++;
        }
        player1.setText("Player X: "+p1_score);
        player2.setText("Player O: "+p2_score);
    }
    public void clear(){
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");

        player = player==1?2:1;

        count=0;
    }
}