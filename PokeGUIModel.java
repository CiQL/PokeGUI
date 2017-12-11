import javax.swing.*;
import java.util.*; // Random, Map, PriorityQueue, ArrayDeque
import Species.Pokemon;
public class PokeGUIModel {
   private PokeTree pokedex;
   private PriorityQueue<Pokemon> recentPokemon;
   private ArrayDeque<Pokemon> stack;
   private Map<Integer, Pokemon> pokemonList;
   private Pokemon currentPokemon;
   private int amountCaptured = 0;
   public PokeGUIModel() {
      pokedex = new PokeTree();
      pokemonList = PokeMap.map();
      recentPokemon = new PriorityQueue<Pokemon>();
      stack = new ArrayDeque<Pokemon>();
      amountCaptured = 0;
      currentPokemon = null;
   }
   public String printPokedex() {
      return pokedex.printPokeTree();
   }
   public Pokemon getPokemon(int key) {
      return pokemonList.get(key);
   }
   public Pokemon getCurrentPokemon() {
      return currentPokemon;
   }
   public void setCurrentPokemon(Pokemon p) {
      currentPokemon = p;
   }
   public Pokemon[] getCaptures(boolean recent) {
      ArrayList<Pokemon> arraylist;
      if (recent) {
         arraylist = new ArrayList<Pokemon>(stack.size());
         ArrayDeque<Pokemon> clone = stack.clone();
         for (int i = 0; i < clone.size(); ++i) {
            arraylist.add(clone.pop());
         }
      } else {
         arraylist = new ArrayList<Pokemon>(recentPokemon.size());
         for (Pokemon p : recentPokemon) {
            arraylist.add(p);
         }
      }
      Pokemon[] array = new Pokemon[arraylist.size()];
      arraylist.toArray(array);
      return array;
   }
   public int getCapturedCount() {
      return recentPokemon.size();
   }
   public int getPokeListCount() {
      return pokemonList.size();
   }
   public void capture(Pokemon p) {
      pokedex.add(p);
      recentPokemon.add(p);
      stack.push(p);
   }
}