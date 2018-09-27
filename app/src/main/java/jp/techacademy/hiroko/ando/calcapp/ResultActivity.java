package jp.techacademy.hiroko.ando.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        float value1 = intent.getFloatExtra("Value1",0);

        TextView textView = (TextView) findViewById(R.id.resultV);
        textView.setText(String.valueOf(value1));
    }
}
