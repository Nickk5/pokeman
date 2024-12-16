import java.util.*;

public class speedAlgorithm {
    public speedAlgorithm() {
    }

    public Queue<Pokemon> speedCheck(Pokemon[] pokemon) {
        HashMap<Integer, Pokemon> speed = new HashMap<>();
        Queue<Pokemon> ret = new LinkedList<Pokemon>();
        for (Pokemon el : pokemon) {
            speed.put(el.getSpd(), el);
        }
        while(!speed.isEmpty())
        {
            int max = -100;
            for (int i : speed.keySet()) {
                if (i > max) {
                    max = i;
                }
            }
            ret.add(speed.get(max));
        }

        return ret;
    }
}