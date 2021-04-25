package com.example.workoutadvisor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private ListView exerciseListView;
    private Button checkBtn;
    private Spinner spinner;

    public String TAG = "mainActivity.BodyPart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
        setUpTheSpinner();
        spinner.setOnItemSelectedListener(this);

        checkBtn.setOnClickListener(view -> {
            Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        });
    }

    private void setUpTheSpinner() {
        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.workout_types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void Init() {
        exerciseListView = findViewById(R.id.exercise_list_view);
        checkBtn = findViewById(R.id.check_exercise_btn);
        spinner = findViewById(R.id.spinner);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String bodyPart = spinner.getSelectedItem().toString();
        Log.i(TAG,bodyPart);

        Workoutlist workoutList = new Workoutlist();
        ArrayAdapter<String> workoutListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,workoutList.getworkouts(bodyPart));
        exerciseListView.setAdapter(workoutListAdapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing is selected till now.", Toast.LENGTH_SHORT).show();
    }
}