import java.util.HashMap;
public class TypeChart {
    // [Attacker, Defender]
    private HashMap<String, Double> chart = new HashMap<String, Double>();
    //hard coding each type combination kill me now
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
    }

    public double getMultiplier(String attacker, String defender)
    {
        return chart.getOrDefault(attacker + " " + defender, 1.0);
    }
}
