package com.example.braintrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    Button go_btu;
    Button butnum1, butnum2 , butnum3 , butnum4 , play_again_btu ;
    TextView textView_time, textView_sum, textView_scrore ,textView_result;

    Random rand=new Random();
    ArrayList<Integer> nums=new ArrayList<Integer>();
    int a,b;
    int score=0;
    int num_of_question=0;
    View.OnClickListener lisenter= new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            go_btu.setVisibility(View.INVISIBLE);
            butnum1.setVisibility(View.VISIBLE);
            butnum2.setVisibility(View.VISIBLE);
            butnum3.setVisibility(View.VISIBLE);
            butnum4.setVisibility(View.VISIBLE);
            textView_time.setVisibility(View.VISIBLE);
            textView_sum.setVisibility(View.VISIBLE);
            textView_scrore.setVisibility(View.VISIBLE);
            textView_result.setVisibility(View.VISIBLE);

            generta_question();
            new CountDownTimer(30100, 1000) {
                @Override
                public void onTick(long l) {
                    textView_time.setText(l/1000+"S");
                }

                @Override
                public void onFinish() {
                    butnum1.setEnabled(false);
                    butnum2.setEnabled(false);
                    butnum3.setEnabled(false);
                    butnum4.setEnabled(false);
                    textView_time.setText(0+"S");

                    textView_result.setText(score+"/"+num_of_question);
                    play_again_btu.setVisibility(View.VISIBLE);
                    play_again_btu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           lisenter.onClick(view);
                           score=0;
                           num_of_question=1;
                           textView_scrore.setText(0+"/"+num_of_question);
                            butnum1.setEnabled(true);
                            butnum2.setEnabled(true);
                            butnum3.setEnabled(true);
                            butnum4.setEnabled(true );
                            textView_result.setVisibility(View.INVISIBLE);
                        }
                    });


                }
            }.start();


        }
        };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go_btu=(Button)findViewById(R.id.go_button);
        butnum1=(Button)findViewById(R.id.num1_button);
        butnum2=(Button)findViewById(R.id.num2_button);
        butnum3=(Button)findViewById(R.id.num3_button);
        butnum4=(Button)findViewById(R.id.num4_button);
        play_again_btu=(Button)findViewById(R.id.play_agin_button) ;
        textView_time=(TextView)findViewById(R.id.textView_time);
        textView_sum=(TextView)findViewById(R.id.textView_sum);
        textView_scrore=(TextView)findViewById(R.id.textView_score);
        textView_result=(TextView)findViewById(R.id.textView_result);




        go_btu.setOnClickListener(lisenter);


        butnum1.setOnClickListener( this);
        butnum2.setOnClickListener(this);
        butnum3.setOnClickListener(this);
        butnum4.setOnClickListener(this);

    }
    void generta_question(){
       ++num_of_question;
       textView_scrore.setText(score +"/"+num_of_question);
        nums.clear();
         a=rand.nextInt(41);
         b=rand.nextInt(41);
        textView_sum.setText(a+"+"+b);
        int correct_answer=rand.nextInt(4);
        for(int i=0 ;i<4 ;i++)
        {
            if(i == correct_answer)
            {
                nums.add(a+b);
            }



            else{
                int wrong_answer=rand.nextInt(81);
                while (wrong_answer == a+b){
                    wrong_answer=rand.nextInt(81);
                }
                nums.add(wrong_answer);}}


        butnum1.setText(nums.get(0).toString());
        butnum2.setText(nums.get(1).toString());
        butnum3.setText(nums.get(2).toString());
        butnum4.setText(nums.get(3).toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.num1_button:{
                if(butnum1.getText().toString()==String.valueOf(a+b))
                {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Correct");
                    score++;


                }
                else {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Wrong");
                }
                textView_scrore.setText(score+"/"+num_of_question);
                generta_question();
                break;
            }
            case R.id.num2_button:{
                if(butnum2.getText().toString()==String.valueOf(a+b))
                {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Correct");
                    score++;


                }
                else {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Wrong");
                }
                textView_scrore.setText(score+"/"+num_of_question);
                generta_question();
                break;
            }
            case R.id.num3_button:{
                if(butnum3.getText().toString()==String.valueOf(a+b))
                {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Correct");
                    score++;


                }
                else {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Wrong");
                }
                textView_scrore.setText(score+"/"+num_of_question);
                generta_question();
                break;
            }
            case R.id.num4_button:{
                if(butnum4.getText().toString()==String.valueOf(a+b))
                {
                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Correct");
                    score++;


                }
                else {

                    textView_result.setVisibility(View.VISIBLE);
                    textView_result.setText("Wrong");
                }
                textView_scrore.setText(score+"/"+num_of_question);
                generta_question();
                break;
            }


        }

    }
}
