import java.util.Scanner;

public class main
  {
  public static void main(String[] args)
    {
      Pokemon[] player = new Pokemon[6];
      int numPokemon = 0;
      TypeChart test = new TypeChart();
      Scanner in = new Scanner(System.in);
      for(int i = 0; i < player.length; i++)
      {
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
        String[] type = {type1, type2};
        player[i] = new Pokemon(name, type, atk, def, spatk, spdef, health, speed);
        numPokemon++;
        System.out.println("Do you want to add more pokemon to your team?(y/n)");
        if(in.next().equalsIgnoreCase("n"))
        {
          in.nextLine();
          break;
        }
        in.nextLine();
      }
      // for(int i = 0; i < numPokemon; i++)
      // {
        // System.out.println(test.getMultiplier("Fighting", player[i].getType()));
        //System.out.println(player[i].getName());
      // }
      int numRounds = 0;
      while(true)
      {
        numRounds++;

        break;
      }
      System.out.println("You survived " + numRounds + " rounds!");
    }
  }
