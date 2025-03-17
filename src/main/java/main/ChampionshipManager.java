package main;

import java.util.ArrayList;
import java.util.List;

/** this class manages the championship. gets drivers and race results. */
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> raceResults = new ArrayList<>();

    /** constructor
     * 
     */
    private ChampionshipManager() {}

    /**
     * @return instance of ChampionshipManager
     */
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RallyRaceResult result) {
        raceResults.add(result);
    }
    /**
     * @return list of drivers
     */
    public List<Driver> getChampionshipStandings() {
        drivers.sort((d1, d2) -> Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));
        return drivers;
    }

    public Driver getLeadingDriver() {
        return getChampionshipStandings().get(0);
    }

    public int calculateTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
    /**
     * @return list of race results
     */
    public List<RallyRaceResult> getRaceResults() {
        return raceResults;
    }
}