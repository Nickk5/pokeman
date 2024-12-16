public interface Moves {
    double getDamage(Pokemon attacker, Pokemon defender);
    String getType();
    int getNumHits();
    int getPriority();
    double getAccuracy();
}
