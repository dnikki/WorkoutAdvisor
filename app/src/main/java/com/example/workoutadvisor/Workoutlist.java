package com.example.workoutadvisor;

import java.util.ArrayList;
import java.util.List;

public class Workoutlist {
    List<String> list = new ArrayList<>();

    // if their are more than 3 conditions ->
    // Switch is better than nested if else
    List<String> getworkouts(String bodyPart) {
        switch (bodyPart) {
            case "Chest":
                list.add("Barbell Bench Press");
                list.add("Pushups");
                list.add("Dips");
                list.add("Chest Press");
                list.add("Cable Crossover");
                break;
            case "Shoulders":
                list.add("High Pull");
                list.add("Trap Raise");
                list.add("Front Raise");
                list.add("Barbell Overhead Press");
                list.add("Standing Dumbbell Fly");
                break;
            case "Abs":
                list.add("Plank");
                list.add("Dead Bug");
                list.add("Dumbbell side bend");
                list.add("Barbell Back Squat");
                list.add("Bird Dog");
                break;
            case "Biceps":
                list.add("Dumbbell Curl");
                list.add("Hammer Curl");
                list.add("Preacher Curl");
                list.add("Cable Bar Curl");
                list.add("Cable Hammer Curl");
                break;
            case "Triceps":
                list.add("Narrow Push-up");
                list.add("Triceps Bow");
                list.add("Forearm Triceps Extension");
                list.add("Power Triceps Extension");
                list.add("Bench Dip with Elevated Legs");
                break;
            case "Back":
                list.add("Quadruped Dumbbell Row");
                list.add("Lat Pulldown");
                list.add("Wide Dumbbell Row");
                list.add("Barbell Deadlift");
                list.add("Reverse Fly");
                break;
            default:
                return list;
        }
        return list;
    }
}
