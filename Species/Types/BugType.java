package Species.Types;
/**
 * Interface for Bug-type Pokémon.
 */
public interface BugType {
   /** Type string. */
   String BUG_TYPE = "Bug";
   /** Type color. */
   String BUG_COLOR = "Olive green";
   /** Type attacks aren't very effective against... */
   String[] BUG_NVE = {"Fairy", "Fighting", "Fire", "Flying",
                       "Ghost", "Poison", "Steel"};
   /** Type attacks are super effective against... */
   String[] BUG_SE = {"Psychic", "Dark", "Grass"};
   /** Type attacks are completely ineffective against... */
   String[] BUG_NE = {};
   /** Fast attacks. The move your Pokémon performs when you tap. */
   String[] BUG_FAST_ATTACKS = {"Struggle Bug", "Bug Bite", "Infestation"};
   /** Special attacks. The move your Pokémon does when you hold. */
   String[] BUG_SPECIAL_ATTACKS = {"Megahorn", "X-Scissor", "Signal Beam",
                                   "Bug Buzz"};
   /** Fast attack power. */
   int[] BUG_FAST_ATK_POWER = {15, 5, 10};
   /** Special attack power. */
   int[] BUG_SPECIAL_ATK_POWER = {90, 45, 75, 90};
}
