import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

public class PodRace {
    public static Set<Pod> race(double distance, Set<Pod> racers, double timeSlice, double timeLimit) { 
        if (distance <= 0) {
            throw new IllegalArgumentException("The race track can't be 0 or negative");
        }

        Set<Pod> raceWinners = new HashSet<Pod>();
        if (racers.size() == 0) {
            return raceWinners;
        }   

        //creates a HashMap for each pod's distances
        var distances = new HashMap<Pod, Double>();
        for (var p : racers) {
            distances.put(p, 0.0); //intializes keys and values
        }

        for (var t = 0; t <= timeLimit; t += timeSlice) {
            for (var p : racers) { //iterates and updates total distances
                distances.replace(p, distances.get(p) + p.distanceTraveled(t, t + timeSlice, 1));
                if (distances.get(p) >= distance) {
                    raceWinners.add(p);
                }
            }
            //stops the for loop once theres a winner or tie
            if (raceWinners.size() > 0) {
                break;
            }
        }
        return raceWinners;
    }
}
