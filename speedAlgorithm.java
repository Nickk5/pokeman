/**
* @author Nicholas Kicinski
*/
import java.util.*;

/**
 * compares two pokemon's speed and makes a queue for which goes first
 */
public class speedAlgorithm {
    /**
     * initializes speedAlgorithm
     */
    public speedAlgorithm() {
    }

    /**
     *
     * @param pokemon an array of pokemon(player pokemon and enemy pokemon)
     * @return a queue of pokemon that goes first
     */
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
