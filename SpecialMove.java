public class SpecialMove implements Moves {
    private String type;
    private int basePower;
    private double accuracy;
    private int priority;
    private int numHits;

    public SpecialMove(String type, int basePower, double accuracy, int priority) {
        this.type = type;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getBasePower() {
        return basePower;
    }

    @Override
    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public int getNumHits()
    {
        return numHits;
    }
    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        double typeMultiplier = new TypeChart().getMultiplier(type, defender.getType());
        return basePower * ((double) attacker.getSpatk() / defender.getSpdef()) * typeMultiplier;
    }
}
