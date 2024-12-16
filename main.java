/**
* @author Nicholas Kicinski and Yejun Shin
*/
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Main class to initialize the player's team of Pokemon and simulate battles.
 * It allows the player to choose moves for their Pokemon and battle NPC Pokemon.
 */
public class Main {

    /**
     * Main method to set up the Pokemon team and simulate battles.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Premade moves initialization
        Moves fireMove = new SpecialMove("Fire", 90, 100, 0);
        Moves waterMove = new SpecialMove("Water", 110, 80, 0);
        Moves grassMove = new SpecialMove("Grass", 90, 100, 0);
        Moves electricMove = new SpecialMove("Electric", 90, 100, 0);
        Moves iceMove = new SpecialMove("Ice", 90, 100, 0);
        Moves fightingMove = new PhysicalMove("Fighting", 120, 100, 0);
        Moves poisonMove = new SpecialMove("Poison", 90, 100, 0);
        Moves groundMove = new PhysicalMove("Ground", 100, 100, 0);
        Moves flyingMove = new SpecialMove("Flying", 75, 95, 0);
        Moves psychicMove = new SpecialMove("Psychic", 90, 100, 0);
        Moves bugMove = new PhysicalMove("Bug", 80, 100, 0);
        Moves rockMove = new PhysicalMove("Rock", 75, 90, 0);
        Moves ghostMove = new SpecialMove("Ghost", 80, 100, 0);
        Moves dragonMove = new SpecialMove("Dragon", 85, 100, 0);
        Moves darkMove = new SpecialMove("Dark", 80, 100, 0);
        Moves steelMove = new PhysicalMove("Steel", 80, 100, 0);
        Moves fairyMove = new SpecialMove("Fairy", 95, 100, 0);
        Moves statMove = new StatMove("Attack", 2, 100);

        ArrayList<Moves> premadeMoves = new ArrayList<>();
        premadeMoves.add(fireMove);
        premadeMoves.add(waterMove);
        premadeMoves.add(grassMove);
        premadeMoves.add(electricMove);
        premadeMoves.add(iceMove);
        premadeMoves.add(fightingMove);
        premadeMoves.add(poisonMove);
        premadeMoves.add(groundMove);
        premadeMoves.add(flyingMove);
        premadeMoves.add(psychicMove);
        premadeMoves.add(bugMove);
        premadeMoves.add(rockMove);
        premadeMoves.add(ghostMove);
        premadeMoves.add(dragonMove);
        premadeMoves.add(darkMove);
        premadeMoves.add(steelMove);
        premadeMoves.add(fairyMove);
        premadeMoves.add(statMove);

        Pokemon[] player = new Pokemon[6];
        int numPokemon = 0;

        // Create player Pokemon
        for (int i = 0; i < player.length; i++) {
            // Get player input for Pokemon details
            System.out.println("Enter Pokemon Name: ");
            String name = in.nextLine();
            System.out.println("Enter pokemon atk: ");
            int atk = in.nextInt();
            System.out.println("Enter pokemon def: ");
            int def = in.nextInt();
            System.out.println("Enter pokemon speed: ");
            int speed = in.nextInt();
            System.out.println("Enter pokemon health: ");
            int health = in.nextInt();
            System.out.println("Enter pokemon spatk: ");
            int spatk = in.nextInt();
            System.out.println("Enter pokemon spdef: ");
            int spdef = in.nextInt();
            in.nextLine();  // Consume newline
            System.out.println("Enter the pokemon's first type: ");
            String type1 = in.nextLine();
            System.out.println("Enter the pokemon's second type (Enter none if there is no second type): ");
            String type2 = in.nextLine();
            String[] type = {type1, type2.equalsIgnoreCase("none") ? null : type2};

            ArrayList<Moves> moves = new ArrayList<>();
            System.out.println("You can assign up to 4 moves to this Pokemon from the following premade moves:");
            for (int j = 0; j < premadeMoves.size(); j++) {
                Moves move = premadeMoves.get(j);
                System.out.println((j + 1) + ". " + move.getType() + " (Power: " + move.getBasePower() + ", Accuracy: " + move.getAccuracy() + ", Priority: " + move.getPriority() + ")");
            }

            while (moves.size() < 4) {
                System.out.println("Enter the number corresponding to the move you want to add, or enter 0 to stop: ");
                int choice = in.nextInt();
                in.nextLine();

                if (choice == 0) break;
                if (choice > 0 && choice <= premadeMoves.size()) {
                    moves.add(premadeMoves.get(choice - 1));
                    Moves chosenMove = premadeMoves.get(choice - 1);
                    System.out.println(chosenMove.getType() + " move added to " + name + "!");
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }

            player[i] = new Pokemon(name, type, atk, def, spatk, spdef, health, speed, moves.toArray(new Moves[0]));
            numPokemon++;
            System.out.println("Do you want to add more pokemon to your team? (y/n)");
            if (in.next().equalsIgnoreCase("n")) {
                in.nextLine(); // Consume the newline character
                break;
            }
            in.nextLine(); // Consume the newline character
        }

        // Start multiple battles
        boolean continueBattling = true;
        while (continueBattling) {
            // Generate NPC Pokémon based on round
            int round = 3;
            NPCPokemon npcPokemon = NPCPokemon.generateRandomNPC(round);

            // Start the battle
            Battle battle = new Battle();
            battle.startBattle(player[0], npcPokemon);

            // Ask the player if they want to continue battling
            System.out.println("Do you want to start a new battle? (y/n)");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("n")) {
                continueBattling = false;
            }
        }
    }
}
