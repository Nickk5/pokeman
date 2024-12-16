import java.util.Scanner;

public class Battle {

    public void startBattle(Pokemon player, NPCPokemon npc) {
        Scanner in = new Scanner(System.in);
        System.out.println("A battle has started between " + player.getName() + " and " + npc.getName());

        boolean battleOver = false;
        while (!battleOver) {
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
                npc.inflictDamage(playerMove.getDamage(player, npc));
                System.out.println(npc.getName() + " took damage, HP is now " + npc.getHp());
            } else {
                System.out.println("Invalid choice. Please select a valid move.");
                continue;  // Skip the current loop iteration if the move is invalid
            }

            // Check if NPC Pokemon is fainted
            if (npc.getHp() <= 0) {
                System.out.println(npc.getName() + " has fainted! " + player.getName() + " wins!");
                battleOver = true;
                break;
            }

            // NPC's turn
            npcTurn(player, npc);

            // Check if Player Pokemon is fainted
            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " has fainted! " + npc.getName() + " wins!");
                battleOver = true;
            }
        }
    }

    private void npcTurn(Pokemon player, NPCPokemon npc) {
        System.out.println(npc.getName() + "'s turn!");
        Moves npcMove = npc.chooseMove(player); // NPC chooses a move
        System.out.println(npc.getName() + " used " + npcMove.getType() + "!");
        player.inflictDamage(npcMove.getDamage(npc, player));
        System.out.println(player.getName() + " took damage, HP is now " + player.getHp());
    }
}
