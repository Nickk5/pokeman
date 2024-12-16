import java.util.HashMap;

public class speedAlgorithm {
    public speedAlgorithm() {
    }

    public static Pokemon speedCheck(Pokemon[] pokemon) {
        HashMap<Integer, Pokemon> speed = new HashMap<>();
        int max = -100;
        for (Pokemon el : pokemon) {
            speed.put(el.getSpd(), el);
        }
        for (int i : speed.keySet()) {
            if (i > max) {
                max = i;
            }
        }
        return speed.get(max);
    }
}