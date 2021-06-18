package com.example.codewiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] questions={"Only character or integer can be used in switch statement.?","The return type of malloc function is void.?","#define is known as preprocessor compiler directive.?","Algorithm is the graphical representation of logic.?","sizeof( ) is a function that returns the size of a variable.?",
            "The ++ operator increments the operand by 1, whereas, the -- operator decrements it by 1.?","It is necessary that a loop counter must only be an int. It cannot be a float.?","A zero value is considered to be false and a non-zero value is considered to be true.?",
    "= is used for comparison, whereas, == is used for assignment of two quantities.?","Blank spaces may be inserted between two words to improve the readability of the statement.?"};
    boolean[] answer={false,false,true,false,false,true,false,true,false,true};
    private int score=0;
    private int index=0;
    Button yes;
    Button no;
    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        question=findViewById(R.id.question);
        question.setText(questions[index]);

        yes.setOnClickListener(view -> {
            if(index<questions.length){
                if(answer[index]){
                    score++;
                }
                index++;
                if(index<questions.length){
                    question.setText(questions[index]);
                }
                else{
                    Toast.makeText(MainActivity.this, "Your score is "+score+" out of 10", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(MainActivity.this, "Restart Game", Toast.LENGTH_SHORT).show();
            }
        });

        no.setOnClickListener(view -> {
            if(index<questions.length){
                if(!answer[index]){
                    score++;
                }
                index++;
                if(index<questions.length){
                    question.setText(questions[index]);
                }
                else{
                    Toast.makeText(MainActivity.this, "Your score is "+score+" out of 10", Toast.LENGTH_SHORT).show();
                }
            }

            else{
                Toast.makeText(MainActivity.this, "Restart Game", Toast.LENGTH_SHORT).show();
            }
        });

    }
}