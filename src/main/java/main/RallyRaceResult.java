package main;

import java.util.HashMap;
import java.util.Map;

/** this class records the results of
 * a rally race. */

public class RallyRaceResult implements RaceResult {
    private Map<Driver, Integer> results = new HashMap<>();
    
    @Override
    public void recordResult(Driver driver, int position) {
        results.put(driver, position);
    }

    @Override
    public String getResults() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Driver, Integer> entry : results.entrySet()) {
            sb.append("Position ").append(entry.getValue()).append(": ").append(entry.getKey().getName()).append("\n");
        }
        return sb.toString();
    } 
}