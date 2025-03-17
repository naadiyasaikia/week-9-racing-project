package main;

import java.util.List;

/** this class calculates statistics for the championship. */
public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .map(Driver::getCountry)
                .distinct()
                .findFirst()
                .orElse("Unknown");
    }
    /* counts total races held
     * 
     */
    public static int countTotalRaces(List<RallyRaceResult> raceResults) {
        return raceResults.size();
    }
}