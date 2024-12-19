/** 
* @author Yejun Shin
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * class to simulate a battle
 */
public class Battle {
    TypeChart testing = new TypeChart();
    speedAlgorithm test = new speedAlgorithm();
    /**
     *
     * @param pokemon the pokemon that the player control
     * @param npcPokemon the okemon that the npc controls
     */
    public Battle(Pokemon pokemon, NPCPokemon npcPokemon) {
    }

    /**
     * instantiates battle
     */
    public Battle() {

    }

    /**
     * has the player and the npc's pokemon fight until the battle is over
     * @param player player's pokemon
     * @param npc npc's pokemon
     */
    public void startBattle(Pokemon player, NPCPokemon npc) {
        Scanner in = new Scanner(System.in);
        System.out.println("A battle has started between " + player.getName() + " and " + npc.getName());

        boolean battleOver = false;
        while (!battleOver) {
            Pokemon[] turnOrder = new Pokemon[2];
            turnOrder[0] = player;
            turnOrder[1] = npc;
            Queue<Pokemon> speed;
            speed = test.speedCheck(turnOrder);
            if(!(speed.remove() instanceof NPCPokemon))
            {
                // Player's turn
                System.out.println(player.getName() + "'s turn!");

                // Show the player's available moves
                for (int i = 0; i < player.getMoves().length; i++) {
                    System.out.println((i + 1) + ". " + player.getMoves()[i].getType() + " (Power: "
                            + player.getMoves()[i].getBasePower() + ")");
                }

                // Prompt player to choose a move
                System.out.println("Choose a move by entering the number (1-" + player.getMoves().length + "): ");
                int choice = in.nextInt();
                in.nextLine();  // Consume the newline character

                // Ensure the choice is valid
                if (choice >= 1 && choice <= player.getMoves().length) {
                    Moves playerMove = player.getMoves()[choice - 1];
                    System.out.println(player.getName() + " used " + playerMove.getType() + "!");
                    System.out.println("Multiplier is: " + testing.getMultiplier(playerMove.getType(), npc.getType()));
                    npc.inflictDamage(playerMove.getDamage(player, npc));
                    System.out.println(npc.getName() + " took damage, HP is now " + npc.getHp());
                } else {
                    System.out.println("Invalid choice. Please select a valid move.");
                    continue;  // Skip the current loop iteration if the move is invalid
                }
                if (npc.getHp() <= 0) {
                    System.out.println(npc.getName() + " has fainted! " + player.getName() + " wins!");
                    battleOver = true;
                    break;
                }
                npcTurn(player, npc);
            }
            else
            {
                npcTurn(player, npc);
                System.out.println();
                if (player.getHp() <= 0) {
                    System.out.println(player.getName() + " has fainted! " + npc.getName() + " wins!");
                    battleOver = true;
                    break;
                }
                // Player's turn
                System.out.println(player.getName() + "'s turn!");

                // Show the player's available moves
                for (int i = 0; i < player.getMoves().length; i++) {
                    System.out.println((i + 1) + ". " + player.getMoves()[i].getType() + " (Power: "
                            + player.getMoves()[i].getBasePower() + ")");
                }

                // Prompt player to choose a move
                System.out.println("Choose a move by entering the number (1-" + player.getMoves().length + "): ");
                int choice = in.nextInt();
                in.nextLine();  // Consume the newline character

                // Ensure the choice is valid
                if (choice >= 1 && choice <= player.getMoves().length) {
                    Moves playerMove = player.getMoves()[choice - 1];
                    System.out.println(player.getName() + " used " + playerMove.getType() + "!");
                    System.out.println();
                    System.out.println("Multiplier is: " + testing.getMultiplier(playerMove.getType(), npc.getType()));
                    npc.inflictDamage(playerMove.getDamage(player, npc));
                    System.out.println(npc.getName() + " took damage, HP is now " + npc.getHp());
                } else {
                    System.out.println("Invalid choice. Please select a valid move.");
                    continue;  // Skip the current loop iteration if the move is invalid
                }
                if (npc.getHp() <= 0) {
                    System.out.println(npc.getName() + " has fainted! " + player.getName() + " wins!");
                    battleOver = true;
                    break;
                }
            }

            // Check if Player Pokemon is fainted
            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " has fainted! " + npc.getName() + " wins!");
                battleOver = true;
            }
        }
    }

    /**
     * to simulate the ai using a move
     * @param player the player's pokemon
     * @param npc the npc's pokemon
     */
    private void npcTurn(Pokemon player, NPCPokemon npc) {
        System.out.println(npc.getName() + "'s turn!");
        Moves npcMove = npc.chooseMove(player); // NPC chooses a
        System.out.println();
        System.out.println(npc.getName() + " used " + npcMove.getType() + "!");
        player.inflictDamage(npcMove.getDamage(npc, player));
        System.out.println(player.getName() + " took damage, HP is now " + player.getHp());
    }
}
