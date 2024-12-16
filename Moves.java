/**
 * an interface to represent the move that a pokemon may know
 * @author Nicholas Kicinski and Yejun Shin
 */
public interface Moves {
    /**
     *
     * @param attacker attacking pokemon
     * @param defender defending pokemon
     * @return amount of damage
     */
    double getDamage(Pokemon attacker, Pokemon defender);
    /**
     *
     * @return typing of the move
     */
    String getType();

    /**
     *
     * @return base power of the move
     */
    int getBasePower();

    /**
     *
     * @return number of hits that the move deals
     */
    int getNumHits();

    /**
     *
     * @return priority of the move
     */
    int getPriority();

    /**
     *
     * @return the accuracy of the move
     */
    double getAccuracy();
}
