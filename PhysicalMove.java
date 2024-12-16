public class PhysicalMove implements Moves {
    private String type;
    private int basePower;
    private double accuracy;
    private int priority;

    public PhysicalMove(String type, int basePower, double accuracy, int priority) {
        this.type = type;
        this.basePower = basePower;
        this.accuracy = accuracy;
        this.priority = priority;
    }

    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        double typeMultiplier = new TypeChart().getMultiplier(this.type, defender.getType());
        return ((2 * attacker.getAtk() / defender.getDef() + 5) * basePower / 50) * typeMultiplier;
    }

    @Override
    public int getBasePower() {
        return basePower;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getNumHits() {
        return 1;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public double getAccuracy() {
        return accuracy;
    }
}
