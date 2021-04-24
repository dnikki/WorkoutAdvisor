package com.example.workoutadvisor;

import java.util.ArrayList;
import java.util.List;

public class Workoutlist {
    List<String> getworkouts(String workouttype){
        List<String> list=new ArrayList<String>();
        if(workouttype.equals("Chest")){
            list.add("Barbell Bench Press");
            list.add("Pushups");
            list.add("Dips");
            list.add("Chest Press");
            list.add("Cable Crossover");
        }
        else if(workouttype.equals("Shoulders")){
            list.add("High Pull");
            list.add("Trap Raise");
            list.add("Front Raise");
            list.add("Barbell Overhead Press");
            list.add("Standing Dumbbell Fly");
        }
        else if(workouttype.equals("Abs")){
            list.add("Plank");
            list.add("Dead Bug");
            list.add("Dumbbell side bend");
            list.add("Barbell Back Squat");
            list.add("Bird Dog");
        }
        else if(workouttype.equals("Biceps")){
            list.add("Dumbbell Curl");
            list.add("Hammer Curl");
            list.add("Preacher Curl");
            list.add("Cable Bar Curl");
            list.add("Cable Hammer Curl");
        }
        else if(workouttype.equals("Triceps")){
            list.add("Narrow Push-up");
            list.add("Triceps Bow");
            list.add("Forearm Triceps Extension");
            list.add("Power Triceps Extension");
            list.add("Bench Dip with Elevated Legs");
        }
        else if(workouttype.equals("Back")){
            list.add("Quadruped Dumbbell Row");
            list.add("Lat Pulldown");
            list.add("Wide Dumbbell Row");
            list.add("Barbell Deadlift");
            list.add("Reverse Fly");
        }
        else{
            return list;
        }
        return list;
    }
}
