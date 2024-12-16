/**
 * a class to represent a physical move
 * @author Nicholas Kicinski and Yejun Shin
 */
public class PhysicalMove implements Moves {
    private String type;
    private int basePower;
    private double accuracy;
    private int priority;

    /**
     * initializes the physical move
     * @param type the typing of the move
     * @param basePower the base power of the move
     * @param accuracy the accuracy of the move
     * @param priority the priority of the move
     */

    public PhysicalMove(String type, int basePower, double accuracy, int priority) {
        this.type = type;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    /**
     *
     * @param attacker attacking pokemon
     * @param defender defending pokemon
     * @return the damage using the pokemon damage formula
     */
    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        double typeMultiplier = new TypeChart().getMultiplier(this.type, defender.getType());
        return ((2 * attacker.getAtk() / defender.getDef() + 5) * basePower / 50) * typeMultiplier;
    }

    /**
     *
     * @return the base power of the move
     */
    @Override
    public int getBasePower() {
        return basePower;
    }

    /**
     *
     * @return the typing of the move
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @return the number of hits that the moves deals
     */
    @Override
    public int getNumHits() {
        return 1;
    }

    /**
     *
     * @return the priority of the move
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     *
     * @return the accuracy of the move
     */
    @Override
    public double getAccuracy() {
        return accuracy;
    }
}
