import java.util.Random;

public class NPCPokemon extends Pokemon {
    private Moves[] moves;

    public NPCPokemon(String name, String[] type, int atk, int def, int spatk, int spdef, int hp, int spd, Moves[] moves) {
        super(name, type, atk, def, spatk, spdef, hp, spd);
        this.moves = moves;
    }

    public Moves chooseMove(Pokemon target) {
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

    private static Moves generateRandomMove(String type) {
        Random rand = new Random();
        int basePower = rand.nextInt(50) + 50; // Random base power
        double accuracy = 0.8 + (rand.nextDouble() * 0.2); // Accuracy between 0.8 and 1.0
        int priority = rand.nextBoolean() ? 1 : 0; // Some moves have priority
        return new PhysicalMove(type, basePower, accuracy, priority);
    }
}