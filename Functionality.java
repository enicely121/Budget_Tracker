package Budget;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Main Functionality class for project
 *
 * @author Ethan Nicely
 * @version 03/1/25
 */

// use a map with a int key and a int list of values probably a hash map
// check your prevchat reposnses to see how to use localstorage and json files

public class Functionality {
    public int weeklyLimit;

    public Map<String, List<Integer>> map;

    public Functionality() {
        this.map = new HashMap<>();
        this.weeklyLimit = 30;
    }

    // Add a week to the map
    public void addWeek(String week, List<Integer> values) {
        map.put(week, values);
    }

    // Add a value to a week
    public void addValue(String week, int value) {
        if (!map.containsKey(week)) {
            map.put(week, new ArrayList<>()); // Initialize the week with an empty list if it doesn't exist
        }
        map.get(week).add(value);
    }

    public int getWeeklyReturn(String week) {
        int totalSpending = 0;

        // Iterate over week and find the spending for the week
        if (map.containsKey(week)) {
            for (int i = 0; i < map.get(week).size(); i++) {
                totalSpending += map.get(week).get(i);
            }
        }
        return weeklyLimit += totalSpending;
    }

    public void displayWeeklyValues(String week) {
        System.out.println("Week: " + week);
        System.out.println("Weekly Spending: " + getWeeklyReturn(week));
        System.out.println("Remaining: " + (getWeeklyReturn(week)));
    }
}
