import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //variables used to create pokemon or to use the type chart
        Pokemon[] player = new Pokemon[6];
        int numPokemon = 0;
        TypeChart test = new TypeChart();
        Scanner in = new Scanner(System.in);

        // Premade moves
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

        //Arary list of the premade moves
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

        //creates the pokemon
        for (int i = 0; i < player.length; i++) {
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
            in.nextLine(); // Consume the newline character
            System.out.println("Enter the pokemon's first type: ");
            String type1 = in.nextLine();
            System.out.println("Enter the pokemon's second type(Enter none if there is no second type): ");
            String type2 = in.nextLine();
            String[] type = {type1, type2.equalsIgnoreCase("none") ? null : type2};
            //add moves that the pokemon will know
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
            // instantiates the pokemon
            player[i] = new Pokemon(name, type, atk, def, spatk, spdef, health, speed, moves.toArray(new Moves[0]));
            numPokemon++;
            System.out.println("Do you want to add more pokemon to your team? (y/n)");
            if (in.next().equalsIgnoreCase("n")) {
                in.nextLine(); // Consume the newline character
                break;
            }
            in.nextLine(); // Consume the newline character
        }

        // Generate NPC Pokémon based on round
        int round = 3;
        NPCPokemon npcPokemon = NPCPokemon.generateRandomNPC(round);

        // Start the battle
        Battle battle = new Battle();
        battle.startBattle(player[0], npcPokemon);
    }
}
