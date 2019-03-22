import Species.Pokemon;
import Species.PokemonException;
/** Node for a PokeTree.

@author Evan Paresa
@since 2017-11-20
*/
public class PokeNode {
   /** Pokémon. */
   private Pokemon pokemon;
   /** Amount of Pokémon captured. */
   private int captured;
   /** Left child of the PokeNode. */
   private PokeNode childL;
   /** Right child of the PokeNode. */
   private PokeNode childR;
   /** Constructor.
   
   @param p Pokémon object
   @param numCaught number of Pokémon caught
   @param lChild default left child
   @param rChild default right child */
   public PokeNode(Pokemon p, int numCaught, PokeNode lChild, PokeNode rChild) {
      if (p != null && numCaught >= 1) { 
         pokemon = p;
         captured = numCaught;
         childL = lChild;
         childR = rChild;
      }
      else {
         throw new PokemonException("Invalid inputs!");
      }
   }
   /** Pokémon.
   @return Pokémon object. */
   public Pokemon getPokemon() {
      return pokemon;
   }
   /** Pokédex number.
   @return Pokédex number. */
   public int getKey() {
      return pokemon.getNumber();
   }
   /** Amount of Pokémon captured.
   @return Amount of Pokémon captured. */
   public int getNumCaught() {
      return captured;
   }
   /** @return PokeNode left child. */
   public PokeNode getLChild() {
      return childL;
   }
   /** @return PokeNode right child. */
   public PokeNode getRChild() {
      return childR;
   }
   /** Increases captured amount by 1. */
   public void increaseNumCaught() {
      ++captured;
   }
   /** Decreases captured amount by 1 iff captured amount is more than 1. */
   public void decreaseNumCaught() {
      if (captured >= 1) {
         --captured;
      }
      else {
         throw new PokemonException("Cannot have less than 1 caught!");
      }
   }
   /** Sets new left child for PokeNode.
   @param newLChild new left child */
   public void setLChild(PokeNode newLChild) {
      childL = newLChild;
   }
   /** Sets new right child for PokeNode.
   @param newRChild new right child */
   public void setRChild(PokeNode newRChild) {
      childR = newRChild;
   }
}