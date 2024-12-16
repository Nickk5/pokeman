import java.util.Random;

/**
 * Class representing a non-player character (NPC) Pokemon.
 * The NPC Pokemon can randomly choose moves based on the current battle situation.
 */
public class NPCPokemon extends Pokemon {

    private Moves[] moves;

    /**
     * Constructor for an NPC Pokemon.
     * 
     * @param name The name of the Pokemon.
     * @param type The types of the Pokemon (primary and secondary).
     * @param atk The attack stat of the Pokemon.
     * @param def The defense stat of the Pokemon.
     * @param spatk The special attack stat of the Pokemon.
     * @param spdef The special defense stat of the Pokemon.
     * @param hp The health points of the Pokemon.
     * @param spd The speed stat of the Pokemon.
     * @param moves The moves the NPC Pokemon knows.
     */
    public NPCPokemon(String name, String[] type, int atk, int def, int spatk, int spdef, int hp, int spd, Moves[] moves) {
        super(name, type, atk, def, spatk, spdef, hp, spd, moves);
        this.moves = moves;
    }

    /**
     * Chooses the best move for the NPC to use against the given target Pokemon.
     * The move is selected based on its potential damage, considering the type advantage.
     * 
     * @param target The opposing Pokemon the move will target.
     * @return The best move for the NPC Pokemon to use.
     */
    public Moves chooseMove(Pokemon target) {
        if (moves == null || moves.length == 0) {
            throw new IllegalStateException("No moves available for NPC");
        }

        Moves bestMove = null;
        double maxDamage = 0;
        TypeChart typeChart = new TypeChart();

        for (Moves move : moves) {
            double typeMultiplier = typeChart.getMultiplier(move.getType(), target.getType());
            double potentialDamage = move.getDamage(this, target) * typeMultiplier;
            if (potentialDamage > maxDamage) {
                maxDamage = potentialDamage;
                bestMove = move;
            }
        }

        return bestMove != null ? bestMove : moves[new Random().nextInt(moves.length)]; // Default to a random move
    }

    /**
     * Generates a random NPC Pokemon with stats based on the current battle round.
     * 
     * @param round The current battle round, which affects the strength of the NPC Pokemon.
     * @return A randomly generated NPC Pokemon.
     */
    public static NPCPokemon generateRandomNPC(int round) {
        Random rand = new Random();

        String[] possibleTypes = {"Fire", "Water", "Grass", "Electric", "Ice", "Fighting", "Poison", "Ground", "Flying", "Psychic", "Bug", "Rock", "Ghost", "Dragon", "Dark", "Steel", "Fairy"};
        String type1 = possibleTypes[rand.nextInt(possibleTypes.length)];
        String type2 = rand.nextBoolean() ? possibleTypes[rand.nextInt(possibleTypes.length)] : "none";
        String[] types = type2.equals("none") ? new String[]{type1} : new String[]{type1, type2};

        int baseStat = 50 + round * 10; // Scaling with rounds
        int atk = rand.nextInt(baseStat) + 10;
        int def = rand.nextInt(baseStat) + 10;
        int spatk = rand.nextInt(baseStat) + 10;
        int spdef = rand.nextInt(baseStat) + 10;
        int hp = rand.nextInt(baseStat) + 30;
        int spd = rand.nextInt(baseStat) + 10;

        // Generate random moves
        Moves[] moves = new Moves[4];
        for (int i = 0; i < 4; i++) {
            moves[i] = generateRandomMove(types[rand.nextInt(types.length)]);
        }

        return new NPCPokemon("RandomNPC" + rand.nextInt(1000), types, atk, def, spatk, spdef, hp, spd, moves);
    }

    /**
     * Generates a random move for the NPC Pokemon based on the given type.
     * 
     * @param type The type of the move.
     * @return A randomly generated move.
     */
    private static Moves generateRandomMove(String type) {
        Random rand = new Random();
        int basePower = rand.nextInt(50) + 50; // Random base power
        double accuracy = 0.8 + (rand.nextDouble() * 0.2); // Accuracy between 0.8 and 1.0
        int priority = rand.nextBoolean() ? 1 : 0; // Some moves have priority
        return new PhysicalMove(type, basePower, accuracy, priority);
    }
}
