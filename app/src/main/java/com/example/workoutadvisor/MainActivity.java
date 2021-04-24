package com.example.workoutadvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void check(View view) {
        Workoutlist w = new Workoutlist();
        TextView workouts=(TextView)findViewById(R.id.textView);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        String type=String.valueOf(spinner.getSelectedItem());
        List<String> list = w.getworkouts(type);
        StringBuilder s= new StringBuilder();
        for(String work : list){
            s.append(work).append('\n').append("...").append("\n");
        }
        s.append("Done for today");
        workouts.setText(s);

    }
}