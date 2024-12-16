/**
 * a class to represent a special move
 */
public class SpecialMove implements Moves {
    private String type;
    private int basePower;
    private double accuracy;
    private int priority;
    private int numHits;

    /**
     *
     * @param type the typing of the move
     * @param basePower the base power of the move
     * @param accuracy the accuracy of the move
     * @param priority the priority of the move
     */

    public SpecialMove(String type, int basePower, double accuracy, int priority) {
        this.type = type;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    /**
     *
     * @return the type of the move
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @return base power of the move
     */
    @Override
    public int getBasePower() {
        return basePower;
    }

    /**
     *
     * @return accuracy of the move
     */
    @Override
    public double getAccuracy() {
        return accuracy;
    }

    /**
     *
     * @return priority of the move
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     *
     * @return the number of hits that the move would deal
     */
    public int getNumHits()
    {
        return numHits;
    }

    /**
     *
     * @param attacker attacking pokemon
     * @param defender defending pokemon
     * @return the damage the move would deal with the pokemon damage formula
     */
    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        double typeMultiplier = new TypeChart().getMultiplier(type, defender.getType());
        return basePower * ((double) attacker.getSpatk() / defender.getSpdef()) * typeMultiplier;
    }
}
