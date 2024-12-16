import java.util.HashMap;

/**
 * Creates a type chart and uses it to return damage multipliers
 */
public class TypeChart {
    // [Attacker, Defender]
    private final HashMap<String, Double> chart = new HashMap<>();

    /**
     * initializes the type chart
     */
    public TypeChart()
    {
        chart.put("Normal Rock", 0.5);
        chart.put("Normal Ghost", 0.0);
        chart.put("Normal Steel", 0.5);
        chart.put("Fire Fire", 0.5);
        chart.put("Fire Water", 0.5);
        chart.put("Fire Grass", 2.0);
        chart.put("Fire Ice", 2.0);
        chart.put("Fire Bug", 2.0);
        chart.put("Fire Rock", 0.5);
        chart.put("Fire Dragon", 0.5);
        chart.put("Fire Steel", 2.0);
        chart.put("Water Fire", 2.0);
        chart.put("Water Water", 0.5);
        chart.put("Water Grass", 0.5);
        chart.put("Water Ground", 2.0);
        chart.put("Water Rock", 2.0);
        chart.put("Water Dragon", 0.5);
        chart.put("Electric Water", 2.0);
        chart.put("Electric Electric", 0.5);
        chart.put("Electric Grass", 0.5);
        chart.put("Electric Ground", 0.0);
        chart.put("Electric Flying", 2.0);
        chart.put("Electric Dragon", 0.5);
        chart.put("Grass Fire", 0.5);
        chart.put("Grass Water", 2.0);
        chart.put("Grass Grass", 0.5);
        chart.put("Grass Poison", 0.5);
        chart.put("Grass Ground", 2.0);
        chart.put("Grass Flying", 0.5);
        chart.put("Grass Bug", 0.5);
        chart.put("Grass Rock", 2.0);
        chart.put("Grass Dragon", 0.5);
        chart.put("Grass Steel", 0.5);
        chart.put("Ice Fire", 0.5);
        chart.put("Ice Water", 0.5);
        chart.put("Ice Grass", 2.0);
        chart.put("Ice Ice", 0.5);
        chart.put("Ice Ground", 2.0);
        chart.put("Ice Flying", 0.5);
        chart.put("Ice Dragon", 2.0);
        chart.put("Ice Steel", 0.5);
        chart.put("Fighting Normal", 2.0);
        chart.put("Fighting Ice", 2.0);
        chart.put("Fighting Poison", 0.5);
        chart.put("Fighting Flying", 0.5);
        chart.put("Fighting Psychic", 0.5);
        chart.put("Fighting Bug", 0.5);
        chart.put("Fighting Rock", 2.0);
        chart.put("Fighting Ghost", 0.0);
        chart.put("Fighting Dark", 2.0);
        chart.put("Fighting Steel", 2.0);
        chart.put("Fighting Fairy", 0.5);
        chart.put("Poison Grass", 2.0);
        chart.put("Poison Poison", 0.5);
        chart.put("Poison Ground", 0.5);
        chart.put("Poison Rock", 0.5);
        chart.put("Poison Ghost", 0.5);
        chart.put("Poison Steel", 0.0);
        chart.put("Poison Fairy", 2.0);
        chart.put("Ground Fire", 2.0);
        chart.put("Ground Electric", 2.0);
        chart.put("Ground Grass", 0.5);
        chart.put("Ground Poison", 2.0);
        chart.put("Ground Flying", 0.0);
        chart.put("Ground Bug", 0.5);
        chart.put("Ground Rock", 2.0);
        chart.put("Ground Steel", 2.0);
        chart.put("Flying Electric", 0.5);
        chart.put("Flying Grass", 2.0);
        chart.put("Flying Fighting", 2.0);
        chart.put("Flying Bug", 2.0);
        chart.put("Flying Rock", 0.5);
        chart.put("Flying Steel", 0.5);
        chart.put("Psychic Fighting", 2.0);
        chart.put("Psychic Poison", 2.0);
        chart.put("Psychic Psychic", 0.5);
        chart.put("Psychic Dark", 0.0);
        chart.put("Psychic Steel", 0.5);
        chart.put("Bug Fire", 0.5);
        chart.put("Bug Grass", 2.0);
        chart.put("Bug Fighting", 0.5);
        chart.put("Bug Poison", 0.5);
        chart.put("Bug Flying", 0.5);
        chart.put("Bug Psychic", 2.0);
        chart.put("Bug Ghost", 0.5);
        chart.put("Bug Dark", 2.0);
        chart.put("Bug Steel", 0.5);
        chart.put("Bug Fairy", 0.5);
        chart.put("Rock Fire", 2.0);
        chart.put("Rock Ice", 2.0);
        chart.put("Rock Fighting", 0.5);
        chart.put("Rock Ground", 0.5);
        chart.put("Rock Flying", 2.0);
        chart.put("Rock Bug", 2.0);
        chart.put("Rock Steel", 0.5);
        chart.put("Ghost Normal", 0.0);
        chart.put("Ghost Psychic", 2.0);
        chart.put("Ghost Ghost", 2.0);
        chart.put("Ghost Dark", 0.5);
        chart.put("Dragon Dragon", 2.0);
        chart.put("Dragon Steel", 0.5);
        chart.put("Dragon Fairy", 0.0);
        chart.put("Dark Fighting", 0.5);
        chart.put("Dark Psychic", 2.0);
        chart.put("Dark Ghost", 2.0);
        chart.put("Dark Dark", 0.5);
        chart.put("Dark Fairy", 0.5);
        chart.put("Steel Fire", 0.5);
        chart.put("Steel Water", 0.5);
        chart.put("Steel Electric", 0.5);
        chart.put("Steel Ice", 2.0);
        chart.put("Steel Rock", 2.0);
        chart.put("Steel Steel", 0.5);
        chart.put("Steel Fairy", 2.0);
        chart.put("Fairy Fire", 0.5);
        chart.put("Fairy Fighting", 2.0);
        chart.put("Fairy Poison", 0.5);
        chart.put("Fairy Dragon", 2.0);
        chart.put("Fairy Dark", 2.0);
        chart.put("Fairy Steel", 0.5);
    }

    /**
     *
     * @param attacker the move's typing
     * @param defender the defender's typing
     * @return damage multiplier based off of typing
     */
    public double getMultiplier(String attacker, String[] defender)
    {
        double mult = 1;
        for (String s : defender) {
            mult *= chart.getOrDefault(attacker + " " + s, 1.0);
        }
        return mult;
    }
}
