public static Pokemon createPokemon(Scanner in) {
    System.out.println("Enter Pokémon Name: ");
    String name = in.nextLine();

    System.out.println("Enter Pokémon Attack: ");
    int atk = validateStatInput(in, "Attack");

    System.out.println("Enter Pokémon Defense: ");
    int def = validateStatInput(in, "Defense");

    System.out.println("Enter Pokémon Speed: ");
    int speed = validateStatInput(in, "Speed");

    System.out.println("Enter Pokémon Health: ");
    int health = validateStatInput(in, "Health");

    System.out.println("Enter Pokémon Special Attack: ");
    int spatk = validateStatInput(in, "Special Attack");

    System.out.println("Enter Pokémon Special Defense: ");
    int spdef = validateStatInput(in, "Special Defense");

    System.out.println("Enter Pokémon's first type: ");
    String type1 = in.nextLine();

    System.out.println("Enter Pokémon's second type (Enter 'none' if there is no second type): ");
    String type2 = in.nextLine();
    String[] type = type2.equalsIgnoreCase("none") ? new String[]{type1} : new String[]{type1, type2};

    return new Pokemon(name, type, atk, def, spatk, spdef, health, speed);
}

private static int validateStatInput(Scanner in, String statName) {
    int stat;
    while (true) {
        try {
            System.out.printf("Enter %s (0-255): ", statName);
            stat = in.nextInt();
            if (stat >= 0 && stat <= 255) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a value between 0 and 255.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            in.next(); // Clear invalid input
        }
    }
    return stat;
}
