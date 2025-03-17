package main;

public interface RaceResult {
    void recordResult(Driver driver, int position);
    String getResults();
}
