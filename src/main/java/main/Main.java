package main;

/** main class for the championship. */
public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France", new GravelCar("Toyota", "Yaris", 380));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new AsphaltCar("Hyundai", "i20", 400));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Puma", 370));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Citroen", "C3", 390));

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        RallyRaceResult race1 = new RallyRaceResult();
        race1.recordResult(driver1, 1);
        race1.recordResult(driver3, 2);
        race1.recordResult(driver2, 3);
        race1.recordResult(driver4, 4);
        manager.recordRaceResult(race1);

        driver1.addPoints(25);
        driver3.addPoints(18);
        driver2.addPoints(15);
        driver4.addPoints(12);

        RallyRaceResult race2 = new RallyRaceResult();
        race2.recordResult(driver2, 1);
        race2.recordResult(driver4, 2);
        race2.recordResult(driver1, 3);
        race2.recordResult(driver3, 4);
        manager.recordRaceResult(race2);

        driver2.addPoints(25);
        driver4.addPoints(18);
        driver1.addPoints(15);
        driver3.addPoints(12);

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        manager.getChampionshipStandings().forEach(System.out::println);

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getTotalPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getChampionshipStandings().size());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces(manager.getRaceResults()));
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getChampionshipStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getChampionshipStandings()));
        System.out.println("Total Championship Points: " + manager.calculateTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult result : manager.getRaceResults()) {
            System.out.println(result.getResults());
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + driver1.getCar().calculatePerformance());
        System.out.println("Asphalt Car Performance: " + driver2.getCar().calculatePerformance());
    }
}
