package jp.techacademy.hiroko.ando.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText fig1;
    EditText fig2;
    public float figure1;
    public float figure2;
    public float fin;
    String aa;
    String bb;
    TextView errortext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fig1 = findViewById(R.id.figure1);
        fig2 = findViewById(R.id.figure2);

        Button plus = (Button) findViewById(R.id.button1plus);
        plus.setOnClickListener(this);

        Button minus = (Button) findViewById(R.id.button2minus);
        minus.setOnClickListener(this);

        Button multi = (Button) findViewById(R.id.button3multi);
        multi.setOnClickListener(this);

        Button division = (Button) findViewById(R.id.button4division);
        division.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        try{
            String aa = fig1.getText().toString();
            String bb = fig2.getText().toString();
            figure1 = Float.parseFloat(aa);
            figure2 = Float.parseFloat(bb);

            if(v.getId() == R.id.button1plus){
                fin= figure1+figure2;
            }else if(v.getId() == R.id.button2minus){
                fin= figure1-figure2;
            }else if(v.getId() == R.id.button3multi){
                fin = figure1*figure2;
            }else if(v.getId() == R.id.button4division){
                if(figure2==0){

                    Snackbar.make(v, "分母が０です", Snackbar.LENGTH_LONG)
                            .show();
                    return;
                }
                fin = figure1/figure2;
            }

            Log.d("aaa",Float.toString(fin));
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("Value1",fin);
            startActivity(intent);
        }catch(Exception e){

            Snackbar.make(v, "正しい数値を入れてください", Snackbar.LENGTH_LONG)
                    .show();
        }




    }
}
