import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) {
        Set<Pod> raceWinners = racers; 
        if (distance <= 0) {
            throw new IllegalArgumentException("The race track can't be 0 or negative");
        }
        if (racers.size() == 0) {
            return raceWinners;
        }   
        if (racers.size() == 1) {
            return raceWinners;
        }

        //somehow find a way to see when the race is over remove the pods who didn't make the distance
        double[] podDistances = new double[racers.size()]; //array of total distances for each pod
        for (int i = 0; i < podDistances.length; i++) {
            podDistances[i] = 0.0;
        }
        for (double i = 0; i <= timeLimit; i += timeSlice) {
            for (int v = 0; v < racers.size(); v++) {
                podDistances[v] += ((Pod)raceWinners).distanceTraveled(i, i + timeSlice, 1);
                if (i >= timeLimit && podDistances[v] <= distance) {
                    raceWinners.remove((Pod)(raceWinners));
                }
            }
        }

        return raceWinners;
    }
}
