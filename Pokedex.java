import Species.*;
import java.util.Scanner;
import java.util.Map;
/** Driver class for PokeTree.
  * 
  * @author Evan Paresa
  * @since 2017-11-20
  */
public class Pokedex {
   /** PokeMap for selecting Pokémon. */
   private static Map<Integer, Pokemon> pkmnlist = PokeMap.map();
   /** Main entry point into program.
     * @param args Command-line arguments. (Not used) 
     */
   public static void main(String[] args) {
      Scanner inputScanner = new Scanner(System.in);
      PokeTree tree = new PokeTree();
      
      System.out.println("-beep beep-"); // realism!
      System.out.println("Welcome to the Pokédex!\n");
      while (true) { // menu loop
         System.out.println("Current options are:");
         
         System.out.println("1 - Catch Pokémon");
         System.out.println("2 - Trade Pokémon");
         System.out.println("3 - Print Pokédex");
         System.out.println("0 - Quit");
         System.out.print("> ");
         
         String input = inputScanner.nextLine().trim();
         
         if (input.equals("0")) {
            System.out.println("Pokédex shutting down. Good-bye!");
            break;
         } else if (input.equals("1")) { // Catch
            Pokemon p = makePokemon();
            // add to tree
            tree.add(p);
            System.out.println(p.getName() + " has been added to the Pokédex!");
         } else if (input.equals("2")) { // Trade
            try {
               Pokemon p = makePokemon();
               // remove from tree
               tree.remove(p);
               System.out.println(p.getName() + " has been traded away.");
               System.out.println("Good-bye, " + p.getName() + "!");
            } catch (PokemonException p) {
               System.out.println(p.getMessage());
            } catch (TreeException t) {
               System.out.println(t.getMessage());
            }
         } else if (input.equals("3")) { // Print
            tree.printPokeTree();
         } else {
            System.out.println("ERROR: Unknown option!");
         }
      }
   }
   /** Making the Pokémon. Uses System.in to instantiate the class object.
     * @return a Pokémon object. 
     */
   public static Pokemon makePokemon() {
      Pokemon p = null;
      Scanner input = new Scanner(System.in); // species selection
      while (p == null) {
         System.out.println("Choose your Pokémon!");
         System.out.println("Choices are:");
         for (Pokemon s : pkmnlist.values()) {
            System.out.println(s.getNumber() + " - " + s.getSpecies());
         }
         System.out.print("> ");
         // species selection chain
         String species = input.nextLine().trim();
         for (Pokemon s : pkmnlist.values()) {
            if (species.equals(String.valueOf(s.getNumber()))) {
               p = s;
            }
         }
         if (p == null) {
            System.out.println("ERROR: Unknown option!"); 
         } // end species selection chain
      }
   
      // name selection
      /* Name selection not required for A7, so commented out *//*
      String n = "";
      System.out.print("Would you like to name your new Pokemon?\n(y/N)"
                       + " (default: N)> ");
      if (input.nextLine().trim().toUpperCase().equals("Y")) {
         System.out.print("What is your " + p.getSpecies()
                           + "'s new name?\n> ");
         n = input.nextLine().trim();
      }
      if (!n.equals("")) { 
         p.setName(n); 
      }
      */
      // complete object
      return p;
   }
}