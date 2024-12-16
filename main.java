import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Pokemon[] player = new Pokemon[6];
        int numPokemon = 0;
        TypeChart test = new TypeChart();
        Scanner in = new Scanner(System.in);

        Moves fireMove = new SpecialMove("Flamethrower", "Fire", 90, 100);
        Moves waterMove = new SpecialMove("Hydro Pump", "Water", 110, 80);
        Moves grassMove = new SpecialMove("Leaf Blade", "Grass", 90, 100);
        Moves electricMove = new SpecialMove("Thunderbolt", "Electric", 90, 100);
        Moves iceMove = new SpecialMove("Ice Beam", "Ice", 90, 100);
        Moves fightingMove = new PhysicalMove("Close Combat", "Fighting", 120, 100);
        Moves poisonMove = new SpecialMove("Sludge Bomb", "Poison", 90, 100);
        Moves groundMove = new PhysicalMove("Earthquake", "Ground", 100, 100);
        Moves flyingMove = new SpecialMove("Air Slash", "Flying", 75, 95);
        Moves psychicMove = new SpecialMove("Psychic", "Psychic", 90, 100);
        Moves bugMove = new PhysicalMove("X-Scissor", "Bug", 80, 100);
        Moves rockMove = new PhysicalMove("Rock Slide", "Rock", 75, 90);
        Moves ghostMove = new SpecialMove("Shadow Ball", "Ghost", 80, 100);
        Moves dragonMove = new SpecialMove("Dragon Pulse", "Dragon", 85, 100);
        Moves darkMove = new SpecialMove("Dark Pulse", "Dark", 80, 100);
        Moves steelMove = new PhysicalMove("Iron Head", "Steel", 80, 100);
        Moves fairyMove = new SpecialMove("Moonblast", "Fairy", 95, 100);
        
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
            in.nextLine();
            System.out.println("Enter the pokemon's first type: ");
            String type1 = in.nextLine();
            System.out.println("Enter the pokemon's second type(Enter none if there is no second type): ");
            String type2 = in.nextLine();
            String[] type = {type1, type2.equalsIgnoreCase("none") ? null : type2};

            ArrayList<Move> moves = new ArrayList<>();
            if (type1.equalsIgnoreCase("Fire") || type2.equalsIgnoreCase("Fire")) moves.add(fireMove);
            if (type1.equalsIgnoreCase("Water") || type2.equalsIgnoreCase("Water")) moves.add(waterMove);
            if (type1.equalsIgnoreCase("Grass") || type2.equalsIgnoreCase("Grass")) moves.add(grassMove);
            if (type1.equalsIgnoreCase("Electric") || type2.equalsIgnoreCase("Electric")) moves.add(electricMove);
            if (type1.equalsIgnoreCase("Ice") || type2.equalsIgnoreCase("Ice")) moves.add(iceMove);
            if (type1.equalsIgnoreCase("Fighting") || type2.equalsIgnoreCase("Fighting")) moves.add(fightingMove);
            if (type1.equalsIgnoreCase("Poison") || type2.equalsIgnoreCase("Poison")) moves.add(poisonMove);
            if (type1.equalsIgnoreCase("Ground") || type2.equalsIgnoreCase("Ground")) moves.add(groundMove);
            if (type1.equalsIgnoreCase("Flying") || type2.equalsIgnoreCase("Flying")) moves.add(flyingMove);
            if (type1.equalsIgnoreCase("Psychic") || type2.equalsIgnoreCase("Psychic")) moves.add(psychicMove);
            if (type1.equalsIgnoreCase("Bug") || type2.equalsIgnoreCase("Bug")) moves.add(bugMove);
            if (type1.equalsIgnoreCase("Rock") || type2.equalsIgnoreCase("Rock")) moves.add(rockMove);
            if (type1.equalsIgnoreCase("Ghost") || type2.equalsIgnoreCase("Ghost")) moves.add(ghostMove);
            if (type1.equalsIgnoreCase("Dragon") || type2.equalsIgnoreCase("Dragon")) moves.add(dragonMove);
            if (type1.equalsIgnoreCase("Dark") || type2.equalsIgnoreCase("Dark")) moves.add(darkMove);
            if (type1.equalsIgnoreCase("Steel") || type2.equalsIgnoreCase("Steel")) moves.add(steelMove);
            if (type1.equalsIgnoreCase("Fairy") || type2.equalsIgnoreCase("Fairy")) moves.add(fairyMove);

            player[i] = new Pokemon(name, type, atk, def, spatk, spdef, health, speed, moves);
            numPokemon++;
            System.out.println("Do you want to add more pokemon to your team?(y/n)");
            if (in.next().equalsIgnoreCase("n")) {
                in.nextLine();
                break;
            }
            in.nextLine();
        }
    }
}
