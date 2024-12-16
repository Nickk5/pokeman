public interface Moves {
    double getDamage(Pokemon attacker, Pokemon defender);
    String getType();
    int getBasePower();
    int getNumHits();
    int getPriority();
    double getAccuracy();
}
