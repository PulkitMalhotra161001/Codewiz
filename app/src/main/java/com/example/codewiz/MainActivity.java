package com.example.codewiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
    private static Intent java;
    String[] questions={"Only character or integer can be used in switch statement.?","The return type of malloc function is void.?","#define is known as preprocessor compiler directive.?","Algorithm is the graphical representation of logic.?","sizeof( ) is a function that returns the size of a variable.?",
            "The ++ operator increments the operand by 1, whereas, the -- operator decrements it by 1.?","It is necessary that a loop counter must only be an int. It cannot be a float.?","A zero value is considered to be false and a non-zero value is considered to be true.?",
    "= is used for comparison, whereas, == is used for assignment of two quantities.?","Blank spaces may be inserted between two words to improve the readability of the statement.?"};
    boolean[] answer={false,false,true,false,false,true,false,true,false,true};
    private int score=0;
    private int index=0;
    Button yes,no,again;

//    Button no;
//    Button again;
    TextView question,point;
    TextView tick,cross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        again=findViewById(R.id.again);
        point=findViewById(R.id.point);
        tick=findViewById(R.id.tick);
        cross=findViewById(R.id.cross);



        again.setVisibility(View.INVISIBLE);
        yes.setVisibility(View.VISIBLE);
        no.setVisibility(View.VISIBLE);
        point.setVisibility(View.INVISIBLE);
//        tick.setVisibility(View.INVISIBLE);
//        cross.setVisibility(View.INVISIBLE);



//        AlphaAnimation fadeIn = new AlphaAnimation(0.0f , 1.0f ) ;
//        AlphaAnimation fadeOut = new AlphaAnimation( 1.0f , 0.0f ) ;
//        fadeIn.setDuration(100);
//        fadeIn.setFillAfter(true);
//
//        fadeOut.setDuration(100);
//        fadeOut.setFillAfter(true);
//        fadeOut.setStartOffset(800+fadeIn.getStartOffset());

        question=findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(view -> {
            if(index<questions.length){
                if(answer[index])
                    score++;

                index++;
                if(index<questions.length){
                    question.setText(questions[index]);
                }
                else{
                    yes.setVisibility(View.INVISIBLE);
                    no.setVisibility(View.INVISIBLE);
                    point.setVisibility(View.VISIBLE);
                    point.setText("Your score is "+score+" out of "+questions.length);

                }
                if(index==questions.length)
                    again.setVisibility(View.VISIBLE);
            }
        });

        no.setOnClickListener(view -> {
            if(index<questions.length){
                if(!answer[index])
                    score++;
                index++;
                if(index<questions.length){
                    question.setText(questions[index]);
                }
                else{
                    yes.setVisibility(View.INVISIBLE);
                    no.setVisibility(View.INVISIBLE);
                    point.setText("Your score is "+score+" out of "+questions.length);
                    point.setVisibility(View.VISIBLE);
                }
                if(index==questions.length)
                    again.setVisibility(View.VISIBLE);
            }
        });

    }

    public void againClicked(View v) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}