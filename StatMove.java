public class StatMove implements Moves {
    private String affectedStat;
    private double changeAmount;
    private double accuracy;
    private int basePower;

    @Override
    public int getBasePower() {
        return basePower;
    }

    public StatMove(String affectedStat, double changeAmount, double accuracy) {
        this.affectedStat = affectedStat;
        this.changeAmount = changeAmount;
        this.accuracy = accuracy;
        basePower = 0;
    }

    public void applyEffect(Pokemon target) {
        switch (affectedStat.toLowerCase()) {
            case "attack": target.setAtkchange(target.getAtkchange() * changeAmount); break;
            case "defense": target.setDefchange(target.getDefchange() * changeAmount); break;
        }
    }

    @Override
    public double getDamage(Pokemon attacker, Pokemon defender) {
        return 0;
    }

    @Override
    public String getType() {
        return "None";
    }

    @Override
    public int getNumHits() {
        return 0;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public double getAccuracy() {
        return accuracy;
    }
}
