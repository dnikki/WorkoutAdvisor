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

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    // Declare the views here
    // so that we can use them anywhere.
    private ListView exerciseListView;
    private Button checkBtn;
    private Button beginnerBtn;
    private Button hardBtn;
    private Spinner spinner;
    private LottieAnimationView animationView;
    private String type;

    // We can use this TAG anywhere to debug certain points of the code base.
    public String TAG = "mainActivity.BodyPart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Keeping the onCreate method clean.
        Init();

        setUpTheSpinner();

        // Here we have implemented the functionality using interface methods.
        spinner.setOnItemSelectedListener(this);

        // It is generally to avoid Null pointer exceptions.
        checkBtn.setOnClickListener(view -> {
            type="Intermediate";
            Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        });
        beginnerBtn.setOnClickListener(view -> {
            type="Beginner";
            Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        });
        hardBtn.setOnClickListener(view -> {
            type="Hard";
            Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // This method will be called whenever the activity is created.
        // this will invisible the animation.
        animationView.setVisibility(View.GONE);
    }

    private void setUpTheSpinner() {
        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.workout_types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void Init() {
        // Initializing all the useful views in a single method.
        exerciseListView = findViewById(R.id.exercise_list_view);
        checkBtn = findViewById(R.id.check_exercise_btn);
        beginnerBtn = findViewById(R.id.beginner);
        hardBtn = findViewById(R.id.hard);
        spinner = findViewById(R.id.spinner);
        animationView = findViewById(R.id.exercise_animation);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // This method will be called whenever the new item has been selected.
        // this is generally the context of this whole activity.

        // We are extracting the item here from the spinner.
        String bodyPart = spinner.getSelectedItem().toString();
        Log.i(TAG,bodyPart);

        Workoutlist workoutList = new Workoutlist();
        ArrayAdapter<String> workoutListAdapter = new ArrayAdapter<>(
                this, // context
                android.R.layout.simple_list_item_1, // inbuilt XML provided by google
                workoutList.getworkouts(bodyPart) // getting the list from the util class.
        );

        // all the selection and showing the items in a view is handled by this adapter.
        // Advance way is to use Recycler View.
        exerciseListView.setAdapter(workoutListAdapter);

        animationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing is selected till now.", Toast.LENGTH_SHORT).show();
    }
}