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

    Moves[] moves = new Moves[4];
    for (int i = 0; i < 4; i++) {
        System.out.printf("Enter type for Move %d: ", i + 1);
        String moveType = in.nextLine();
        System.out.printf("Is Move %d Physical or Special? (Enter 'Physical' or 'Special'): ", i + 1);
        String moveCategory = in.nextLine();
        if (moveCategory.equalsIgnoreCase("Special")) {
            moves[i] = new SpecialMove(moveType, 80, 0.95, 0, "Extra Effect " + (i + 1));
        } else {
            moves[i] = new PhysicalMove(moveType, 80, 0.95, 0);
        }
    }

    return new Pokemon(name, type, atk, def, spatk, spdef, health, speed, moves);
}
