import java.util.*;

public class Battle {
    private Pokemon playerPokemon;
    private NPCPokemon npcPokemon;

    public Battle(Pokemon playerPokemon, NPCPokemon npcPokemon) {
        this.playerPokemon = playerPokemon;
        this.npcPokemon = npcPokemon;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A battle has started between " + playerPokemon.getName() + " and " + npcPokemon.getName() + "!");

        // Determine the turn order using speed algorithm
        Pokemon[] battleParticipants = {playerPokemon, npcPokemon};
        speedAlgorithm speedAlg = new speedAlgorithm();
        Queue<Pokemon> turnOrder = speedAlg.speedCheck(battleParticipants);

        while (playerPokemon.getHp() > 0 && npcPokemon.getHp() > 0) {
            Pokemon currentPokemon = turnOrder.poll(); // Get the next Pokémon to act

            // Perform turn based on who is first
            if (currentPokemon.equals(playerPokemon)) {
                playerTurn(scanner);
                if (npcPokemon.getHp() <= 0) {
                    System.out.println(npcPokemon.getName() + " has been defeated!");
                    System.out.println("You win!");
                    return;
                }
            } else {
                npcTurn();
                if (playerPokemon.getHp() <= 0) {
                    System.out.println(playerPokemon.getName() + " has been defeated!");
                    System.out.println("You lose!");
                    return;
                }
            }
            // Recalculate the turn order after each round based on the remaining Pokémon
            turnOrder = speedAlg.speedCheck(new Pokemon[] {playerPokemon, npcPokemon});
        }
    }

    private void playerTurn(Scanner scanner) {
        System.out.println("\nIt's your turn! Choose a move:");

        // List available moves for player
        for (int i = 0; i < playerPokemon.getMoves().length; i++) {
            Moves move = playerPokemon.getMoves()[i];
            System.out.println((i + 1) + ". " + move.getType() + " (Power: " + move.getBasePower() + ", Accuracy: " + move.getAccuracy() + ")");
        }

        // Get player's move choice
        int moveChoice = scanner.nextInt();
        if (moveChoice >= 1 && moveChoice <= playerPokemon.getMoves().length) {
            Moves selectedMove = playerPokemon.getMoves()[moveChoice - 1];
            double damage = selectedMove.getDamage(playerPokemon, npcPokemon);
            npcPokemon.inflictDamage(damage);
            System.out.println(playerPokemon.getName() + " used " + selectedMove.getType() + "!");
            System.out.println(npcPokemon.getName() + " took " + damage + " damage!");
        } else {
            System.out.println("Invalid move. Please choose again.");
            playerTurn(scanner);
        }
    }

    private void npcTurn() {
        Moves npcMove = npcPokemon.chooseMove(playerPokemon);
        double damage = npcMove.getDamage(npcPokemon, playerPokemon);
        playerPokemon.inflictDamage(damage);
        System.out.println(npcPokemon.getName() + " used " + npcMove.getType() + "!");
        System.out.println(playerPokemon.getName() + " took " + damage + " damage!");
    }
}
