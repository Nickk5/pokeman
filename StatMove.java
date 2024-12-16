/**
 * a move to represent a move that deals no damage but changes the stat of a pokemon
 * @author Yejun Shin
*/
public class StatMove implements Moves {
    private String affectedStat;
    private double changeAmount;
    private double accuracy;
    private int basePower;

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
     * @param affectedStat the stat that is being affected
     * @param changeAmount the amount the affected stat is being changed by
     * @param accuracy the accuracy of the move
     */
    public StatMove(String affectedStat, double changeAmount, double accuracy) {
        this.affectedStat = affectedStat;
        this.changeAmount = changeAmount;
        this.accuracy = accuracy;
        basePower = 0;
    }

    /**
     * changes the affected stat of the target pokemon by the change amount
     * @param target the pokemon's target
     */
    public void applyEffect(Pokemon target) {
        switch (affectedStat.toLowerCase()) {
            case "attack": target.setAtkchange(target.getAtkchange() * changeAmount); break;
            case "defense": target.setDefchange(target.getDefchange() * changeAmount); break;
        }
    }

    /**
     *
     * @param attacker attacking pokemon
     * @param defender defending pokemon
     * @return zero because the move will deal no damage
     */
    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        return 0;
    }

    /**
     *
     * @return no type because status moves have no type
     */
    @Override
    public String getType() {
        return "None";
    }

    /**
     *
     * @return zero because the move does not hit the opponent
     */
    @Override
    public int getNumHits() {
        return 0;
    }

    /**
     *
     * @return priority of the pokemon
     */
    @Override
    public int getPriority() {
        return 0;
    }

    /**
     *
     * @return accuracy of the pokemon
     */
    @Override
    public double getAccuracy() {
        return accuracy;
    }
}
